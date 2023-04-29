package symsolve.vector;


import korat.utils.IntListAI;


public final class SymSolveSolution {

    private final SymSolveVector query;
    private final int[] solutionVector;
    private final IntListAI accessedIndices;
    private final Object rootObject;


    public SymSolveSolution(SymSolveVector query, int[] solutionVector, IntListAI accessedIndices, Object rootObject) {
        this.query = query.clone();
        this.solutionVector = solutionVector.clone();
        this.accessedIndices = accessedIndices.clone();
        this.rootObject = rootObject;
    }

    public SymSolveVector getQuery() {
        return query.clone();
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

    public Object getBuildedSolution() {
        return rootObject;
    }

}