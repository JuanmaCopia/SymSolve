package symsolve.explorers;

import symsolve.vector.SymSolveVector;

public interface VectorStateSpaceExplorer {

    int[] getCandidateVector();

    void initialize(SymSolveVector vector);

    int[] getNextCandidate();

    void setInitializedFields();

}
