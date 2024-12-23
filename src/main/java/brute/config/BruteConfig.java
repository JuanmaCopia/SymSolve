package brute.config;

public class BruteConfig {

    static final String DEFAULT_PREDICATE_NAME = "repOK";

    String fullClassName;
    String[] finitizationArgs;
    String finitizationName;
    String predicateName;


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

    protected String calculateFinitizationName(String fullClassName) {
        String[] cs = fullClassName.split("\\.");
        return "fin" + cs[cs.length - 1];
    }

    public BruteConfig(String fullClassName, String finitizationArgs, String predicateName) {
        this.fullClassName = fullClassName;
        this.finitizationArgs = finitizationArgs.split(",");
        this.predicateName = predicateName;
        this.finitizationName = calculateFinitizationName(fullClassName);
    }

    public BruteConfig(String fullClassName, String finitizationArgs) {
        this(fullClassName, finitizationArgs, DEFAULT_PREDICATE_NAME);
    }

}
