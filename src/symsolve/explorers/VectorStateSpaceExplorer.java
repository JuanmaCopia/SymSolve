package symsolve.explorers;

import korat.utils.IIntList;
import symsolve.SymSolveVector;

public interface VectorStateSpaceExplorer {

    public IIntList getAccessedFields();

    public IIntList getChangedFields();

    public int[] getCandidateVector();

    public void initialize(SymSolveVector vector);

    public int[] getNextCandidate();
    
    public void resetChangedFields();

}
