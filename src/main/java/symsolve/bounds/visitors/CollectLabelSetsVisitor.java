package symsolve.bounds.visitors;

import korat.finitization.impl.StateSpace;
import symsolve.bounds.LabelSets;
import symsolve.candidates.traversals.BFSCandidateTraversal;
import symsolve.candidates.traversals.CandidateTraversal;
import symsolve.candidates.traversals.visitors.GenericCandidateVisitor;

import java.util.HashSet;
import java.util.Set;

public class CollectLabelSetsVisitor extends GenericCandidateVisitor {


    LabelSets labelSets;
    StateSpace stateSpace;


    public CollectLabelSetsVisitor(StateSpace stateSpace, LabelSets labelSets) {
        this.stateSpace = stateSpace;
        this.labelSets = labelSets;
    }

    @Override
    public void setRoot(Object rootObject, int rootID) {
        Set<Integer> rootLabelSet = new HashSet<>();
        rootLabelSet.add(rootID);
        labelSets.put(rootObject, rootLabelSet);
    }

    @Override
    public void accessedNewReferenceField(String fieldName, Object fieldObject, int fieldObjectID) {
        //System.out.println(String.format("Accessed new ref field: %s.%s", currentOwnerObject.getClass(), fieldName));
        Set<Integer> targetLabelSet = labelSets.calculateTargetLabelSet(currentOwnerObject, fieldName);
        //if (!targetLabelSet.isEmpty())
        labelSets.put(fieldObject, targetLabelSet);
    }

    public void collectLabelSetsForVector(int[] vector) {
        labelSets.clear();
        CandidateTraversal traverser = new BFSCandidateTraversal(stateSpace);
        traverser.traverse(vector, this);
    }

}
