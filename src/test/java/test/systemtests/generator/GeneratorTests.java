package test.systemtests.generator;

import eval.StructureGenerator;
import eval.config.EvalConfig;
import org.junit.jupiter.api.Test;


public class GeneratorTests {

    @Test
    public void structureGeneratorTest() {
        String className = "symsolve.examples.treemap.TreeMap";
        EvalConfig config = new EvalConfig(className, "", "2", "predicate", "repOK", true);
        StructureGenerator generator = new StructureGenerator(config);
        generator.generateAllStructures();
    }

    @Test
    public void structureGeneratorTest2() {
        String className = "symsolve.examples.treemap.TreeMap";
        EvalConfig config = new EvalConfig(className, "", "2", "predicate", "repOK", true);
        StructureGenerator generator = new StructureGenerator(config);

        System.out.println("\nExploring Candidate Vectors: \n");
        while (generator.hasNext()) {
            System.out.println(generator.next());
        }
    }

}
