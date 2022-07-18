package symsolve.candidates.traversals.visitors;

import korat.finitization.impl.StateSpace;
import symsolve.bounds.Bounds;
import symsolve.bounds.LabelSets;
import symsolve.candidates.traversals.BFSCandidateTraverser;
import symsolve.candidates.traversals.CandidateTraverser;

import java.util.HashSet;
import java.util.Set;

public class CollectLabelSetsVisitor extends GenericCandidateVisitor {


    LabelSets labelSets;
    StateSpace stateSpace;


    public CollectLabelSetsVisitor(StateSpace stateSpace, Bounds bounds) {
        this.stateSpace = stateSpace;
        labelSets = new LabelSets(bounds);
    }

    @Override
    public void setRoot(Object rootObject, int rootID) {
        super.setRoot(rootObject, rootID);
        Set<Integer> rootLabelSet = new HashSet<>();
        rootLabelSet.add(rootID);
        labelSets.put(rootObject, rootLabelSet);
    }

    @Override
    public void accessedNewReferenceField(String fieldName, Object fieldObject, int fieldObjectID) {
        Set<Integer> targetLabelSet = labelSets.calculateTargetLabelSet(currentOwnerObject, fieldName);
        if (!targetLabelSet.isEmpty())
            labelSets.put(fieldObject, targetLabelSet);
    }
    
    public LabelSets collectLabelSets(int[] vector) {
        CandidateTraverser traverser = new BFSCandidateTraverser(stateSpace);
        traverser.traverse(vector, this);
        return labelSets;
    }

}
