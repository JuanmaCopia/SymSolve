package symsolve.explorers.impl;

import korat.finitization.IObjSet;
import korat.finitization.impl.ObjSet;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import symsolve.bounds.Bounds;
import symsolve.bounds.LabelSets;
import symsolve.candidates.traversals.visitors.CollectLabelSetsVisitor;
import symsolve.vector.SymSolveVector;

import java.util.Set;

public class SymmetryBreakingExplorerBounded extends SymmetryBreakingExplorer {


    private final LabelSets labelSets;


    public SymmetryBreakingExplorerBounded(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields, Bounds bounds) {
        super(stateSpace, accessedIndices, changedFields);
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
        if (currentValue >= maxFieldDomainValue)
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

    private boolean isNewValueInBounds(int newValue, Set<Integer> targetLabelSet) {
        Object newValueObject = ((IObjSet) currentFieldDomain).getObject(newValue);
        if (isNewObject(newValueObject)) {
            labelSets.put(newValueObject, targetLabelSet);
            return true;
        }
        Set<Integer> newValueLabelSet = labelSets.get(newValueObject);
        Set<Integer> intersection = labelSets.calculateSetIntersection(targetLabelSet, newValueLabelSet);
        if (intersection.isEmpty())
            return false;

        labelSets.increaseRefCount(newValueObject);
        return true;
    }

    private boolean setNextValueForPrimitiveType(Set<Integer> targetLabelSet) {
        int nextValue = currentValue;
        while (nextValue < maxFieldDomainValue) {
            nextValue++;
            if (targetLabelSet.contains(nextValue)) {
                setCurrentFieldValue(nextValue);
                return true;
            }
        }
        return false;
    }

    private boolean setNextValueForReferenceType(Set<Integer> targetLabelSet) {
        if (!isFieldInitialized(currentIndex)) {
            initializeField(currentIndex, currentFieldDomain);
        }
        int nextValue = currentValue;
        while (nextValue <= maxInstances[currentIndex] && nextValue < maxFieldDomainValue) {
            nextValue++;
            if (isNewValueInBounds(nextValue, targetLabelSet)) {
                setCurrentFieldValue(nextValue);
                return true;
            }
        }
        return false;
    }

    private void removeCurrentValueFromLabelSets() {
        IObjSet objSet = (ObjSet) currentFieldDomain;
        labelSets.remove(objSet.getObject(currentValue));
    }

    private boolean isNewObject(Object object) {
        return !labelSets.contains(object);
    }

}
