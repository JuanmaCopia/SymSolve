package symsolve.candidates.traversals.visitors;

import korat.finitization.impl.StateSpace;
import symsolve.candidates.traversals.BFSCandidateTraverser;
import symsolve.candidates.traversals.CandidateTraverser;

import java.util.HashMap;
import java.util.Map;

public class ObjectIDMapper extends GenericCandidateVisitor {

    StateSpace stateSpace;
    Map<Object, Integer> objectIDs = new HashMap<>();


    public ObjectIDMapper(StateSpace stateSpace) {
        this.stateSpace = stateSpace;
    }

    public Map<Object, Integer> calculateObjectsIDs(int[] vector) {
        CandidateTraverser traverser = new BFSCandidateTraverser(stateSpace);
        traverser.traverse(vector, this);
        return objectIDs;
    }

    @Override
    public void setCurrentOwner(Object currentOwnerObject, int currentOwnerID) {
        super.setCurrentOwner(currentOwnerObject, currentOwnerID);
        objectIDs.put(currentOwnerObject, currentOwnerID);
    }

    @Override
    public void accessedNewReferenceField(String fieldName, Object fieldObject, int fieldObjectID, int indexInVector) {
        if (fieldObject != null)
            objectIDs.put(fieldObject, fieldObjectID);
    }

}
