package test.systemtests.evaluator;

import eval.PredicateEvaluator;
import eval.config.EvalConfig;
import eval.results.Results;
import org.junit.jupiter.api.Test;


public class EvaluatorTests {

    @Test
    public void isSatisfiableTreeMapTest() {
        String className = "symsolve.examples.treemap.TreeMap";
        EvalConfig config = new EvalConfig(className, "symsolve.examples.treemap.Predicate", "5", "predicate", "repOK", false);
        PredicateEvaluator predicateEvaluator = new PredicateEvaluator(config);
        Results results = predicateEvaluator.evaluatePredicate();
        results.printResults();
/*        assertEquals(1.0, results.getAccuracy());
        assertEquals(1.0, results.getPrecision());
        assertEquals(1.0, results.getRecall());
        assertEquals(1.0, results.getF1Score());
        assertEquals(4, results.getTruePositives());
        assertEquals(31, results.getTrueNegatives());
        assertEquals(0, results.getFalsePositives());
        assertEquals(0, results.getFalseNegatives());*/
    }

}
