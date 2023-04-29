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


    public int[] getUniqueIdentifier() {
        int[] queryPartialVector = query.createPartialVector();
        return getUniqueIdentifier(queryPartialVector, solutionVector);
    }

    public static int[] getUniqueIdentifier(int[] a1, int[] a2) {
        int[] identifier = new int[a1.length + a2.length + 1];
        System.arraycopy(a1, 0, identifier, 0, a1.length);
        System.arraycopy(a2, 0, identifier, a1.length + 1, a2.length);
        identifier[a1.length] = -999;
        return identifier;
    }

}
