package symsolve.bounds;

import korat.finitization.impl.Finitization;
import symsolve.candidates.traversals.BFSCandidateTraversal;
import symsolve.candidates.traversals.CandidateTraversal;
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
        CandidateTraversal traverser = new BFSCandidateTraversal(finitization.getStateSpace());
        traverser.traverse(vector, this);
    }

    @Override
    public void accessedVisitedReferenceField(Object fieldObject, BFSCandidateTraversal.ObjectInfo fieldObjectInfo) {
        accessedNewReferenceField(fieldObject, fieldObjectInfo);
    }

    @Override
    public void accessedNullReferenceField() {
        ClassBound classBound = classBoundMap.get(currentOwnerClassName);
        assert (classBound != null);
        classBound.addBound(currentFieldName, currentOwnerID, 0);
    }

    @Override
    public void accessedNewReferenceField(Object fieldObject, BFSCandidateTraversal.ObjectInfo fieldObjectInfo) {
        ClassBound classBound = classBoundMap.get(currentOwnerClassName);
        assert (classBound != null);
        classBound.addBound(currentFieldName, currentOwnerID, fieldObjectInfo.id + 1);
    }

    public Bounds getBounds() {
        return new Bounds(classBoundMap);
    }

}
