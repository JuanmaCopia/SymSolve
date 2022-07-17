package symsolve.candidates.traversals.visitors;

import korat.finitization.IFieldDomain;
import korat.finitization.IObjSet;
import korat.finitization.impl.ObjSet;
import korat.finitization.impl.StateSpace;
import symsolve.bounds.Bounds;
import symsolve.candidates.traversals.BFSCandidateTraverser;
import symsolve.candidates.traversals.CandidateTraverser;

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
    public void accessedNewReferenceField(String fieldName, Object fieldObject, int fieldObjectID, int indexInVector) {
        labelSets.put(fieldObject, calculateTargetLabelSet(currentOwnerObject, fieldName, indexInVector));
    }

    public Set<Integer> calculateTargetLabelSet(Object ownerObject, String fieldName, int indexInVector) {
        Set<Integer> ownerLabelSet = labelSets.get(ownerObject);
        assert (ownerLabelSet != null);
        Set<Integer> targetLabelSet = bounds.getTargets(ownerObject.getClass(), fieldName, ownerLabelSet);

        IFieldDomain fieldDomain = stateSpace.getFieldDomain(indexInVector);
        if (fieldDomain.isPrimitiveType())
            return targetLabelSet;

        IObjSet objSet = (ObjSet) fieldDomain;
        if (objSet.isNullAllowed())
            targetLabelSet.remove(0);

        return targetLabelSet;
    }


    public HashMap<Object, Set<Integer>> calculateLabelSets(int[] vector) {
        CandidateTraverser traverser = new BFSCandidateTraverser(stateSpace);
        traverser.traverse(vector, this);
        return labelSets;
    }

}
