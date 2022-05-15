package symsolve;

import java.lang.reflect.Method;
import java.util.HashMap;

import korat.finitization.IFinitization;
import korat.finitization.impl.CVElem;
import korat.finitization.impl.CandidateBuilder;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.Finitization;
import korat.finitization.impl.ObjSet;
import korat.finitization.impl.StateSpace;
import korat.loading.InstrumentingClassLoader;
import korat.testing.ITester;
import korat.testing.impl.AbstractTestCaseGenerator;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import korat.utils.IIntList;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.explorers.VectorStateSpaceExplorerFactory;
import symsolve.explorers.impl.SymbolicVectorExplorerFactory;
import symsolve.utils.Helper;

public class Solver extends AbstractTestCaseGenerator implements ITester {

    private static Solver instance = new Solver();

    protected ClassLoader classLoader;

    private boolean traceStarted;

    private Solver() {
        classLoader = new InstrumentingClassLoader();
        Finitization.setClassLoader(classLoader);
    }

    public static Solver getInstance() {
        return instance;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    // Implementation of ITester interface:

    public void startFieldTrace() {
        traceStarted = true;
        accessedFields.clear();
    }

    public void continueFieldTrace() {
        traceStarted = true;
    }

    public void stopFieldTrace() {
        traceStarted = false;
    }

    public void notifyFieldAccess(Object obj, String field) {
        if (!traceStarted)
            return;
        int accessedFieldIndex = stateSpace.getIndexInCandidateVector(obj, field);
        if (accessedFieldIndex != -1)
            accessedFields.add(accessedFieldIndex);
    }

    public void notifyFieldAccess(int accessedFieldIndex) {
        if (!traceStarted)
            return;
        if (accessedFieldIndex != -1)
            accessedFields.add(accessedFieldIndex);
    }

    // Info that listeners may query in the middle of the search process:

    public int[] getCandidateVector() {
        return this.symbolicVectorSpaceExplorer.getCandidateVector().clone();
    }

    public boolean isPredicateOK() {
        return predicateOK;
    }

    public IIntList getAccessedFields() {
        return this.symbolicVectorSpaceExplorer.getAccessedFields();
    }

    public StateSpace getStateSpace() {
        return stateSpace;
    }

    // Search related:

    private StateSpace stateSpace;

    private IIntList accessedFields;

    private boolean predicateOK;

    private Method predicate;

    private VectorStateSpaceExplorer symbolicVectorSpaceExplorer;

    private CandidateBuilder candidateBuilder;

    protected void initialize(ConfigParameters params) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {
        Class<?> clazz = classLoader.loadClass(params.getFullyQualifiedClassName());
        String[] finArgs = params.getFinitizationArgs();
        Method finMethod = Helper.getFinMethod(clazz, params.getFinitizationName(), finArgs);
        IFinitization fin = Helper.invokeFinMethod(clazz, finMethod, finArgs);
        this.predicate = Helper.getPredicateMethod(fin.getFinClass(), "repOK");
        this.stateSpace = ((Finitization) fin).getStateSpace();
        VectorStateSpaceExplorerFactory heapExplorerFactory = new SymbolicVectorExplorerFactory(this.stateSpace);
        this.symbolicVectorSpaceExplorer = heapExplorerFactory
                .makeSymoblicVectorExplorer(params.getExplorationStretegy());
        this.accessedFields = this.symbolicVectorSpaceExplorer.getAccessedFields();
        IIntList changedFields = this.symbolicVectorSpaceExplorer.getChangedFields();
        candidateBuilder = new CandidateBuilder(stateSpace, changedFields);
    }

    public boolean runAutoHybridRepok(SymbolicVector initialVector) throws CannotInvokePredicateException {
        int[] vector = initialVector.getConcreteVector();
        Object candidate = candidateBuilder.buildCandidate(vector);
        if (!checkPredicate(candidate) && !symbolicFieldsAccessed(initialVector))
            return false;
        return true;
    }

    private boolean symbolicFieldsAccessed(SymbolicVector vector) {
        for (int i = 0; i < accessedFields.numberOfElements(); i++) {
            int index = accessedFields.get(i);
            if (vector.isSymbolicIndex(index))
                return true;
        }
        return false;
    }

    public boolean startSolverExploration(SymbolicVector initialVector) throws CannotInvokePredicateException {
        this.symbolicVectorSpaceExplorer.initialize(initialVector);
        int[] vector = initialVector.getConcreteVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (checkPredicate(candidate))
                return true;
            vector = this.symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return false;
    }

    private boolean checkPredicate(Object testCase) throws CannotInvokePredicateException {
        startFieldTrace();
        try {
            return (Boolean) predicate.invoke(testCase, (Object[]) null);
        } catch (Exception e) {
            throw new CannotInvokePredicateException(testCase.getClass(), predicate.getName(), e.getMessage(), e);
        } finally {
            stopFieldTrace();
        }
    }

    public HashMap<String, Integer> getBounds() {
        HashMap<String, Integer> bounds = new HashMap<String, Integer>();
        CVElem[] structureList = stateSpace.getStructureList();
        for (int i = 0; i < structureList.length; i++) {
            FieldDomain fieldDomain = structureList[i].getFieldDomain();
            if (!fieldDomain.isPrimitiveType()) {
                String classSimpleName = fieldDomain.getClassOfField().getSimpleName();
                if (!bounds.containsKey(classSimpleName)) {
                    int bound = fieldDomain.getNumberOfElements();
                    if (((ObjSet) fieldDomain).isNullAllowed())
                        bound--;
                    bounds.put(classSimpleName, bound);
                }
            }
        }
        return bounds;
    }

}
