package symsolve.bounds;

import korat.finitization.impl.Finitization;
import symsolve.candidates.traversals.BFSCandidateTraverser;
import symsolve.candidates.traversals.CandidateTraverser;
import symsolve.candidates.traversals.visitors.CandidateVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BoundRecorder implements CandidateVisitor {

    private final transient Finitization finitization;
    Map<String, ClassBound> classBoundMap = new HashMap<>();

    Class<?> currentOwnerClass;
    String currentOwnerClassName;
    Object currentOwnerObject;
    int currentOwnerID;

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
        this.currentOwnerID = currentOwnerID;
    }

    @Override
    public void accessedVisitedReferenceField(String fieldName, Object fieldObject, int fieldObjectID) {
        accessedNewReferenceField(fieldName, fieldObject, fieldObjectID);
    }

    @Override
    public void accessedNullReferenceField(String fieldName, int fieldObjectID) {
        accessedNewReferenceField(fieldName, null, fieldObjectID);
    }

    @Override
    public void accessedNewReferenceField(String fieldName, Object fieldObject, int fieldObjectID) {
        ClassBound classBound = classBoundMap.get(currentOwnerClassName);
        assert (classBound != null);
        classBound.addBound(fieldName, currentOwnerID, fieldObjectID);
    }

    @Override
    public void accessedPrimitiveField(String fieldName, int fieldObjectID) {
        accessedNewReferenceField(fieldName, null, fieldObjectID);
    }

    public Bounds getBounds() {
        return new Bounds(classBoundMap);
    }

}
