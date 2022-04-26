
package symkorat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that holds the representations of partially symbolic vectors.
 *
 * @author Juan Manuel Copia
 */
public class SymKoratVector {

	public static final int SYMBOLIC = -1;

	public static final int NULL = 0;

	private int[] concreteVector;

	private int[] partialVector;

	private Set<Integer> fixedIndices = new HashSet<Integer>();

	/**
	 * Returns the partial vector representation of this vector. i.e. symbolic
	 * values are encoded with -1.
	 *
	 * @return A clone of the partial vector representation.
	 */
	public int[] getPartialVector() {
		return this.partialVector.clone();
	}

	/**
	 * Returns the concrete vector representation of this vector. i.e. symbolic
	 * values are encoded with 0.
	 *
	 * @return A clone of the concrete vector representation.
	 */
	public int[] getConcreteVector() {
		return this.concreteVector.clone();
	}

	/**
	 * Returns the set of Fixed indices in this vector.
	 *
	 * @return A clone of the fixed indices of this vector.
	 */
	public Set<Integer> getFixedIndices() {
		return new HashSet<Integer>(this.fixedIndices);
	}

	/**
	 * Creates a vector a SymKoratVector instance holding the vector
	 * representations.
	 *
	 * @param concreteVector The concrete vector representation (Symbolic fields
	 *                       represented with 0).
	 * @param partialVector  The partial vector representation (Symbolic fields
	 *                       represented with -1).
	 * @param fixedIndices   The set of Fixed indices in this vector.
	 */
	public SymKoratVector(int[] concreteVector, int[] partialVector, Set<Integer> fixedIndices) {
		this.concreteVector = concreteVector;
		this.fixedIndices = fixedIndices;
		this.partialVector = partialVector;
	}

	/**
	 * Creates a vector a SymKoratVector instance by calculating the different
	 * vector representations from a string partial representation (symbolic fields
	 * represented by -1).
	 *
	 * @param vector the string representation of the partial vector.
	 */
	public SymKoratVector(String vector) {
		String[] vectorValues = vector.split(",");
		int vectorsSize = vectorValues.length;

		this.concreteVector = new int[vectorsSize];
		this.partialVector = new int[vectorsSize];
		for (int i = 0; i < vectorsSize; i++) {
			int elem = Integer.parseInt(vectorValues[i]);
			this.partialVector[i] = elem;
			if (elem == SymKoratVector.SYMBOLIC) {
				this.concreteVector[i] = SymKoratVector.NULL;
			} else {
				this.concreteVector[i] = elem;
				this.fixedIndices.add(i);
			}
		}
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("PartialVector: " + Arrays.toString(this.partialVector));
	    sb.append("\nConcreteVector: " + Arrays.toString(this.concreteVector));
	    sb.append("\nFixed Indices: " + this.fixedIndices.toString());
	    return sb.toString();  
	}
}
