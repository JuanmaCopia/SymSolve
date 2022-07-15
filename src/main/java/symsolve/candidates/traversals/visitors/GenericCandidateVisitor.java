package symsolve.candidates.traversals.visitors;

public class GenericCandidateVisitor implements CandidateVisitor {

    protected Class<?> currentOwnerClass;
    protected Object currentOwnerObject;
    protected String currentOwnerClassName;
    protected int currentOwnerID;

    protected Class<?> rootClass;
    protected Object rootObject;
    protected int rootID;


    @Override
    public void setRoot(Object rootObject, int rootID) {
        this.rootObject = rootObject;
        rootClass = rootObject.getClass();
        this.rootID = rootID;
    }

    @Override
    public void setCurrentOwner(Object currentOwnerObject, int currentOwnerID) {
        currentOwnerClass = currentOwnerObject.getClass();
        currentOwnerClassName = currentOwnerClass.getName();
        this.currentOwnerObject = currentOwnerObject;
        this.currentOwnerID = currentOwnerID;
    }

    @Override
    public void accessedVisitedReferenceField(String fieldName, Object fieldObject, int fieldObjectID, int indexInVector) {
    }

    @Override
    public void accessedNullReferenceField(String fieldName, int fieldObjectID, int indexInVector) {
    }

    @Override
    public void accessedNewReferenceField(String fieldName, Object fieldObject, int fieldObjectID, int indexInVector) {
    }

    @Override
    public void accessedPrimitiveField(String fieldName, int fieldObjectID, int indexInVector) {
    }

}
