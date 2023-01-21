package symsolve.solver;


import korat.finitization.impl.Finitization;
import korat.finitization.impl.StateSpace;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import korat.utils.IIntList;
import korat.utils.IntListAI;
import symsolve.candidates.CandidateBuilder;
import symsolve.candidates.PredicateChecker;
import symsolve.config.SymSolveConfig;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.explorers.impl.AbstractVectorStateSpaceExplorer;
import symsolve.utils.Helper;
import symsolve.vector.SymSolveVector;

import java.lang.reflect.Method;

public class Solver {

    VectorStateSpaceExplorer symbolicVectorSpaceExplorer;
    CandidateBuilder candidateBuilder;
    Finitization finitization;
    PredicateChecker predicateChecker;
    boolean searchInProgress = false;


    public Solver(SymSolveConfig params) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {
        Class<?> rootClass = Helper.loadClass(params.getFullyQualifiedClassName());
        finitization = Helper.getFinitization(rootClass, params.getFinitizationName(), params.getFinitizationArgs());
        predicateChecker = new PredicateChecker();
        finitization.initialize(predicateChecker);
        StateSpace stateSpace = finitization.getStateSpace();
        symbolicVectorSpaceExplorer = AbstractVectorStateSpaceExplorer.makeSymbolicVectorExplorer(params, stateSpace);
        predicateChecker.initialize(rootClass, params.getPredicateName(), symbolicVectorSpaceExplorer.getAccessedIndices());
        candidateBuilder = new CandidateBuilder(stateSpace, symbolicVectorSpaceExplorer.getChangedFields());
    }

    public boolean runAutoHybridRepok(SymSolveVector vector) throws CannotInvokePredicateException {
        symbolicVectorSpaceExplorer.initialize(vector);
        Object candidate = candidateBuilder.buildCandidate(vector.getConcreteVector());
        if (predicateChecker.checkPredicate(candidate))
            return true;
        return areSymbolicFieldsAccessed(vector);
    }

    private boolean areSymbolicFieldsAccessed(SymSolveVector vector) {
        for (Integer index: symbolicVectorSpaceExplorer.getAccessedIndices().toArray()) {
            if (vector.isSymbolicIndex(index))
                return true;
        }
        return false;
    }

    public boolean startSearch(SymSolveVector initialVector) throws CannotInvokePredicateException {
        if (symbolicVectorSpaceExplorer.canBeDeterminedUnsat(initialVector))
            return false;
        searchInProgress = true;
        symbolicVectorSpaceExplorer.initialize(initialVector);
        int[] vector = symbolicVectorSpaceExplorer.getCandidateVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate))
                return true;
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        searchInProgress = false;
        return false;
    }

    public boolean searchNextSolution() throws CannotInvokePredicateException {
        if (!searchInProgress)
            return false;
        int[] vector = symbolicVectorSpaceExplorer.getNextCandidate();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate))
                return true;
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        searchInProgress = false;
        return false;
    }

    public int[] getCandidateVector() {
        return symbolicVectorSpaceExplorer.getCandidateVector().clone();
    }

    public IIntList getAccessedIndices() {
        return symbolicVectorSpaceExplorer.getAccessedIndices();
    }

    public Finitization getFinitization() {
        return finitization;
    }
}
