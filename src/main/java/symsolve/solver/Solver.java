package symsolve.solver;


import korat.finitization.impl.Finitization;
import korat.finitization.impl.StateSpace;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.candidates.CandidateBuilder;
import symsolve.candidates.PredicateChecker;
import symsolve.config.SymSolveConfig;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.explorers.impl.AbstractVectorStateSpaceExplorer;
import symsolve.utils.Helper;
import symsolve.vector.SymSolveSolution;
import symsolve.vector.SymSolveVector;

public class Solver {

    VectorStateSpaceExplorer symbolicVectorSpaceExplorer;
    CandidateBuilder candidateBuilder;
    Finitization finitization;
    PredicateChecker predicateChecker;

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
        for (Integer index : symbolicVectorSpaceExplorer.getAccessedIndices().toArray()) {
            if (vector.isSymbolicIndex(index))
                return true;
        }
        return false;
    }

    public SymSolveSolution startSearch(SymSolveVector initialVector) throws CannotInvokePredicateException {
        if (symbolicVectorSpaceExplorer.canBeDeterminedUnsat(initialVector))
            return null;
        symbolicVectorSpaceExplorer.initialize(initialVector);
        int[] vector = symbolicVectorSpaceExplorer.getCandidateVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate)) {
                return new SymSolveSolution(
                        initialVector,
                        symbolicVectorSpaceExplorer.getCandidateVector(),
                        symbolicVectorSpaceExplorer.getAccessedIndices()
                );
            }
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return null;
    }

    public SymSolveSolution getNextSolution(SymSolveVector previousSolutionVector) throws CannotInvokePredicateException {
        assert (!symbolicVectorSpaceExplorer.canBeDeterminedUnsat(previousSolutionVector));
        symbolicVectorSpaceExplorer.initialize(previousSolutionVector);

        int[] vector = symbolicVectorSpaceExplorer.getCandidateVector();
        Object candidate = candidateBuilder.buildCandidate(vector);
        assert (predicateChecker.checkPredicate(candidate));  // Do not remove, checkPredicate call is necessary
        vector = symbolicVectorSpaceExplorer.getNextCandidate();

        while (vector != null) {
            candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate)) {
                return new SymSolveSolution(
                        previousSolutionVector,
                        symbolicVectorSpaceExplorer.getCandidateVector(),
                        symbolicVectorSpaceExplorer.getAccessedIndices()
                );
            }
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return null;
    }
    
    public Finitization getFinitization() {
        return finitization;
    }
}
