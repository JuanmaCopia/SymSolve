package eval;

import eval.config.EvalConfig;
import eval.explorers.KoratGenerator;


public class Generator {

    EvalConfig config;
    private KoratGenerator generator;

    /**
     * Creates a SymSolve instance according to the provides configuration parameters.
     *
     * @param config The configuration parameters.
     */
    public Generator(EvalConfig config) {
        this.config = config;
        try {
            generator = new KoratGenerator(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateStructures() {
        //System.out.println("start search");
        try {
            generator.startSearch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
