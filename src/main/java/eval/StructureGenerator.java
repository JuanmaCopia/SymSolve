package eval;

import eval.config.EvalConfig;
import eval.explorers.KoratGeneratorIterator;
import eval.util.CandidateResult;

import java.util.Iterator;


public class StructureGenerator implements Iterator<CandidateResult> {

    EvalConfig config;
    private KoratGeneratorIterator generator;

    /**
     * Creates a SymSolve instance according to the provides configuration parameters.
     *
     * @param config The configuration parameters.
     */
    public StructureGenerator(EvalConfig config) {
        this.config = config;
        try {
            generator = new KoratGeneratorIterator(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateAllStructures() {
        //System.out.println("start search");
        try {
            generator.startSearch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return generator.hasNext();
    }

    @Override
    public CandidateResult next() {
        return generator.next();
    }

}
