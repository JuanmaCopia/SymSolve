package symsolve;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

import korat.finitization.IFinitization;
import korat.finitization.impl.CVElem;
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
import symsolve.explorers.SymbolicVectorExplorerFactory;
import symsolve.explorers.impl.SymbolicVectorExplorer;
import symsolve.explorers.impl.SymbolicVectorExplorerFactoryImpl;
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

    private SymbolicVectorExplorer symbolicVectorSpaceExplorer;

    protected void initialize(ConfigParameters params) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {
        Class<?> clazz = classLoader.loadClass(params.getFullyQualifiedClassName());
        String[] finArgs = params.getFinitizationArgs();
        Method finMethod = Helper.getFinMethod(clazz, params.getFinitizationName(), finArgs);
        IFinitization fin = Helper.invokeFinMethod(clazz, finMethod, finArgs);
        this.predicate = Helper.getPredicateMethod(fin.getFinClass(), "repOK");
        this.stateSpace = ((Finitization) fin).getStateSpace();
        SymbolicVectorExplorerFactory heapExplorerFactory = new SymbolicVectorExplorerFactoryImpl(this.stateSpace);
        this.symbolicVectorSpaceExplorer = heapExplorerFactory
                .makeSymoblicVectorExplorer(params.getExplorationStretegy());
        this.accessedFields = this.symbolicVectorSpaceExplorer.getAccessedFields();
    }

    public boolean runAutoHybridRepok(SymbolicVector vector) throws CannotInvokePredicateException {
        this.symbolicVectorSpaceExplorer.initialize(vector);
        Set<Integer> fixedIndices = vector.getFixedIndices();
        Object candidate = this.symbolicVectorSpaceExplorer.buildCandidate();
        if (checkPredicate(candidate, predicate))
            return true;
        else {
            for (int i = 0; i < accessedFields.numberOfElements(); i++) {
                int index = accessedFields.get(i);
                if (!fixedIndices.contains(index))
                    return true;
            }
        }
        return false;
    }

    public boolean startSolverExploration(SymbolicVector vector) throws CannotInvokePredicateException {
        this.symbolicVectorSpaceExplorer.initialize(vector);
        Object candidate = this.symbolicVectorSpaceExplorer.buildCandidate();
        while (candidate != null) {
            if (checkPredicate(candidate, predicate))
                return true;
            candidate = this.symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return false;
    }

    private boolean checkPredicate(Object testCase, Method predicate) throws CannotInvokePredicateException {
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
