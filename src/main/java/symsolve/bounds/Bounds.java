package symsolve.bounds;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.StateSpace;

import java.util.HashMap;
import java.util.HashSet;

public class Bounds {

    HashMap<String, HashSet<Integer>> bounds = new HashMap<>();

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

}
