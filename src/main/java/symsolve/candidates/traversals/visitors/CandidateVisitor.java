package symsolve.candidates.traversals.visitors;

import korat.finitization.impl.FieldDomain;

public interface CandidateVisitor {

    void setRoot(Object rootObject, int rootID);

    void setCurrentOwner(Object currentOwnerObject, int currentOwnerID);

    void setCurrentField(FieldDomain domain, String name, int indexInVector, int indexInFieldDomain);

    void accessedVisitedReferenceField(Object fieldObject, int fieldObjectID);

    void accessedNullReferenceField(int fieldObjectID);

    void accessedNewReferenceField(Object fieldObject, int fieldObjectID);

    void accessedPrimitiveField(int fieldObjectID);

    boolean isTraversalAborted();

}
