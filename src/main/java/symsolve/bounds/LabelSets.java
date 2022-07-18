package symsolve.bounds;

import java.util.HashMap;
import java.util.Set;

public class LabelSets {

    Bounds bounds;
    HashMap<Object, Set<Integer>> labelSets = new HashMap<>();

    public LabelSets(Bounds bounds) {
        this.bounds = bounds;
    }

    public Set<Integer> get(Object object) {
        return labelSets.get(object);
    }

    public void put(Object object, Set<Integer> labelSet) {
        labelSets.put(object, labelSet);
    }

    public boolean contains(Object object) {
        return labelSets.containsKey(object);
    }

    public void remove(Object object) {
        labelSets.remove(object);
    }

    public Set<Integer> calculateTargetLabelSet(Object thisObject, String fieldName) {
        Set<Integer> thisLabelSet = labelSets.get(thisObject);
        Set<Integer> targetLabelSet = bounds.getTargets(thisObject.getClass(), fieldName, thisLabelSet);
        targetLabelSet.remove(0);
        return targetLabelSet;
    }
}
