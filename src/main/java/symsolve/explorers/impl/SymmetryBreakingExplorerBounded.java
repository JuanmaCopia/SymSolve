package symsolve.explorers.impl;

import korat.finitization.IObjSet;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.ObjSet;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import symsolve.bounds.Bounds;
import symsolve.bounds.LabelSets;
import symsolve.candidates.traversals.visitors.CollectLabelSetsVisitor;
import symsolve.vector.SymSolveVector;

import java.util.Set;

public class SymmetryBreakingExplorerBounded extends AbstractVectorStateSpaceExplorer {

    private final int[] maxInstances;
    private final LabelSets labelSets;


    public SymmetryBreakingExplorerBounded(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields, Bounds bounds) {
        super(stateSpace, accessedIndices, changedFields);
        maxInstances = new int[vectorSize];
        labelSets = new LabelSets(bounds);
    }

    @Override
    public void initialize(SymSolveVector vector) {
        super.initialize(vector);
        CollectLabelSetsVisitor collectLabelSetsVisitor = new CollectLabelSetsVisitor(stateSpace, labelSets);
        collectLabelSetsVisitor.collectLabelSetsForVector(vector.getConcreteVector());
    }

    @Override
    boolean setNextValue() {
        if (currentValue >= currentMaxFieldDomainIndex)
            return false;

        Set<Integer> targetLabelSet = labelSets.calculateTargetLabelSet(currentFieldOwner, currentFieldName);
        if (targetLabelSet.isEmpty())
            return false;

        if (isCurrentFieldPrimitive)
            return setNextValueForPrimitiveType(targetLabelSet);

        return setNextValueForReferenceType(targetLabelSet);

    }

    @Override
    void backtrack() {
        if (!isCurrentFieldPrimitive)
            removeCurrentValueFromLabelSets();
        resetCurrentFieldValue();
        setFieldAsNotInitialized(currentIndex);
    }

    @Override
    void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++) {
            setIndexAsChanged(i);
            if (isIndexFixed(i) && candidateVector[i] > 0) {
                FieldDomain fieldDomain = stateSpace.getFieldDomain(i);
                if (!fieldDomain.isPrimitiveType())
                    initializeField(i, fieldDomain);
            } else {
                setFieldAsNotInitialized(i);
            }
        }
    }

    private boolean isNewValueInBounds(int newValue, Set<Integer> targetLabelSet) {
        Object newValueObject = ((IObjSet) currentFieldDomain).getObject(newValue);
        if (!labelSets.contains(newValueObject)) {
            labelSets.put(newValueObject, targetLabelSet);
            return true;
        }
        boolean result = labelSets.isNonEmptyIntersection(targetLabelSet, labelSets.get(newValueObject));
        if (result)
            labelSets.increaseRefCount(newValueObject);
        return result;
    }

    private boolean setNextValueForPrimitiveType(Set<Integer> targetLabelSet) {
        int nextValue = currentValue;
        while (nextValue < currentMaxFieldDomainIndex) {
            nextValue++;
            if (targetLabelSet.contains(nextValue)) {
                candidateVector[currentIndex] = nextValue;
                return true;
            }
        }
        return false;
    }

    private boolean setNextValueForReferenceType(Set<Integer> targetLabelSet) {
        if (!isCurrentFieldInitialized()) {
            initializeField(currentIndex, currentFieldDomain);
        }
        int nextValue = currentValue;
        while (nextValue <= maxInstances[currentIndex] && nextValue < currentMaxFieldDomainIndex) {
            nextValue++;
            if (isNewValueInBounds(nextValue, targetLabelSet)) {
                setCurrentFieldValue(nextValue);
                return true;
            }
        }
        return false;
    }

    private boolean isCurrentFieldInitialized() {
        return maxInstances[currentIndex] != -1;
    }

    private void setFieldAsNotInitialized(int index) {
        maxInstances[index] = -1;
    }

    private void initializeField(int index, FieldDomain fieldDomain) {
        maxInstances[index] = getMaxInstanceInVector(fieldDomain);
    }

    private void removeCurrentValueFromLabelSets() {
        IObjSet objSet = (ObjSet) currentFieldDomain;
        labelSets.remove(objSet.getObject(currentValue));
    }

}
