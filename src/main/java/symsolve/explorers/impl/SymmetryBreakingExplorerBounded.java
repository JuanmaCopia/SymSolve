package symsolve.explorers.impl;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.FieldDomain;
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
        initializeBoundList();
    }

    private void initializeBoundList() {
        boundList = new ArrayList<>(vectorSize);
    }

    protected boolean setNextValue(int lastAccessedFieldIndex) {
        FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
        int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
        int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

        if (currentInstanceIndex >= maxInstanceIndexForFieldDomain)
            return false;

        if (lastAccessedFD.isPrimitiveType()) { // TODO: Check bounds here!
            candidateVector[lastAccessedFieldIndex]++;
            return true;
        }

        // Is a reference field
        List<Integer> possibleValues = boundList.get(lastAccessedFieldIndex);
        if (possibleValues == null) {
            CVElem cvElem = stateSpace.getCVElem(lastAccessedFieldIndex);
            Object ownerObject = cvElem.getObj();
            Class<?> cls = ownerObject.getClass();
            String fieldName = cvElem.getFieldName();
            int ownerId = getObjectID(ownerObject);
            Set<Integer> boundValues = bounds.getAllowedValues(cls, fieldName, ownerId);
            possibleValues = new ArrayList<>(boundValues);
            boundList.set(lastAccessedFieldIndex, possibleValues);
        }

        if (!possibleValues.isEmpty()) {
            candidateVector[lastAccessedFieldIndex] = possibleValues.remove(0);
            return true;
        }
        return false;
    }

    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        maxInstances[lastAccessedFieldIndex] = -1;
    }

    private int getObjectID(Object object) {
        ObjectIDMapper visitor = new ObjectIDMapper(stateSpace);
        Map<Object, Integer> objectIDs = visitor.calculateObjectsIDs(candidateVector);
        assert (objectIDs.containsKey(object));
        return objectIDs.get(object);
    }
}
