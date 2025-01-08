package eval.util;

import java.util.Arrays;

public class CandidateResult {
    private final Object rootObject;
    private final int[] vector;
    private final boolean isValid;

    public CandidateResult(Object rootObject, int[] vector, boolean isValid) {
        this.rootObject = rootObject;
        this.isValid = isValid;
        this.vector = vector;
    }

    public Object getObject() {
        return rootObject;
    }

    public boolean isValid() {
        return isValid;
    }

    public int[] getVector() {
        return vector;
    }

    @Override
    public String toString() {
        return "CandidateResult{" +
                "vector=" + Arrays.toString(vector) +
                ", isValid=" + isValid +
                '}';
    }
}
