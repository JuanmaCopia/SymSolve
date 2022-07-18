package symsolve.bounds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LabelSets {

    Bounds bounds;
    Map<Object, Set<Integer>> labelSetMap = new HashMap<>();

    
    public LabelSets(Bounds bounds) {
        this.bounds = bounds;
    }

    public Set<Integer> get(Object object) {
        return labelSetMap.get(object);
    }

    public void put(Object object, Set<Integer> labelSet) {
        labelSetMap.put(object, labelSet);
    }

    public boolean contains(Object object) {
        return labelSetMap.containsKey(object);
    }

    public void remove(Object object) {
        labelSetMap.remove(object);
    }

    public Set<Integer> calculateTargetLabelSet(Object thisObject, String fieldName) {
        Set<Integer> thisLabelSet = labelSetMap.get(thisObject);
        Set<Integer> targetLabelSet = bounds.getTargets(thisObject.getClass(), fieldName, thisLabelSet);
        targetLabelSet.remove(0);
        return targetLabelSet;
    }

    public boolean haveNonEmptyLabelSetIntersection(Object thisObject, Object newValueObject) {
        Set<Integer> thisLabelSet = labelSetMap.get(thisObject);
        Set<Integer> newValueLabelSet = labelSetMap.get(newValueObject);
        return isNonEmptyIntersection(thisLabelSet, newValueLabelSet);
    }

    private boolean isNonEmptyIntersection(Set<Integer> thisLabelSet, Set<Integer> newValueLabelSet) {
        Set<Integer> intersection = new HashSet<>(thisLabelSet);
        intersection.retainAll(newValueLabelSet);
        return !intersection.isEmpty();
    }

}
