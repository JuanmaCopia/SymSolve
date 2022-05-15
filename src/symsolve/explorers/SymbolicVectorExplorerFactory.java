package symsolve.explorers;

import korat.finitization.impl.StateSpace;
import symsolve.explorers.SymbolicVectorExplorerFactory;

public class SymbolicVectorExplorerFactory {

    StateSpace stateSpace;

    public SymbolicVectorExplorerFactory(StateSpace stateSpace) {
        this.stateSpace = stateSpace;
    }

    public SymmetryBreakingExplorer makeSymoblicVectorExplorer(ExplorationStrategy strategy) {
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
