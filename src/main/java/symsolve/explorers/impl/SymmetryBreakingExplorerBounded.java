package symsolve.explorers.impl;

import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;

public class SymmetryBreakingExplorerBounded extends SymmetryBreakingExplorer {


    public SymmetryBreakingExplorerBounded(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        super(stateSpace, accessedIndices, changedFields);
    }
}
