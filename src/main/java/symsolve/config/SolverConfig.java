package symsolve.config;

import symsolve.bounds.Bounds;
import symsolve.explorers.impl.SymmetryBreakStrategy;

public class SolverConfig extends SymSolveConfig {

    Bounds bounds;

    public SolverConfig(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy, Bounds bounds, String predicateName) {
        this.fullClassName = fullClassName;
        this.finitizationArgs = finitizationArgs.split(",");
        this.finitizationName = calculateFinitizationName(fullClassName);
        this.symmetryBreakStrategy = symmetryBreakingStrategy;
        this.predicateName = predicateName;
        this.bounds = bounds;
    }

    public SolverConfig(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy, Bounds bounds) {
        this(fullClassName, finitizationArgs, symmetryBreakingStrategy, bounds, DEFAULT_PREDICATE_NAME);
    }

    public SolverConfig(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy) {
        this(fullClassName, finitizationArgs, symmetryBreakingStrategy, null, DEFAULT_PREDICATE_NAME);
    }

    public SolverConfig(String fullClassName, String finitizationArgs) {
        this(fullClassName, finitizationArgs, DEFAULT_SBREAK_STRATEGY, null, DEFAULT_PREDICATE_NAME);
    }

    public Bounds getBounds() {
        return bounds;
    }

}
