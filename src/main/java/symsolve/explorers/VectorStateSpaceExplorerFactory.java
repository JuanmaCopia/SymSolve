package symsolve.explorers;

import symsolve.config.ConfigParameters;

public interface VectorStateSpaceExplorerFactory {

    VectorStateSpaceExplorer makeSymbolicVectorExplorer(ConfigParameters config);

}
