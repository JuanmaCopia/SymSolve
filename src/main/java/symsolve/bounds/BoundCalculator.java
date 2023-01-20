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

import java.lang.reflect.Method;

public class BoundCalculator {

    StateSpace stateSpace;
    VectorStateSpaceExplorer symbolicVectorSpaceExplorer;
    CandidateBuilder candidateBuilder;
    Class<?> rootClass;
    Finitization finitization;
    PredicateChecker predicateChecker;


    public BoundCalculator(BoundCalculatorConfig params) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {

        rootClass = Finitization.getClassLoader().loadClass(params.getFullyQualifiedClassName());

        String[] finArgs = params.getFinitizationArgs();
        Method finMethod = Helper.getFinMethod(rootClass, params.getFinitizationName(), finArgs);
        finitization = Helper.invokeFinMethod(rootClass, finMethod, finArgs);
        predicateChecker = new PredicateChecker();
        finitization.initialize(predicateChecker);
        stateSpace = finitization.getStateSpace();

        symbolicVectorSpaceExplorer = AbstractVectorStateSpaceExplorer.makeSymbolicVectorExplorer(params, stateSpace);

        predicateChecker.initialize(rootClass, params.getPredicateName(), symbolicVectorSpaceExplorer.getAccessedIndices());

        candidateBuilder = new CandidateBuilder(stateSpace, symbolicVectorSpaceExplorer.getChangedFields());

    }

    public Bounds calculateBounds() throws CannotInvokePredicateException {
        BoundRecorder boundsRecorder = new BoundRecorder(finitization);
        SymSolveVector initialVector = new SymSolveVector(stateSpace.getTotalNumberOfFields());
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
