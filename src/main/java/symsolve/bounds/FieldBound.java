package symsolve.bounds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FieldBound {

    String fieldName;
    ClassBound classBound;

    Map<Integer, Set<Integer>> fieldBounds = new HashMap<>();


    public FieldBound(String fieldName, ClassBound classBound) {
        this.fieldName = fieldName;
        this.classBound = classBound;
    }

    public void addBound(int ownerObjectID, int fieldValue) {
        if (!fieldBounds.containsKey(ownerObjectID))
            fieldBounds.put(ownerObjectID, new HashSet<>());
        Set<Integer> fieldValues = fieldBounds.get(ownerObjectID);
        fieldValues.add(fieldValue);
    }

    public Set<Integer> getAllowedValues(int ownerObjectID) {
        Set<Integer> fieldValues = fieldBounds.get(ownerObjectID);
        assert (fieldValues != null);
        return fieldValues;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Set<Integer>> e : fieldBounds.entrySet()) {
            sb.append(String.format("\t\t%d : %s\n", e.getKey(), e.getValue().toString()));
        }
        return sb.toString();
    }

}
