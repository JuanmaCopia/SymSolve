package symsolve.config;

import symsolve.explorers.impl.SymmetryBreakStrategy;

public class SolverConfig extends SymSolveConfig {

    public SolverConfig(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy, String predicateName) {
        this.fullClassName = fullClassName;
        this.finitizationArgs = finitizationArgs.split(",");
        this.symmetryBreakStrategy = symmetryBreakingStrategy;
        this.predicateName = predicateName;
        this.finitizationName = calculateFinitizationName(fullClassName);
    }

    public SolverConfig(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy) {
        this(fullClassName, finitizationArgs, symmetryBreakingStrategy, DEFAULT_PREDICATE_NAME);
    }

    public SolverConfig(String fullClassName, String finitizationArgs) {
        this(fullClassName, finitizationArgs, DEFAULT_SBREAK_STRATEGY, DEFAULT_PREDICATE_NAME);
    }

}
