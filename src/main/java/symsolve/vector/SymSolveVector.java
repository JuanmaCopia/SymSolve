package symsolve.vector;


import korat.utils.IntListAI;

import java.util.Arrays;

/**
 * Class that holds the representations of partially symbolic vectors.
 *
 * @author Juan Manuel Copia
 */
public class SymSolveVector {

    public static final int SYMBOLIC = -1;
    public static final int NULL = 0;

    int length;
    int[] concreteVector;
    IntListAI fixedIndices;

    /**
     * Creates a vector a SymKoratVector instance holding the vector
     * representations.
     *
     * @param concreteVector The concrete vector representation (Symbolic fields
     *                       represented with 0).
     * @param fixedIndices   The set of Fixed indices in this vector.
     */
    public SymSolveVector(int[] concreteVector, IntListAI fixedIndices) {
        this.length = concreteVector.length;
        this.concreteVector = concreteVector;
        this.fixedIndices = fixedIndices;
    }

    public SymSolveVector(int vectorSize) {
        this.length = vectorSize;
        this.concreteVector = new int[vectorSize];
        this.fixedIndices = new IntListAI(vectorSize);
    }

    /**
     * Creates a vector a SymKoratVector instance by calculating the different
     * vector representations from a string partial representation (symbolic fields
     * represented by -1).
     *
     * @param vector the string representation of the partial vector.
     */
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

    public int getLength() {
        return length;
    }


    /**
     * Returns the concrete vector representation of this vector. i.e. symbolic
     * values are encoded with 0.
     *
     * @return A clone of the concrete vector representation.
     */
    public int[] getConcreteVector() {
        return concreteVector.clone();
    }

    public void setConcreteVector(int[] newConcreteVector) {
        concreteVector = newConcreteVector;
    }

    /**
     * Returns the set of Fixed indices in this vector.
     *
     * @return A clone of the fixed indices of this vector.
     */
    public IntListAI getFixedIndices() {
        return new IntListAI(fixedIndices);
    }

    public boolean isSymbolicIndex(int index) {
        return !fixedIndices.contains(index);
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nConcreteVector: " + Arrays.toString(this.concreteVector));
        sb.append("\nFixed Indices: " + this.fixedIndices.toString());
        return sb.toString();
    }
}
