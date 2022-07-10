package symsolve.bounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldBound {

    String fieldName;
    ClassBound classBound;

    Map<Integer, List<Integer>> fieldBounds = new HashMap<>();


    public FieldBound(String fieldName, ClassBound classBound) {
        this.fieldName = fieldName;
        this.classBound = classBound;
    }

    public void addBound(int ownerObjectID, int fieldValue) {
        if (!fieldBounds.containsKey(ownerObjectID))
            fieldBounds.put(ownerObjectID, new ArrayList<>());
        List<Integer> fieldValues = fieldBounds.get(ownerObjectID);
        fieldValues.add(fieldValue);
    }

    public List<Integer> getAllowedValues(int ownerObjectID) {
        List<Integer> fieldValues = fieldBounds.get(ownerObjectID);
        assert (fieldValues != null);
        return fieldValues;
    }

}
