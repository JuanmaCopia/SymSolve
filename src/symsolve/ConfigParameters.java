package symsolve;

import symsolve.explorers.impl.ExplorationStrategy;

public class ConfigParameters {

    String fullClassName;
    String[] finitizationArgs;
    String finitizationName;
    ExplorationStrategy strategy;

    public ConfigParameters(String fullClassName, String finitizationArgs, ExplorationStrategy strategy) {
        this.fullClassName = fullClassName;
        this.finitizationArgs = finitizationArgs.split(",");
        this.finitizationName = calculateFinitizationName(fullClassName);
        this.strategy = strategy;
    }

    public ConfigParameters(String fullClassName, String finitizationArgs) {
        this.fullClassName = fullClassName;
        this.finitizationArgs = finitizationArgs.split(",");
        this.finitizationName = calculateFinitizationName(fullClassName);
        this.strategy = ExplorationStrategy.SYMMETRY_BREAK;
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

    public ExplorationStrategy getExplorationStretegy() {
        return this.strategy;
    }

    private String calculateFinitizationName(String fullClassName) {
        String[] cs = fullClassName.split("\\.");
        return "fin" + cs[cs.length - 1];
    }

}
