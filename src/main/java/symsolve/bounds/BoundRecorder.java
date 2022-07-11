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
        CandidateTraverser traverser = new BFSCandidateTraverser(finitization);
        traverser.traverse(vector, this);
    }

    @Override
    public void visited(Class<?> ownerClass, String fieldName, int ownerID, int fieldValueID) {
        ClassBound classBound = classBoundMap.get(ownerClass.getName());
        assert (classBound != null);
        classBound.addBound(fieldName, ownerID, fieldValueID);
    }

    public Bounds getBounds() {
        return new Bounds(classBoundMap);
    }
    
}
