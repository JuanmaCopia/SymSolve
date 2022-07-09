package symsolve;


import korat.finitization.impl.*;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import korat.utils.IIntList;
import korat.utils.IntListAI;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.explorers.VectorStateSpaceExplorerFactory;
import symsolve.explorers.impl.SymbolicVectorExplorerFactory;
import symsolve.explorers.impl.SymmetryBreakStrategy;
import symsolve.utils.CodeGenerator;
import symsolve.utils.Helper;
import symsolve.utils.Utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solver {

    StateSpace stateSpace;
    VectorStateSpaceExplorer symbolicVectorSpaceExplorer;
    CandidateBuilder candidateBuilder;
    CodeGenerator codeGenerator;
    IIntList accessedIndices;
    Class<?> rootClass;
    Finitization finitization;

    PredicateChecker predicateChecker;

    public Solver(ConfigParameters params) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {

        rootClass = Finitization.getClassLoader().loadClass(params.getFullyQualifiedClassName());

        String[] finArgs = params.getFinitizationArgs();
        Method finMethod = Helper.getFinMethod(rootClass, params.getFinitizationName(), finArgs);
        finitization = Helper.invokeFinMethod(rootClass, finMethod, finArgs);

        stateSpace = finitization.getStateSpace();
        int vectorSize = stateSpace.getTotalNumberOfFields();
        accessedIndices = new IntListAI(vectorSize);
        IIntList changedFields = new IntListAI(vectorSize);

        predicateChecker = PredicateChecker.getInstance();
        predicateChecker.initialize(rootClass, params.getPredicateName(), accessedIndices);

        candidateBuilder = new CandidateBuilder(stateSpace, changedFields);
        codeGenerator = new CodeGenerator(stateSpace, rootClass);

        VectorStateSpaceExplorerFactory heapExplorerFactory = new SymbolicVectorExplorerFactory(stateSpace, accessedIndices, changedFields);
        SymmetryBreakStrategy strategy = params.getsymmetryBreakStretegy();
        symbolicVectorSpaceExplorer = heapExplorerFactory.makeSymoblicVectorExplorer(strategy);
    }

    public int[] getCandidateVector() {
        return this.symbolicVectorSpaceExplorer.getCandidateVector().clone();
    }

    public StateSpace getStateSpace() {
        return stateSpace;
    }

    public boolean runAutoHybridRepok(SymSolveVector vector) throws CannotInvokePredicateException {
        this.symbolicVectorSpaceExplorer.initialize(vector);
        Object candidate = this.candidateBuilder.buildCandidate(vector.getConcreteVector());
        if (predicateChecker.checkPredicate(candidate))
            return true;
        return areSymbolicFieldsAccessed(vector);
    }

    private boolean areSymbolicFieldsAccessed(SymSolveVector vector) {
        for (int i = 0; i < accessedIndices.numberOfElements(); i++) {
            int index = accessedIndices.get(i);
            if (vector.isSymbolicIndex(index))
                return true;
        }
        return false;
    }

    public boolean startSearch(SymSolveVector initialVector) throws CannotInvokePredicateException {
        System.out.println("\nStarting search for vector: ");

        symbolicVectorSpaceExplorer.initialize(initialVector);
        int[] vector = symbolicVectorSpaceExplorer.getCandidateVector();
        Utils.printVectorFormat(vector, stateSpace.getStructureList());
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate))
                return true;
            vector = this.symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return false;
    }

    public boolean searchOtherSolution(SymSolveVector initialVector) throws CannotInvokePredicateException {
        runRepOK(initialVector);
        this.symbolicVectorSpaceExplorer.setInitializedFields();
        int[] vector = this.symbolicVectorSpaceExplorer.getNextCandidate();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate))
                return true;
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return false;
    }

    public boolean runRepOK(SymSolveVector vector) throws CannotInvokePredicateException {
        symbolicVectorSpaceExplorer.initialize(vector);
        Object candidate = this.candidateBuilder.buildCandidate(vector.getConcreteVector());
        return predicateChecker.checkPredicate(candidate);
    }

    public Set<int[]> getAllSolutions(SymSolveVector initialVector) throws CannotInvokePredicateException {
        symbolicVectorSpaceExplorer.initialize(initialVector);
        int[] vector = symbolicVectorSpaceExplorer.getCandidateVector();
        Set<int[]> solutions = new HashSet<>();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate))
                solutions.add(vector.clone());
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return solutions;
    }

    /*public Bounds calculateBounds() throws CannotInvokePredicateException {
        Bounds bounds = new Bounds(stateSpace);
        SymSolveVector initialVector = new SymSolveVector(stateSpace.getTotalNumberOfFields());
        symbolicVectorSpaceExplorer.initialize(initialVector);
        int[] vector = symbolicVectorSpaceExplorer.getCandidateVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate))
                bounds.recordBounds(vector);
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return bounds;
    }*/

    public HashMap<String, Integer> getScopes() {
        HashMap<String, Integer> bounds = new HashMap<>();
        CVElem[] structureList = stateSpace.getStructureList();
        for (CVElem cvElem : structureList) {
            FieldDomain fieldDomain = cvElem.getFieldDomain();
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

    public String generateStructureCode(int[] vector) {
        return codeGenerator.generateStructureCode(vector);
    }

    public Map<String, IntSet> getIntegerFieldsMinMaxMap() {
        return finitization.getIntegerFieldsMinMaxMap();
    }

}
