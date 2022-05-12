package symsolve.explorers;

import symsolve.explorers.impl.ExplorationStrategy;
import symsolve.explorers.impl.SymbolicVectorExplorer;

public interface SymbolicVectorExplorerFactory {
    
    public SymbolicVectorExplorer makeSymoblicVectorExplorer(ExplorationStrategy strategy);
}
