package symsolve.bounds;

import korat.finitization.impl.Finitization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassBound {

    Map<String, FieldBound> fieldBoundMap = new HashMap<>();

    Class<?> cls;

    Finitization finitization;

    public ClassBound(Class<?> cls, Finitization finitization) {
        this.cls = cls;
        this.finitization = finitization;
        initializeFieldBoundMap();
    }

    private void initializeFieldBoundMap() {
        List<String> fieldNames = finitization.getFieldNames(cls);
        for (String fieldName : fieldNames) {
            if (!fieldBoundMap.containsKey(fieldName))
                fieldBoundMap.put(fieldName, new FieldBound(fieldName, this));
        }
    }

}
