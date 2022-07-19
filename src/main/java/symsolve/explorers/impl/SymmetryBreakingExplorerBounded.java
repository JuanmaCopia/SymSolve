package symsolve.explorers.impl;

import korat.finitization.IFieldDomain;
import korat.finitization.IObjSet;
import korat.finitization.impl.CVElem;
import korat.finitization.impl.FieldDomain;
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

        if (lastAccessedFD.isPrimitiveType()) {
            candidateVector[lastAccessedFieldIndex]++;
            return true;
        }

        // Is a reference field
        if (maxInstances[lastAccessedFieldIndex] == -1) {
            maxInstances[lastAccessedFieldIndex] = getMaxInstanceInVector(lastAccessedFD);
        }
        while (currentInstanceIndex <= maxInstances[lastAccessedFieldIndex] && currentInstanceIndex < maxInstanceIndexForFieldDomain) {
            currentInstanceIndex++;
            if (newValueIsInBounds(lastAccessedFD, currentInstanceIndex, lastAccessedFieldIndex)) {
                candidateVector[lastAccessedFieldIndex] = currentInstanceIndex;
                return true;
            }
        }
        return false;
    }

    @Override
    void backtrack(int lastAccessedFieldIndex) {
        /*CVElem cvElem = stateSpace.getCVElem(lastAccessedFieldIndex);
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

    private boolean newValueIsInBounds(IFieldDomain fieldDomain, int indexInFieldDomainOfNewValue, int lastAccessedFieldIndex) {
        CVElem cvElem = stateSpace.getCVElem(lastAccessedFieldIndex);
        Object ownerObject = cvElem.getObj();
        Set<Integer> targetLabelSet = labelSets.calculateTargetLabelSet(ownerObject, cvElem.getFieldName());
        if (targetLabelSet.isEmpty())
            return false;

        Object newValueObject = ((IObjSet) fieldDomain).getObject(indexInFieldDomainOfNewValue);
        if (!labelSets.contains(newValueObject)) {
            labelSets.put(newValueObject, targetLabelSet);
            return true;
        }
        return labelSets.isNonEmptyIntersection(targetLabelSet, labelSets.get(newValueObject));
    }

}
