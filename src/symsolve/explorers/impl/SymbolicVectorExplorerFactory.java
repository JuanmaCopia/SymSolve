package symsolve.explorers.impl;

import korat.finitization.impl.StateSpace;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.explorers.VectorStateSpaceExplorerFactory;
import symsolve.explorers.impl.SymbolicVectorExplorerFactory;

public class SymbolicVectorExplorerFactory implements VectorStateSpaceExplorerFactory {

    StateSpace stateSpace;

    public SymbolicVectorExplorerFactory(StateSpace stateSpace) {
        this.stateSpace = stateSpace;
    }

    public VectorStateSpaceExplorer makeSymoblicVectorExplorer(ExplorationStrategy strategy) {
        switch (strategy) {
        case SYMMETRY_BREAK:
            return new SymmetryBreakingExplorer(this.stateSpace);
        case SYMMETRY_BREAK_REVERSE:
            return new ReverseSymmetryBreakingExplorer(this.stateSpace);
        case NO_SYMMETRY_BREAK:
            return new NoSymmetryBreakingExplorer(this.stateSpace);
        default:
            throw new IllegalArgumentException(strategy.name() + " is not a valid Exploration Strategy ");
        }
    }

}
