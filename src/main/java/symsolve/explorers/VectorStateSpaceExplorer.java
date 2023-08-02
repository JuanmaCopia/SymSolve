package symsolve.explorers;

import korat.utils.IntListAI;
import symsolve.vector.SymSolveVector;

public interface VectorStateSpaceExplorer {

    boolean canBeDeterminedUnsat(SymSolveVector vector);

    int[] getCandidateVector();


    void initialize(SymSolveVector vector);

    int[] getNextCandidate();

    IntListAI getAccessedIndices();

    IntListAI getChangedFields();

    IntListAI getFixedIndices();

    int getVectorSize();
}
