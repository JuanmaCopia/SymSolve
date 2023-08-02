package symsolve.candidates.traversals.visitors;

import korat.finitization.impl.FieldDomain;
import symsolve.candidates.traversals.BFSCandidateTraversal;

public class GenericCandidateVisitor implements CandidateVisitor {

    protected Class<?> rootClass;
    protected Object rootObject;
    protected int rootID;

    protected Class<?> currentOwnerClass;
    protected Object currentOwnerObject;
    protected String currentOwnerClassName;
    protected int currentOwnerID;

    //protected String currentFieldClassName;
    protected FieldDomain currentFieldDomain;

    protected String currentFieldName;
    protected int currentFieldIndexInVector;

    protected int currentFieldIndexInFieldDomain;


    @Override
    public void setRoot(Object rootObject, BFSCandidateTraversal.ObjectInfo rootInfo) {
        this.rootObject = rootObject;
        rootClass = rootObject.getClass();
        this.rootID = rootInfo.id;
    }

    @Override
    public void setCurrentOwner(Object currentOwnerObject, BFSCandidateTraversal.ObjectInfo currentOwnerInfo) {
        currentOwnerClass = currentOwnerObject.getClass();
        currentOwnerClassName = currentOwnerClass.getName();
        this.currentOwnerObject = currentOwnerObject;
        this.currentOwnerID = currentOwnerInfo.id;
    }

    @Override
    public void setCurrentField(FieldDomain domain, String name, int indexInVector, int indexInFieldDomain) {
        currentFieldDomain = domain;
        currentFieldName = name;
        currentFieldIndexInVector = indexInVector;
        currentFieldIndexInFieldDomain = indexInFieldDomain;
    }

    @Override
    public void accessedVisitedReferenceField(Object fieldObject, BFSCandidateTraversal.ObjectInfo fieldObjectInfo) {
    }

    @Override
    public void accessedNullReferenceField() {
    }

    @Override
    public void accessedNewReferenceField(Object fieldObject, BFSCandidateTraversal.ObjectInfo fieldObjectInfo) {
    }

    @Override
    public void accessedPrimitiveField(int fieldObjectID) {
    }

    @Override
    public boolean isTraversalAborted() {
        return false;
    }

}
