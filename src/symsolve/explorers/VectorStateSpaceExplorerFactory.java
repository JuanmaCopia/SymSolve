package symsolve.explorers;

import symsolve.explorers.impl.ExplorationStrategy;

public interface VectorStateSpaceExplorerFactory {

    public VectorStateSpaceExplorer makeSymoblicVectorExplorer(ExplorationStrategy strategy);

}
