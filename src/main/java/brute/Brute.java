package brute;

import brute.config.BruteConfig;
import brute.explorers.BruteGenerator;


public class Brute {

    BruteConfig config;
    private BruteGenerator generator;

    /**
     * Creates a SymSolve instance according to the provides configuration parameters.
     *
     * @param config The configuration parameters.
     */
    public Brute(BruteConfig config) {
        this.config = config;
        try {
            generator = new BruteGenerator(config);
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
