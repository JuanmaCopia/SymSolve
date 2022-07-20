package symsolve.candidates.traversals.visitors;

public interface CandidateVisitor {

    void setRoot(Object rootObject, int rootID);

    void setCurrentOwner(Object currentOwnerObject, int currentOwnerID);

    void accessedVisitedReferenceField(String fieldName, Object fieldObject, int fieldObjectID);

    void accessedNullReferenceField(String fieldName, int fieldObjectID);

    void accessedNewReferenceField(String fieldName, Object fieldObject, int fieldObjectID);

    void accessedPrimitiveField(String fieldName, int fieldObjectID);

    boolean isTraversalAborted();

}
