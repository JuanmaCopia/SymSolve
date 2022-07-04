package symsolve;

import symsolve.explorers.impl.SymmetryBreakStrategy;

public class ConfigParameters {
    
    static final String DEFAULT_PREDICATE_NAME = "repOK";
    static final SymmetryBreakStrategy DEFAULT_SBREAK_STRATEGY = SymmetryBreakStrategy.SYMMETRY_BREAK_REVERSE;

    String fullClassName;
    String[] finitizationArgs;
    String finitizationName;
    String predicateName;
    SymmetryBreakStrategy symmetryBreakStrategy;
    
    public ConfigParameters(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy, String predicateName) {
        this.fullClassName = fullClassName;
        this.finitizationArgs = finitizationArgs.split(",");
        this.finitizationName = calculateFinitizationName(fullClassName);
        this.symmetryBreakStrategy = symmetryBreakingStrategy;
        this.predicateName = predicateName;
    }

    public ConfigParameters(String fullClassName, String finitizationArgs, SymmetryBreakStrategy symmetryBreakingStrategy) {
        this(fullClassName, finitizationArgs, symmetryBreakingStrategy, DEFAULT_PREDICATE_NAME);
    }

    public ConfigParameters(String fullClassName, String finitizationArgs) {
        this(fullClassName, finitizationArgs, DEFAULT_SBREAK_STRATEGY, DEFAULT_PREDICATE_NAME);
    }

    public String[] getFinitizationArgs() {
        return this.finitizationArgs;
    }

    public String getFinitizationName() {
        return this.finitizationName;
    }

    public String getFullyQualifiedClassName() {
        return this.fullClassName;
    }
    
    public String getPredicateName() {
        return this.predicateName;
    }

    public SymmetryBreakStrategy getsymmetryBreakStretegy() {
        return this.symmetryBreakStrategy;
    }

    private String calculateFinitizationName(String fullClassName) {
        String[] cs = fullClassName.split("\\.");
        return "fin" + cs[cs.length - 1];
    }

}
