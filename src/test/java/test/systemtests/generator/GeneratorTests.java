package test.systemtests.generator;

import eval.Generator;
import eval.config.EvalConfig;
import org.junit.jupiter.api.Test;


public class GeneratorTests {

    @Test
    public void isSatisfiableTreeMapTest() {
        String className = "symsolve.examples.treemap.TreeMap";
        EvalConfig config = new EvalConfig(className, "2");
        Generator predicateEvaluator = new Generator(config);
        predicateEvaluator.generateStructures();
    }

}
