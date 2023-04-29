package symsolve.config;

import symsolve.explorers.impl.SymmetryBreakStrategy;

public abstract class SymSolveConfig {

    static final String DEFAULT_PREDICATE_NAME = "repOK";
    static final SymmetryBreakStrategy DEFAULT_SBREAK_STRATEGY = SymmetryBreakStrategy.SYMMETRY_BREAK;

    String fullClassName;
    String[] finitizationArgs;
    String finitizationName;
    String predicateName;
    SymmetryBreakStrategy symmetryBreakStrategy;


    public String[] getFinitizationArgs() {
        return finitizationArgs;
    }

    public String getFinitizationName() {
        return finitizationName;
    }

    public String getFullyQualifiedClassName() {
        return fullClassName;
    }

    public String getPredicateName() {
        return predicateName;
    }

    public SymmetryBreakStrategy getSymmetryBreakStrategy() {
        return symmetryBreakStrategy;
    }

    protected String calculateFinitizationName(String fullClassName) {
        String[] cs = fullClassName.split("\\.");
        return "fin" + cs[cs.length - 1];
    }

}
