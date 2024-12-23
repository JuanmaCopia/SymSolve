package test.systemtests.brute;

import brute.Brute;
import brute.config.BruteConfig;
import org.junit.jupiter.api.Test;


public class BruteTests {

    @Test
    public void isSatisfiableTreeMapTest() {
        String className = "symsolve.examples.treemap.TreeMap";
        BruteConfig config = new BruteConfig(className, "2");
        Brute brute = new Brute(config);
        brute.generateStructures();
    }

}
