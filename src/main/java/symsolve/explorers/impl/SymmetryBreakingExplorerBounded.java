package symsolve.explorers.impl;

import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import symsolve.bounds.Bounds;

public class SymmetryBreakingExplorerBounded extends SymmetryBreakingExplorer {


    public SymmetryBreakingExplorerBounded(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields, Bounds bounds) {
        super(stateSpace, accessedIndices, changedFields);
    }
}
