package symsolve.explorers;

import symsolve.explorers.impl.SymmetryBreakStrategy;

public interface VectorStateSpaceExplorerFactory {

    VectorStateSpaceExplorer makeSymbolicVectorExplorer(SymmetryBreakStrategy strategy);

}
