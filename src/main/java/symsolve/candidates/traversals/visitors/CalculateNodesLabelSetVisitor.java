package symsolve.candidates.traversals.visitors;

import korat.finitization.impl.StateSpace;
import symsolve.bounds.Bounds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CalculateNodesLabelSetVisitor extends GenericCandidateVisitor {

    Bounds bounds;
    HashMap<Object, Set<Integer>> labelSets = new HashMap<>();
    StateSpace stateSpace;


    public CalculateNodesLabelSetVisitor(StateSpace stateSpace, Bounds bounds) {
        this.bounds = bounds;
        this.stateSpace = stateSpace;
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
    }

    public Set<Integer> calculateTargetLabelSet() {
        return null;
    }

}
