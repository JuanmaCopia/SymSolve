package symsolve.bounds.visitors;

import korat.finitization.impl.StateSpace;
import symsolve.bounds.Bounds;
import symsolve.bounds.LabelSets;
import symsolve.candidates.traversals.BFSCandidateTraversal;
import symsolve.candidates.traversals.CandidateTraversal;
import symsolve.candidates.traversals.visitors.GenericCandidateVisitor;

import java.util.HashSet;
import java.util.Set;

public class LabelSetCalculator extends GenericCandidateVisitor {


    LabelSets labelSets;
    StateSpace stateSpace;


    public LabelSetCalculator(StateSpace stateSpace, Bounds bounds) {
        this.stateSpace = stateSpace;
        this.labelSets = new LabelSets(bounds);
    }

    @Override
    public void setRoot(Object rootObject, BFSCandidateTraversal.ObjectInfo rootInfo) {
        Set<Integer> rootLabelSet = new HashSet<>();
        rootLabelSet.add(rootInfo.id);
        labelSets.put(rootObject, rootLabelSet);
    }

    @Override
    public void accessedNewReferenceField(Object fieldObject, BFSCandidateTraversal.ObjectInfo fieldObjectInfo) {
        Set<Integer> targetLabelSet = labelSets.calculateTargetLabelSet(currentOwnerObject, currentFieldName);
        labelSets.put(fieldObject, targetLabelSet);
    }

    public LabelSets collectLabelSetsForVector(int[] vector) {
        labelSets.clear();
        CandidateTraversal traverser = new BFSCandidateTraversal(stateSpace);
        traverser.traverse(vector, this);
        return labelSets;
    }

}
