package eval.explorers;


import eval.config.EvalConfig;
import eval.util.Pair;
import korat.finitization.impl.Finitization;
import korat.finitization.impl.StateSpace;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.candidates.CandidateBuilder;
import symsolve.candidates.PredicateChecker;
import symsolve.utils.Helper;

import java.util.Arrays;
import java.util.Iterator;

public class KoratGeneratorIterator implements Iterator<Pair<Object, Boolean>> {

    CandidateBuilder candidateBuilder;
    Finitization finitization;
    PredicateChecker predicateChecker;
    BoundedExhaustiveExplorer explorer;

    int[] candidateVector;

    public KoratGeneratorIterator(EvalConfig params) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {
        Class<?> rootClass = Helper.loadClass(params.getFullyQualifiedClassName());
        finitization = Helper.getFinitization(rootClass, params.getFinitizationName(), params.getFinitizationArgs());
        predicateChecker = new PredicateChecker();
        finitization.initialize(predicateChecker);
        StateSpace stateSpace = finitization.getStateSpace();
        explorer = new BoundedExhaustiveExplorer(stateSpace);
        predicateChecker.initialize(rootClass, params.getEvaluatedPredicateName(), explorer.getAccessedIndices());
        candidateBuilder = new CandidateBuilder(stateSpace, explorer.getChangedFields());

        // Initialize the candidate vector
        candidateVector = explorer.getCandidateVector();
    }

    @Override
    public boolean hasNext() {
        return candidateVector != null;
    }

    @Override
    public Pair<Object, Boolean> next() {
        Object candidate = candidateBuilder.buildCandidate(candidateVector);
        boolean result = false;
        try {
            result = predicateChecker.checkPredicate(candidate);
        } catch (CannotInvokePredicateException e) {
            throw new RuntimeException(e);
        }
        candidateVector = explorer.getNextCandidate();
        return new Pair<>(candidate, result);
    }

    public void startSearch() throws CannotInvokePredicateException {
        while (candidateVector != null) {
            Object candidate = candidateBuilder.buildCandidate(candidateVector);
            if (predicateChecker.checkPredicate(candidate)) {
                // valid
                System.out.println("valid: " + Arrays.toString(explorer.getCandidateVector()));
            } else {
                // invalid
                System.out.println("invalid: " + Arrays.toString(explorer.getCandidateVector()));
            }
            candidateVector = explorer.getNextCandidate();
        }
    }
}
