package symsolve.candidates.traversals.visitors;

import korat.finitization.impl.FieldDomain;
import symsolve.candidates.traversals.BFSCandidateTraversal;

public interface CandidateVisitor {

    void setRoot(Object rootObject, BFSCandidateTraversal.ObjectInfo rootInfo);

    void setCurrentOwner(Object currentOwnerObject, BFSCandidateTraversal.ObjectInfo currentOwnerInfo);

    void setCurrentField(FieldDomain domain, String name, int indexInVector, int indexInFieldDomain);

    void accessedVisitedReferenceField(Object fieldObject, BFSCandidateTraversal.ObjectInfo fieldObjectInfo);

    void accessedNullReferenceField();

    void accessedNewReferenceField(Object fieldObject, BFSCandidateTraversal.ObjectInfo fieldObjectInfo);

    void accessedPrimitiveField(int fieldObjectID);

    boolean isTraversalAborted();

}
