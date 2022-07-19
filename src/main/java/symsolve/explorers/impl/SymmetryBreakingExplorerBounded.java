package symsolve.explorers.impl;

import korat.finitization.IFieldDomain;
import korat.finitization.IObjSet;
import korat.finitization.impl.CVElem;
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
    LabelSets labelSets;


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
    boolean setNextValue(int lastAccessedFieldIndex) {
        FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
        int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
        int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];
        if (currentInstanceIndex >= maxInstanceIndexForFieldDomain)
            return false;

        Set<Integer> targetLabelSet = calculateTargerLabelSet(lastAccessedFieldIndex);
        if (targetLabelSet.isEmpty())
            return false;

        if (lastAccessedFD.isPrimitiveType())
            return setNextValueForPrimitiveType(lastAccessedFieldIndex, targetLabelSet, maxInstanceIndexForFieldDomain);

        return setNextValueForReferenceType(lastAccessedFieldIndex, targetLabelSet, maxInstanceIndexForFieldDomain, lastAccessedFD);
        
    }

    @Override
    void backtrack(int lastAccessedFieldIndex) {
        CVElem cvElem = stateSpace.getCVElem(lastAccessedFieldIndex);
        IFieldDomain fieldDomain = cvElem.getFieldDomain();
        if (!fieldDomain.isPrimitiveType()) {
            IObjSet objSet = (ObjSet) fieldDomain;
            labelSets.remove(objSet.getObject(candidateVector[lastAccessedFieldIndex]));
        }
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

    private boolean newValueIsInBounds(IFieldDomain fieldDomain, int indexInFieldDomainOfNewValue, Set<Integer> targetLabelSet) {
        Object newValueObject = ((IObjSet) fieldDomain).getObject(indexInFieldDomainOfNewValue);
        if (!labelSets.contains(newValueObject)) {
            labelSets.put(newValueObject, targetLabelSet);
            return true;
        }
        boolean result = labelSets.isNonEmptyIntersection(targetLabelSet, labelSets.get(newValueObject));
        if (result)
            labelSets.increaseRefCount(newValueObject);
        return result;
    }

    private Set<Integer> calculateTargerLabelSet(int lastAccessedFieldIndex) {
        CVElem cvElem = stateSpace.getCVElem(lastAccessedFieldIndex);
        Object ownerObject = cvElem.getObj();
        return labelSets.calculateTargetLabelSet(ownerObject, cvElem.getFieldName());
    }

    private boolean setNextValueForPrimitiveType(int lastAccessedFieldIndex, Set<Integer> targetLabelSet, int maxInstanceIndexForFieldDomain) {
        int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];
        while (currentInstanceIndex < maxInstanceIndexForFieldDomain) {
            currentInstanceIndex++;
            if (targetLabelSet.contains(currentInstanceIndex)) {
                candidateVector[lastAccessedFieldIndex] = currentInstanceIndex;
                return true;
            }
        }
        return false;
    }

    private boolean setNextValueForReferenceType(int lastAccessedFieldIndex, Set<Integer> targetLabelSet, int maxInstanceIndexForFieldDomain, FieldDomain lastAccessedFD) {
        if (maxInstances[lastAccessedFieldIndex] == -1) {
            maxInstances[lastAccessedFieldIndex] = getMaxInstanceInVector(lastAccessedFD);
        }
        int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];
        while (currentInstanceIndex <= maxInstances[lastAccessedFieldIndex] && currentInstanceIndex < maxInstanceIndexForFieldDomain) {
            currentInstanceIndex++;
            if (newValueIsInBounds(lastAccessedFD, currentInstanceIndex, targetLabelSet)) {
                candidateVector[lastAccessedFieldIndex] = currentInstanceIndex;
                return true;
            }
        }
        return false;
    }

}
