package eval;

import eval.config.EvalConfig;
import eval.explorers.Evaluator;
import eval.results.Results;


public class PredicateEvaluator {

    EvalConfig config;
    private Evaluator evaluator;

    /**
     * Creates a SymSolve instance according to the provides configuration parameters.
     *
     * @param config The configuration parameters.
     */
    public PredicateEvaluator(EvalConfig config) {
        this.config = config;
        try {
            evaluator = new Evaluator(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Results evaluatePredicate() {
        //System.out.println("start search");
        Results results = null;
        try {
            results = evaluator.startEvaluation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }


    // public static void main(String[] args) {
    //     SolverConfig config = new BruteConfig();
    //     Brute brute = new Brute(config);
    //     brute.isSatisfiable("1,2,3,4,5,6,7,8,9,10");
    // }

}
