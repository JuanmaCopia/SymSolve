package symsolve.explorers.impl;

import korat.finitization.IObjSet;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import symsolve.bounds.Bounds;

import java.util.HashSet;
import java.util.Set;

public class SymmetryBreakingExplorerBounded extends AbstractVectorStateSpaceExplorer {

    private final int[] maxInstances;
    Bounds bounds;

/*
    CalculateNodesLabelSetVisitor labelSetCalculator;
    Map<Object, Set<Integer>> labelSets;
*/

    public SymmetryBreakingExplorerBounded(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields, Bounds bounds) {
        super(stateSpace, accessedIndices, changedFields);
        maxInstances = new int[vectorSize];
        this.bounds = bounds;
    }

/*    @Override
    public void initialize(SymSolveVector vector) {
        super.initialize(vector);
        labelSetCalculator = new CalculateNodesLabelSetVisitor(stateSpace, bounds);
        labelSets = labelSetCalculator.calculateLabelSets(candidateVector);
    }*/

    @Override
    boolean setNextValue(int lastAccessedFieldIndex) {
        FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
        int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
        int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

        if (currentInstanceIndex >= maxInstanceIndexForFieldDomain)
            return false;

        if (lastAccessedFD.isPrimitiveType()) {
            candidateVector[lastAccessedFieldIndex]++;
            return true;
        }

        // Is a reference field
        if (maxInstances[lastAccessedFieldIndex] == -1) {
            maxInstances[lastAccessedFieldIndex] = getMaxInstanceInVector(lastAccessedFD);
        }

        while (currentInstanceIndex <= maxInstances[lastAccessedFieldIndex]) {
            currentInstanceIndex++;
            if (newValueIsInBounds((IObjSet) lastAccessedFD, currentInstanceIndex, currentInstanceIndex)) {
                candidateVector[lastAccessedFieldIndex] = currentInstanceIndex;
                return true;
            }
        }

        return false;
    }

    @Override
    void backtrack(int lastAccessedFieldIndex) {
/*        CVElem cvElem = stateSpace.getCVElem(lastAccessedFieldIndex);
        IFieldDomain fieldDomain = cvElem.getFieldDomain();
        if (!fieldDomain.isPrimitiveType()) {
            IObjSet objSet = (ObjSet) fieldDomain;
            labelSets.remove(objSet.getObject(candidateVector[lastAccessedFieldIndex]));
        }*/
        candidateVector[lastAccessedFieldIndex] = 0;
        maxInstances[lastAccessedFieldIndex] = -1;
    }

    @Override
    void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++) {
            changedFields.add(i);
            if (!fixedIndices.contains(i) && candidateVector[i] > 0) {
                FieldDomain fieldDomain = stateSpace.getFieldDomain(i);
                if (!fieldDomain.isPrimitiveType())
                    maxInstances[i] = getMaxInstanceInVector(fieldDomain);
            } else {
                maxInstances[i] = -1;
            }
        }
    }

    /*private boolean newValueIsInBounds(IObjSet newValueobjectSet, int indexInVector, int newValue) {
        Object newValueObject = newValueobjectSet.getObject(newValue);

        CVElem cvElem = stateSpace.getCVElem(indexInVector);
        Object thisObject = cvElem.getObj();
        Set<Integer> thisLabelSet = labelSets.get(thisObject);

        if (labelSets.containsKey(newValueObject)) { // The new value is an assigned object of the structure
            Set<Integer> newValueLabelSet = labelSets.get(newValueObject);
            return isNonEmptyIntersection(thisLabelSet, newValueLabelSet);
        } else { // The new value is a not assigned object
            Set<Integer> targetLabelSet = labelSetCalculator.getTargetLabelSet(thisObject, cvElem.getFieldName());
            if (!targetLabelSet.isEmpty()) {
                labelSets.put(newValueObject, targetLabelSet);
                return true;
            }
        }

        return false;
    }*/

    private boolean newValueIsInBounds(IObjSet newValueobjectSet, int indexInVector, int newValue) {
        return true;
    }

    private boolean isNonEmptyIntersection(Set<Integer> thisLabelSet, Set<Integer> newValueLabelSet) {
        Set<Integer> intersection = new HashSet<>(thisLabelSet);
        intersection.retainAll(newValueLabelSet);
        return !intersection.isEmpty();
    }


}
