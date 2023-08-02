package symsolve.vector;


import korat.utils.IntListAI;

import java.util.Arrays;

/**
 * Class that holds the representations of partially symbolic vectors.
 */
public final class SymSolveVector {

    public static final int SYMBOLIC = -1;
    public static final int NULL = 0;

    private final int length;
    private final int[] concreteVector;
    private final IntListAI fixedIndices;


    public SymSolveVector(int[] concreteVector, IntListAI fixedIndices) {
        this.length = concreteVector.length;
        this.concreteVector = concreteVector.clone();
        this.fixedIndices = fixedIndices.clone();
    }

    public SymSolveVector(SymSolveSolution solution) {
        this.concreteVector = solution.getSolutionVector();
        this.length = concreteVector.length;
        this.fixedIndices = solution.getQueryFixedIndices();
    }

    public SymSolveVector(int vectorLength) {
        this.length = vectorLength;
        this.concreteVector = new int[vectorLength];
        this.fixedIndices = new IntListAI(vectorLength);
    }

    public SymSolveVector(String vector) {
        String[] vectorValues = vector.split(",");

        length = vectorValues.length;
        concreteVector = new int[length];
        fixedIndices = new IntListAI(length);

        for (int i = 0; i < length; i++) {
            int elem = Integer.parseInt(vectorValues[i].trim());
            if (elem == SymSolveVector.SYMBOLIC) {
                concreteVector[i] = SymSolveVector.NULL;
            } else {
                concreteVector[i] = elem;
                fixedIndices.add(i);
            }
        }
    }

    public boolean isSymbolicIndex(int index) {
        return !fixedIndices.contains(index);
    }

    public int getLength() {
        return length;
    }

    public int[] getConcreteVector() {
        return concreteVector.clone();
    }

    public IntListAI getFixedIndices() {
        return fixedIndices.clone();
    }

    public int[] createPartialVector() {
        int[] partialVector = new int[length];
        for (int i = 0; i < length; i++) {
            if (this.fixedIndices.contains(i))
                partialVector[i] = concreteVector[i];
            else
                partialVector[i] = SYMBOLIC;
        }
        return partialVector;
    }

    @Override
    public SymSolveVector clone() {
        return new SymSolveVector(concreteVector.clone(), fixedIndices.clone());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nConcreteVector: " + Arrays.toString(this.concreteVector));
        sb.append("\nFixed Indices: " + this.fixedIndices.toString());
        return sb.toString();
    }
}
