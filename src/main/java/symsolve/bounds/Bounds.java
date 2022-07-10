package symsolve.bounds;

import korat.finitization.impl.Finitization;
import symsolve.candidates.traversals.BFSCandidateTraverser;
import symsolve.candidates.traversals.CandidateTraverser;
import symsolve.candidates.traversals.visitors.BoundCalculatorVisitor;
import symsolve.candidates.traversals.visitors.CandidateVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bounds {

    Map<Class<?>, ClassBound> classBoundMap = new HashMap<>();
    Finitization finitization;


    public Bounds(Finitization finitization) {
        this.finitization = finitization;
        initializeClassBoundMap();
    }

    private void initializeClassBoundMap() {
        Set<Class<?>> classes = finitization.getClasses();
        if (classes != null) {
            for (Class<?> cls : classes) {
                if (!classBoundMap.containsKey(cls))
                    classBoundMap.put(cls, new ClassBound(cls, finitization));
            }
        }
    }

    public Set<Integer> getAllowedValues(Class<?> ownerClass, String fieldName, Integer ownerObjectID) {
        ClassBound classBound = classBoundMap.get(ownerClass);
        assert (classBound != null);
        FieldBound fieldBounds = classBound.getFieldBounds(fieldName);
        return fieldBounds.getAllowedValues(ownerObjectID);
    }

    public void addBound(Class<?> ownerClass, String fieldName, Integer ownerObjectID, int valueID) {
        ClassBound classBound = classBoundMap.get(ownerClass);
        assert (classBound != null);
        FieldBound fieldBounds = classBound.getFieldBounds(fieldName);
        fieldBounds.addBound(ownerObjectID, valueID);
    }

    public void recordBounds(int[] vector) {
        CandidateTraverser traverser = new BFSCandidateTraverser(finitization);
        CandidateVisitor visitor = new BoundCalculatorVisitor(this);
        traverser.traverse(vector, visitor);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Class<?>, ClassBound> e : classBoundMap.entrySet()) {
            sb.append(String.format("Bounds for class: %s\n", e.getKey().getSimpleName()));
            sb.append(e.getValue().toString());
        }
        return sb.toString();
    }

}
