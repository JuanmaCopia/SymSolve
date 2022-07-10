package symsolve.explorers.impl;

import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.explorers.VectorStateSpaceExplorerFactory;

public class SymbolicVectorExplorerFactory implements VectorStateSpaceExplorerFactory {

    StateSpace stateSpace;

    IIntList accessedIndices;

    IIntList changedFields;

    public SymbolicVectorExplorerFactory(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        this.stateSpace = stateSpace;
        this.accessedIndices = accessedIndices;
        this.changedFields = changedFields;
    }

    public VectorStateSpaceExplorer makeSymoblicVectorExplorer(SymmetryBreakStrategy strategy) {
        switch (strategy) {
            case SYMMETRY_BREAK:
                return new SymmetryBreakingExplorer(this.stateSpace, accessedIndices, changedFields);
            case SYMMETRY_BREAK_REVERSE:
                return new ReverseSymmetryBreakingExplorer(this.stateSpace, accessedIndices, changedFields);
            case NO_SYMMETRY_BREAK:
                return new NoSymmetryBreakingExplorer(this.stateSpace, accessedIndices, changedFields);
            default:
                throw new IllegalArgumentException(strategy.name() + " is not a valid Exploration Strategy ");
        }
    }

}
