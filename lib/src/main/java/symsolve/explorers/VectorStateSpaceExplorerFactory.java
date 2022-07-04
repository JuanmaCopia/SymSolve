package symsolve.explorers;

import symsolve.explorers.impl.SymmetryBreakStrategy;

public interface VectorStateSpaceExplorerFactory {

    public VectorStateSpaceExplorer makeSymoblicVectorExplorer(SymmetryBreakStrategy strategy);

}
