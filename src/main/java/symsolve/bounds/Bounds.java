package symsolve.bounds;

import java.util.Map;
import java.util.Set;

public class Bounds {

    Map<String, ClassBound> classBoundMap;

    public Bounds(Map<String, ClassBound> classBoundMap) {
        this.classBoundMap = classBoundMap;
    }

    public Set<Integer> getTargets(Class<?> ownerClass, String fieldName, Set<Integer> ids) {
        ClassBound classBound = classBoundMap.get(ownerClass.getName());
        FieldBound fieldBounds = classBound.getFieldBounds(fieldName);
        return fieldBounds.getAllowedValues(ids);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bounds))
            return false;
        Bounds other = (Bounds) o;
        return o.toString().equals((other.toString()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ClassBound> e : classBoundMap.entrySet()) {
            sb.append(String.format("Bounds for class: %s\n", e.getKey()));
            sb.append(e.getValue().toString());
        }
        return sb.toString();
    }

}
