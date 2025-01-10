package eval.config;

public class EvalConfig {

    String subjectClassName;
    String[] finitizationArgs;
    String finitizationName;
    String predicateClassName;
    String evaluatedPredicateName;
    String groundTruthPredicateName;

    public boolean validClassValidStructures;


    public String[] getFinitizationArgs() {
        return finitizationArgs;
    }

    public String getFinitizationName() {
        return finitizationName;
    }

    public String getSubjectClassName() {
        return subjectClassName;
    }

    public String getPredicateClassName() {
        return predicateClassName;
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

    public EvalConfig(String subjectClassName, String predicateClassName, String finitizationArgs, String predicateName, String groundTruthPredicateName, boolean validClassValidStructures) {
        this.subjectClassName = subjectClassName;
        this.evaluatedPredicateName = predicateName;
        this.groundTruthPredicateName = groundTruthPredicateName;
        this.finitizationArgs = finitizationArgs.split(",");
        this.finitizationName = calculateFinitizationName(subjectClassName);
        this.predicateClassName = predicateClassName;
        this.validClassValidStructures = validClassValidStructures;
    }
}
