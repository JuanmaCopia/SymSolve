package symsolve.explorers.impl;

import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;

public class SymmetryBreakingExplorer extends AbstractVectorStateSpaceExplorer {

    protected int[] maxInstances;


    public SymmetryBreakingExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        super(stateSpace, accessedIndices, changedFields);
        maxInstances = new int[vectorSize];
    }

    @Override
    boolean setNextValue() {
        if (currentValue >= currentMaxFieldDomainIndex)
            return false;

        if (isCurrentFieldPrimitive) {
            increaseCurrentFieldValue();
            return true;
        }
        return setNextReferenceTypeValue();
    }

    @Override
    void backtrack() {
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

    protected boolean setNextReferenceTypeValue() {
        if (!isCurrentFieldInitialized()) {
            initializeField(currentIndex, currentFieldDomain);
        }
        if (currentValue <= maxInstances[currentIndex]) {
            increaseCurrentFieldValue();
            return true;
        }
        return false;
    }

    protected boolean isCurrentFieldInitialized() {
        return maxInstances[currentIndex] != -1;
    }

    protected void setFieldAsNotInitialized(int index) {
        maxInstances[index] = -1;
    }

    protected void initializeField(int index, FieldDomain fieldDomain) {
        maxInstances[index] = getMaxInstanceInVector(fieldDomain);
    }

}
