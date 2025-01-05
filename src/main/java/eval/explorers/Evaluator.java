package eval.explorers;


import eval.config.EvalConfig;
import eval.results.Results;
import korat.finitization.impl.Finitization;
import korat.finitization.impl.StateSpace;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.candidates.CandidateBuilder;
import symsolve.candidates.PredicateChecker;
import symsolve.utils.Helper;

public class Evaluator {

    CandidateBuilder candidateBuilder;
    Finitization finitization;
    PredicateChecker groundTruthChecker;
    PredicateChecker evaluatedPredicateChecker;
    BoundedExhaustiveExplorer explorer;

    public Evaluator(EvalConfig params) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {
        Class<?> rootClass = Helper.loadClass(params.getFullyQualifiedClassName());
        finitization = Helper.getFinitization(rootClass, params.getFinitizationName(), params.getFinitizationArgs());
        groundTruthChecker = new PredicateChecker();
        finitization.initialize(groundTruthChecker);
        StateSpace stateSpace = finitization.getStateSpace();
        explorer = new BoundedExhaustiveExplorer(stateSpace);
        groundTruthChecker.initialize(rootClass, params.getGroundTruthPredicateName(), explorer.getAccessedIndices());
        evaluatedPredicateChecker = new PredicateChecker();
        evaluatedPredicateChecker.initialize(rootClass, params.getEvaluatedPredicateName(), explorer.getAccessedIndices());
        candidateBuilder = new CandidateBuilder(stateSpace, explorer.getChangedFields());
    }

    public Results startSearch() throws CannotInvokePredicateException {
        Results results = new Results();
        int[] vector = explorer.getCandidateVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (groundTruthChecker.checkPredicate(candidate)) {
                // valid
                if (evaluatedPredicateChecker.callPredicate(candidate)) {
                    results.incrementTruePositives();
                } else {
                    results.incrementFalseNegatives();
                }
                //System.out.println("valid: " + Arrays.toString(explorer.getCandidateVector()));
            } else {
                // invalid
                if (evaluatedPredicateChecker.callPredicate(candidate)) {
                    results.incrementFalsePositives();
                } else {
                    results.incrementTrueNegatives();
                }
                //System.out.println("invalid: " + Arrays.toString(explorer.getCandidateVector()));
            }
            vector = explorer.getNextCandidate();
        }
        return results;
    }

}
