package eval.explorers;


import eval.config.EvalConfig;
import eval.executor.PredicateExecutor;
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
    PredicateExecutor evaluatedPredicateExecutor;
    BoundedExhaustiveExplorer explorer;

    boolean validClassValidStructures;

    public Evaluator(EvalConfig params) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {
        Class<?> rootClass = Helper.loadClass(params.getSubjectClassName());

        finitization = Helper.getFinitization(rootClass, params.getFinitizationName(), params.getFinitizationArgs());

        groundTruthChecker = new PredicateChecker();
        finitization.initialize(groundTruthChecker);

        StateSpace stateSpace = finitization.getStateSpace();
        explorer = new BoundedExhaustiveExplorer(stateSpace);
        groundTruthChecker.initialize(rootClass, params.getGroundTruthPredicateName(), explorer.getAccessedIndices());

        evaluatedPredicateExecutor = new PredicateExecutor();
        Class<?> predicateClass = Helper.loadClass(params.getPredicateClassName());
        evaluatedPredicateExecutor.initialize(predicateClass, params.getEvaluatedPredicateName());

        candidateBuilder = new CandidateBuilder(stateSpace, explorer.getChangedFields());

        validClassValidStructures = params.validClassValidStructures;
    }

    public Results startEvaluation() throws CannotInvokePredicateException {
        Results results = new Results();
        int[] vector = explorer.getCandidateVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (groundTruthChecker.checkPredicate(candidate)) {
                // valid
                if (validClassValidStructures) {
                    if (evaluatedPredicateExecutor.executePredicate(candidate)) {
                        results.incrementTruePositives();
                    } else {
                        results.incrementFalseNegatives();
                    }
                } else {
                    if (evaluatedPredicateExecutor.executePredicate(candidate)) {
                        results.incrementTrueNegatives();
                    } else {
                        results.incrementFalsePositives();
                    }
                }
            } else {
                // invalid
                if (validClassValidStructures) {
                    if (evaluatedPredicateExecutor.executePredicate(candidate)) {
                        results.incrementFalsePositives();
                    } else {
                        results.incrementTrueNegatives();
                    }
                } else {
                    if (evaluatedPredicateExecutor.executePredicate(candidate)) {
                        results.incrementFalseNegatives();
                    } else {
                        results.incrementTruePositives();
                    }
                }
            }
            vector = explorer.getNextCandidate();
        }
        return results;
    }

}
