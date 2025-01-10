package eval.results;

public class Results {

    long TP = 0;
    long FP = 0;
    long TN = 0;
    long FN = 0;

    public void incrementTruePositives() {
        TP++;
    }

    public void incrementFalsePositives() {
        FP++;
    }

    public void incrementTrueNegatives() {
        TN++;
    }

    public void incrementFalseNegatives() {
        FN++;
    }

    public long getTruePositives() {
        return TP;
    }

    public long getFalsePositives() {
        return FP;
    }

    public long getTrueNegatives() {
        return TN;
    }

    public long getFalseNegatives() {
        return FN;
    }

    public Double getPrecision() {
        return (double) TP / (TP + FP);
    }

    public Double getRecall() {
        return (double) TP / (TP + FN);
    }

    public Double getAccuracy() {
        return (double) (TP + TN) / (TP + TN + FP + FN);
    }

    public Double getF1Score() {
        return 2 * (getPrecision() * getRecall()) / (getPrecision() + getRecall());
    }

    public Double getSpecificity() {
        return (double) TN / (TN + FP);
    }

    public Double getBalancedAccuracy() {
        return (getRecall() + getSpecificity()) / 2;
    }

    public Double getMCC() {
        long numerator = (TP * TN) - (FP * FN);  // Correct formula
        double denominator = Math.sqrt((TP + FP) * (TP + FN) * (TN + FP) * (TN + FN));
        return numerator / denominator;
    }


    public void printResults() {
        System.out.println("True Positives: " + TP);
        System.out.println("False Positives: " + FP);
        System.out.println("True Negatives: " + TN);
        System.out.println("False Negatives: " + FN);
        System.out.println("Precision: " + getPrecision());
        System.out.println("Recall: " + getRecall());
        System.out.println("F1 Score: " + getF1Score());
        System.out.println("Accuracy: " + getAccuracy());
        //System.out.println("Specificity: " + getSpecificity());
        System.out.println("Balanced Accuracy: " + getBalancedAccuracy());
        System.out.println("MCC: " + getMCC());
    }
}
