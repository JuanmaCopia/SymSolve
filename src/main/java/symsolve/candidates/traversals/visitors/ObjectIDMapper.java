package symsolve.candidates.traversals.visitors;

import korat.finitization.impl.StateSpace;
import symsolve.candidates.traversals.BFSCandidateTraverser;
import symsolve.candidates.traversals.CandidateTraverser;

import java.util.HashMap;
import java.util.Map;

public class ObjectIDMapper implements CandidateVisitor {

    StateSpace stateSpace;

    Class<?> currentOwnerClass;
    String currentOwnerClassName;
    Object currentOwnerObject;
    int currentOwnerID;

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
        currentOwnerClass = currentOwnerObject.getClass();
        currentOwnerClassName = currentOwnerClass.getName();
        this.currentOwnerObject = currentOwnerObject;
        this.currentOwnerID = currentOwnerID;
        objectIDs.put(currentOwnerObject, currentOwnerID);
    }

    @Override
    public void accessedVisitedReferenceField(String fieldName, Object fieldObject, int fieldObjectID) {
    }

    @Override
    public void accessedNullReferenceField(String fieldName, int fieldObjectID) {
    }

    @Override
    public void accessedNewReferenceField(String fieldName, Object fieldObject, int fieldObjectID) {
        if (fieldObject != null)
            objectIDs.put(fieldObject, fieldObjectID);
    }

    @Override
    public void accessedPrimitiveField(String fieldName, int fieldObjectID) {
    }
}
