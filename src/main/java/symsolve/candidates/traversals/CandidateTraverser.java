package symsolve.candidates.traversals;

import symsolve.candidates.traversals.visitors.CandidateVisitor;

public interface CandidateTraverser {

    void traverse(int[] vector, CandidateVisitor visitor);
    
}
