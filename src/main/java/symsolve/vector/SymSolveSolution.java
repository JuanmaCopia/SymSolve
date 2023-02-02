package symsolve.vector;


import korat.utils.IntListAI;


public final class SymSolveSolution {

    private final SymSolveVector query;
    private final int[] solutionVector;
    private final IntListAI accessedIndices;


    public SymSolveSolution(SymSolveVector query, int[] solutionVector, IntListAI accessedIndices) {
        this.query = query.clone();
        this.solutionVector = solutionVector.clone();
        this.accessedIndices = accessedIndices.clone();
    }

    public int[] getSolutionVector() {
        return solutionVector.clone();
    }

    public IntListAI getQueryFixedIndices() {
        return query.getFixedIndices();
    }

    public IntListAI getAccessedIndices() {
        return accessedIndices.clone();
    }

}
