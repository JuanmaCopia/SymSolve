package symsolve.candidates.traversals.visitors;

import korat.finitization.impl.StateSpace;
import symsolve.bounds.LabelSets;
import symsolve.candidates.traversals.BFSCandidateTraverser;
import symsolve.candidates.traversals.CandidateTraverser;

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
        CandidateTraverser traverser = new BFSCandidateTraverser(stateSpace);
        traverser.traverse(vector, this);
    }

}
