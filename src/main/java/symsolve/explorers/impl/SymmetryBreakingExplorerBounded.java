package symsolve.explorers.impl;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import symsolve.bounds.Bounds;
import symsolve.candidates.traversals.visitors.ObjectIDMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SymmetryBreakingExplorerBounded extends SymmetryBreakingExplorer {

    Bounds bounds;
    List<List<Integer>> boundList;

    public SymmetryBreakingExplorerBounded(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields, Bounds bounds) {
        super(stateSpace, accessedIndices, changedFields);
        this.bounds = bounds;
        boundList = new ArrayList<>(vectorSize);
    }

    @Override
    public void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++) {
            changedFields.add(i);
            if (!fixedIndices.contains(i) && candidateVector[i] > 0) {
                List<Integer> possibleValues = getPossibleValuesForCurrentField(i);
                removeAlreadyExploredValues(possibleValues, candidateVector[i]);
                boundList.set(i, possibleValues);
            } else {
                boundList.set(i, null);
            }
        }
    }

    @Override
    protected boolean setNextValue(int lastAccessedFieldIndex) {
        List<Integer> possibleValues = boundList.get(lastAccessedFieldIndex);
        if (possibleValues == null) {
            possibleValues = getPossibleValuesForCurrentField(lastAccessedFieldIndex);
            boundList.set(lastAccessedFieldIndex, possibleValues);
        }

        if (!possibleValues.isEmpty()) {
            candidateVector[lastAccessedFieldIndex] = possibleValues.remove(0);
            return true;
        }
        return false;
    }

    @Override
    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        boundList.set(lastAccessedFieldIndex, null);
    }

    private List<Integer> getPossibleValuesForCurrentField(int fieldIndex) {
        CVElem cvElem = stateSpace.getCVElem(fieldIndex);
        Object ownerObject = cvElem.getObj();
        Class<?> cls = ownerObject.getClass();
        String fieldName = cvElem.getFieldName();
        int ownerId = getObjectID(ownerObject);
        Set<Integer> boundValues = bounds.getAllowedValues(cls, fieldName, ownerId);
        return new ArrayList<>(boundValues);
    }

    private int getObjectID(Object object) {
        ObjectIDMapper visitor = new ObjectIDMapper(stateSpace);
        Map<Object, Integer> objectIDs = visitor.calculateObjectsIDs(candidateVector);
        assert (objectIDs.containsKey(object));
        return objectIDs.get(object);
    }

    private void removeAlreadyExploredValues(List<Integer> possibleValues, int currentValue) {
        int numOfRemovals = 1;
        for (Integer value : possibleValues) {
            if (value != currentValue)
                numOfRemovals++;
        }
        for (int i = 0; i < numOfRemovals; i++)
            possibleValues.remove(0);
    }

}
