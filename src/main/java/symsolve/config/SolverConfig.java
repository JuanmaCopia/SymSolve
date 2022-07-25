package symsolve.config;

import symsolve.bounds.Bounds;
import symsolve.explorers.impl.SymmetryBreakStrategy;

public class SolverConfig extends SymSolveConfig {

    Bounds bounds;

    public SolverConfig(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy, String predicateName, Bounds bounds) {
        this.fullClassName = fullClassName;
        this.finitizationArgs = finitizationArgs.split(",");
        this.finitizationName = calculateFinitizationName(fullClassName);
        this.symmetryBreakStrategy = symmetryBreakingStrategy;
        this.predicateName = predicateName;
        this.bounds = bounds;
    }

    public SolverConfig(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy, String predicateName) {
        this(fullClassName, finitizationArgs, symmetryBreakingStrategy, predicateName, null);
    }

    public SolverConfig(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy, Bounds bounds) {
        this(fullClassName, finitizationArgs, symmetryBreakingStrategy, DEFAULT_PREDICATE_NAME, bounds);
    }

    public SolverConfig(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy) {
        this(fullClassName, finitizationArgs, symmetryBreakingStrategy, DEFAULT_PREDICATE_NAME, null);
    }

    public SolverConfig(String fullClassName, String finitizationArgs) {
        this(fullClassName, finitizationArgs, DEFAULT_SBREAK_STRATEGY, DEFAULT_PREDICATE_NAME, null);
    }

    public Bounds getBounds() {
        return bounds;
    }

}
