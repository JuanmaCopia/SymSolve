package symsolve.bounds;

import symsolve.utils.InmutablePair;

import java.util.HashSet;
import java.util.Set;

public class FieldBound {

    String fieldName;
    ClassBound classBound;
    Set<InmutablePair<Integer, Integer>> relation = new HashSet<>();


    public FieldBound(String fieldName, ClassBound classBound) {
        this.fieldName = fieldName;
        this.classBound = classBound;
    }

    public void addBound(int src, int dest) {
        InmutablePair<Integer, Integer> bound = new InmutablePair<>(src, dest);
        relation.add(bound);
    }

}
