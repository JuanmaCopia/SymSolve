package symsolve.bounds;

import korat.finitization.impl.Finitization;
import korat.finitization.impl.StateSpace;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.candidates.CandidateBuilder;
import symsolve.candidates.PredicateChecker;
import symsolve.config.BoundCalculatorConfig;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.explorers.impl.AbstractVectorStateSpaceExplorer;
import symsolve.utils.Helper;
import symsolve.vector.SymSolveVector;

public class BoundCalculator {

    VectorStateSpaceExplorer symbolicVectorSpaceExplorer;
    CandidateBuilder candidateBuilder;
    Finitization finitization;
    PredicateChecker predicateChecker;


    public BoundCalculator(BoundCalculatorConfig params) throws ClassNotFoundException, CannotFindFinitizationException,
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

    public Bounds calculateBounds() throws CannotInvokePredicateException {
        BoundRecorder boundsRecorder = new BoundRecorder(finitization);
        SymSolveVector initialVector = new SymSolveVector(symbolicVectorSpaceExplorer.getVectorSize());
        symbolicVectorSpaceExplorer.initialize(initialVector);
        int[] vector = symbolicVectorSpaceExplorer.getCandidateVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate))
                boundsRecorder.recordBounds(vector);
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return boundsRecorder.getBounds();
    }
}
