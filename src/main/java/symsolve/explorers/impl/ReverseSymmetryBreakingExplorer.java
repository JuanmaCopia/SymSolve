package symsolve.explorers.impl;

import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;

public class ReverseSymmetryBreakingExplorer extends AbstractVectorStateSpaceExplorer {

    private final boolean[] initializedFields;


    public ReverseSymmetryBreakingExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        super(stateSpace, accessedIndices, changedFields);
        initializedFields = new boolean[vectorSize];
    }

    @Override
    boolean setNextValue() {
        if (isCurrentFieldPrimitive)
            return setNextPrimitiveTypeValue();

        return setNextReferenceTypeValue();
    }

    @Override
    void backtrack() {
        resetCurrentFieldValue();
        setCurrentFieldAsNotInitialized();
    }

    @Override
    public void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++) {
            setIndexAsChanged(i);
            initializedFields[i] = isIndexFixed(i) && candidateVector[i] > 0;
        }
    }

    protected boolean setNextPrimitiveTypeValue() {
        if (lastPrimitiveValueReached())
            return false;
        increaseCurrentFieldValue();
        return true;
    }

    protected boolean setNextReferenceTypeValue() {
        if (!isCurrentFieldInitialized()) {
            initializeCurrentField();
            int firstValue = getFirstValue();
            setCurrentFieldValue(firstValue);
            return true;
        }

        if (!lastReferenceValueReached()) {
            decreaseCurrentFieldValue();
            return true;
        }
        return false;
    }

    private boolean isCurrentFieldInitialized() {
        return initializedFields[currentIndex];
    }

    private void initializeCurrentField() {
        initializedFields[currentIndex] = true;
    }

    private void setCurrentFieldAsNotInitialized() {
        initializedFields[currentIndex] = false;
    }

    private boolean lastReferenceValueReached() {
        return currentValue <= 1;
    }

    private boolean lastPrimitiveValueReached() {
        return currentValue >= currentMaxFieldDomainIndex;
    }

    private int getFirstValue() {
        int maxIndexInVector = getMaxInstanceInVector(currentFieldDomain);
        if (maxIndexInVector >= currentMaxFieldDomainIndex) {
            return maxIndexInVector;
        }
        return maxIndexInVector + 1;
    }

}
