package eval.config;

public class EvalConfig {

    static final String DEFAULT_PREDICATE_NAME = "repOK";
    static final String DEFAULT_GROUND_TRUTH_PREDICATE_NAME = "repOK";

    String fullClassName;
    String[] finitizationArgs;
    String finitizationName;
    String evaluatedPredicateName;
    String groundTruthPredicateName;


    public String[] getFinitizationArgs() {
        return finitizationArgs;
    }

    public String getFinitizationName() {
        return finitizationName;
    }

    public String getFullyQualifiedClassName() {
        return fullClassName;
    }

    public String getEvaluatedPredicateName() {
        return evaluatedPredicateName;
    }

    public String getGroundTruthPredicateName() {
        return groundTruthPredicateName;
    }

    protected String calculateFinitizationName(String fullClassName) {
        String[] cs = fullClassName.split("\\.");
        return "fin" + cs[cs.length - 1];
    }

    public EvalConfig(String fullClassName, String finitizationArgs, String predicateName, String groundTruthPredicateName) {
        this.fullClassName = fullClassName;
        this.evaluatedPredicateName = predicateName;
        this.groundTruthPredicateName = groundTruthPredicateName;
        this.finitizationArgs = finitizationArgs.split(",");
        this.finitizationName = calculateFinitizationName(fullClassName);
    }

    public EvalConfig(String fullClassName, String finitizationArgs) {
        this(fullClassName, finitizationArgs, DEFAULT_PREDICATE_NAME, DEFAULT_GROUND_TRUTH_PREDICATE_NAME);
    }

}
