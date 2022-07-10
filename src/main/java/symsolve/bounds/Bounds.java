package symsolve.bounds;

import korat.finitization.impl.Finitization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bounds {

    Map<Class<?>, ClassBound> classBoundMap = new HashMap<>();
    Finitization finitization;
    Class<?> rootClass;


    public Bounds(Finitization finitization, Class<?> rootClass) {
        this.finitization = finitization;
        this.rootClass = rootClass;
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

    public List<Integer> getAllowedValues(Class<?> cls, String fieldName, Integer ownerObjectID) {
        ClassBound classBound = classBoundMap.get(cls);
        assert (classBound != null);
        FieldBound fieldBounds = classBound.getFieldBounds(fieldName);
        return fieldBounds.getAllowedValues(ownerObjectID);
    }

/*    HashMap<String, HashSet<Integer>> bounds = new HashMap<>();

    StateSpace stateSpace;

    public Bounds(StateSpace stateSpace) {
        this.stateSpace = stateSpace;
    }

    public void recordBounds(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            CVElem cvElem = stateSpace.getCVElem(i);
            addBound(cvElem, vector[i]);
        }
    }

    private void addBound(CVElem fieldElem, int value) {
        String ownerClassName = fieldElem.getObj().getClass().getSimpleName();
        String fieldName = fieldElem.getFieldName();
        addBound(ownerClassName, fieldName, value);
    }

    private void addBound(String ownerClassName, String fieldName, int value) {
        String fieldKey = createFieldSignature(ownerClassName, fieldName);
        HashSet<Integer> fieldBounds = bounds.computeIfAbsent(fieldKey, k -> new HashSet<>());
        fieldBounds.add(value);
    }

    private static String createFieldSignature(String className, String fieldName) {
        return String.format("%s.%s", className, fieldName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, HashSet<Integer>> e : bounds.entrySet()) {
            sb.append(String.format("%s : %s\n", e.getKey(), e.getValue().toString()));
        }
        return sb.toString();
    }*/

}
