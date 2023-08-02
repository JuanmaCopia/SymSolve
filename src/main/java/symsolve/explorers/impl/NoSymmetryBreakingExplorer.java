package symsolve.explorers.impl;

import korat.finitization.impl.StateSpace;

public class NoSymmetryBreakingExplorer extends AbstractVectorStateSpaceExplorer {

    public NoSymmetryBreakingExplorer(StateSpace stateSpace) {
        super(stateSpace);
    }

    @Override
    protected boolean setNextValue() {
        if (currentValue >= maxFieldDomainValue)
            return false;

        candidateVector[currentIndex]++;
        return true;
    }

    @Override
    protected void backtrack() {
        candidateVector[currentIndex] = 0;
    }

}
