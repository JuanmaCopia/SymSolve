package symsolve.explorers;

import symsolve.SymSolveVector;

public interface VectorStateSpaceExplorer {

    int[] getCandidateVector();

    void initialize(SymSolveVector vector);

    int[] getNextCandidate();

    void setInitializedFields();

}
