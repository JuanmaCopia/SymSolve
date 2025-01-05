package eval.results;

public class Results {

    int truePositives = 0;
    int falsePositives = 0;
    int trueNegatives = 0;
    int falseNegatives = 0;

    public void incrementTruePositives() {
        truePositives++;
    }

    public void incrementFalsePositives() {
        falsePositives++;
    }

    public void incrementTrueNegatives() {
        trueNegatives++;
    }

    public void incrementFalseNegatives() {
        falseNegatives++;
    }

    public int getTruePositives() {
        return truePositives;
    }

    public int getFalsePositives() {
        return falsePositives;
    }

    public int getTrueNegatives() {
        return trueNegatives;
    }

    public int getFalseNegatives() {
        return falseNegatives;
    }

    public Double getPrecision() {
        return (double) truePositives / (truePositives + falsePositives);
    }

    public Double getRecall() {
        return (double) truePositives / (truePositives + falseNegatives);
    }

    public Double getAccuracy() {
        return (double) (truePositives + trueNegatives) / (truePositives + trueNegatives + falsePositives + falseNegatives);
    }

    public Double getF1Score() {
        return 2 * (getPrecision() * getRecall()) / (getPrecision() + getRecall());
    }

    public void printResults() {
        System.out.println("True Positives: " + truePositives);
        System.out.println("False Positives: " + falsePositives);
        System.out.println("True Negatives: " + trueNegatives);
        System.out.println("False Negatives: " + falseNegatives);
        System.out.println("Precision: " + getPrecision());
        System.out.println("Recall: " + getRecall());
        System.out.println("F1 Score: " + getF1Score());
        System.out.println("Accuracy: " + getAccuracy());
    }
}
