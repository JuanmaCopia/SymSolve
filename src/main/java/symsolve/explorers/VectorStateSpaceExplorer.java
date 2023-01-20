package symsolve.explorers;

import korat.utils.IIntList;
import symsolve.vector.SymSolveVector;

public interface VectorStateSpaceExplorer {

    boolean canBeDeterminedUnsat(SymSolveVector vector);

    int[] getCandidateVector();

    IIntList getAccessedIndices();

    void initialize(SymSolveVector vector);

    int[] getNextCandidate();

    IIntList getChangedFields();
}
