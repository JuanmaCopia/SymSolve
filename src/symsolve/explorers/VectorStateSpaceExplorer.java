package symsolve.explorers;


import korat.utils.IIntList;
import symsolve.SymbolicVector;

public interface VectorStateSpaceExplorer {
    
    public IIntList getAccessedFields();
    
    public IIntList getChangedFields();

    public int[] getCandidateVector();

    public void initialize(SymbolicVector vector);

    public int[] getNextCandidate();

}
