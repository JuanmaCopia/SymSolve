package test.systemtests.brute;

import eval.PredicateEvaluator;
import eval.config.KoratGenConfig;
import org.junit.jupiter.api.Test;


public class PredicateEvaluatorTests {

    @Test
    public void isSatisfiableTreeMapTest() {
        String className = "symsolve.examples.treemap.TreeMap";
        KoratGenConfig config = new KoratGenConfig(className, "2");
        PredicateEvaluator predicateEvaluator = new PredicateEvaluator(config);
        predicateEvaluator.generateStructures();
    }

}
