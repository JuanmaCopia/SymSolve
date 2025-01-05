package eval.explorers;


import eval.config.KoratGenConfig;
import korat.finitization.impl.Finitization;
import korat.finitization.impl.StateSpace;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.candidates.CandidateBuilder;
import symsolve.candidates.PredicateChecker;
import symsolve.utils.Helper;
import symsolve.vector.SymSolveSolution;

public class KoratGenerator {

    CandidateBuilder candidateBuilder;
    Finitization finitization;
    PredicateChecker predicateChecker;
    BoundedExhaustiveExplorer explorer;

    public KoratGenerator(KoratGenConfig params) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {
        Class<?> rootClass = Helper.loadClass(params.getFullyQualifiedClassName());
        finitization = Helper.getFinitization(rootClass, params.getFinitizationName(), params.getFinitizationArgs());
        predicateChecker = new PredicateChecker();
        finitization.initialize(predicateChecker);
        StateSpace stateSpace = finitization.getStateSpace();
        explorer = new BoundedExhaustiveExplorer(stateSpace);
        predicateChecker.initialize(rootClass, params.getPredicateName(), explorer.getAccessedIndices());
        candidateBuilder = new CandidateBuilder(stateSpace, explorer.getChangedFields());
    }

    public SymSolveSolution startSearch() throws CannotInvokePredicateException {
        int[] vector = explorer.getCandidateVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate)) {
                // valid
                //System.out.println("valid: " + Arrays.toString(explorer.getCandidateVector()));
            } else {
                // invalid
                //System.out.println("invalid: " + Arrays.toString(explorer.getCandidateVector()));
            }
            vector = explorer.getNextCandidate();
        }
        return null;
    }

}
