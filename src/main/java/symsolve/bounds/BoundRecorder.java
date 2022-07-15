package symsolve.bounds;

import korat.finitization.impl.Finitization;
import symsolve.candidates.traversals.BFSCandidateTraverser;
import symsolve.candidates.traversals.CandidateTraverser;
import symsolve.candidates.traversals.visitors.GenericCandidateVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BoundRecorder extends GenericCandidateVisitor {

    private final transient Finitization finitization;
    Map<String, ClassBound> classBoundMap = new HashMap<>();


    public BoundRecorder(Finitization finitization) {
        this.finitization = finitization;
        initializeClassBoundMap();
    }

    private void initializeClassBoundMap() {
        Set<Class<?>> classes = finitization.getClasses();
        if (classes != null) {
            for (Class<?> cls : classes) {
                String className = cls.getName();
                if (!classBoundMap.containsKey(className))
                    classBoundMap.put(className, new ClassBound(cls, finitization.getFieldNames(cls)));
            }
        }
    }

    public void recordBounds(int[] vector) {
        CandidateTraverser traverser = new BFSCandidateTraverser(finitization.getStateSpace());
        traverser.traverse(vector, this);
    }

    @Override
    public void setCurrentOwner(Object currentOwnerObject, int currentOwnerID) {
        currentOwnerClass = currentOwnerObject.getClass();
        currentOwnerClassName = currentOwnerClass.getName();
        this.currentOwnerObject = currentOwnerObject;
        if (currentOwnerObject == rootObject)
            this.currentOwnerID = rootID;
        else
            this.currentOwnerID = currentOwnerID;
    }


    @Override
    public void accessedVisitedReferenceField(String fieldName, Object fieldObject, int fieldObjectID, int indexInVector) {
        accessedNewReferenceField(fieldName, fieldObject, fieldObjectID, indexInVector);
    }

    @Override
    public void accessedNullReferenceField(String fieldName, int fieldObjectID, int indexInVector) {
        accessedNewReferenceField(fieldName, null, fieldObjectID, indexInVector);
    }

    @Override
    public void accessedNewReferenceField(String fieldName, Object fieldObject, int fieldObjectID, int indexInVector) {
        ClassBound classBound = classBoundMap.get(currentOwnerClassName);
        assert (classBound != null);
        classBound.addBound(fieldName, currentOwnerID, fieldObjectID);
    }

    @Override
    public void accessedPrimitiveField(String fieldName, int fieldObjectID, int indexInVector) {
        accessedNewReferenceField(fieldName, null, fieldObjectID, indexInVector);
    }

    public Bounds getBounds() {
        return new Bounds(classBoundMap);
    }

}
