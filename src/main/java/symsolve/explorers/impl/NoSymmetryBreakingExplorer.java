package symsolve.explorers.impl;

import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;

public class NoSymmetryBreakingExplorer extends AbstractVectorStateSpaceExplorer {

    public NoSymmetryBreakingExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        super(stateSpace, accessedIndices, changedFields);
    }

    @Override
    protected boolean setNextValue() {
        if (currentValue >= maxFieldDomainValue)
            return false;

        increaseCurrentFieldValue();
        return true;
    }

    @Override
    protected void backtrack() {
        resetCurrentFieldValue();
    }

}
