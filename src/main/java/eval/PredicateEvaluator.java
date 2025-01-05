package eval;

import eval.config.KoratGenConfig;
import eval.explorers.KoratGenerator;


public class PredicateEvaluator {

    KoratGenConfig config;
    private KoratGenerator generator;

    /**
     * Creates a SymSolve instance according to the provides configuration parameters.
     *
     * @param config The configuration parameters.
     */
    public PredicateEvaluator(KoratGenConfig config) {
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


    // public static void main(String[] args) {
    //     SolverConfig config = new BruteConfig();
    //     Brute brute = new Brute(config);
    //     brute.isSatisfiable("1,2,3,4,5,6,7,8,9,10");
    // }

}
