
package symkorat;


import java.util.Set;
import java.util.HashSet;


/**
 *
 */
public class SymKoratVector {


	public static final int SYMBOLIC = -1;

	public static final int NULL = 0;

	private int[] concreteVector;

	private int[] partialVector;

	private Set<Integer> fixedIndices = new HashSet<Integer>();


	/**
	 *
	 * @return
	 */
	public int[] getPartialVector() {
		return this.partialVector;
	}

	/**
	 *
	 * @return
	 */
	public int[] getConcreteVector() {
		return this.concreteVector;
	}

	/**
	 *
	 * @return
	 */
	public Set<Integer> getFixedIndices() {
		return fixedIndices;
	}

	/**
	 *
	 * @param concreteVector
	 * @param fixedIndices
	 */
	public SymKoratVector(int[] concreteVector, int[] partialVector, Set<Integer> fixedIndices ) {
		this.concreteVector = concreteVector;
		this.fixedIndices = fixedIndices;
		this.partialVector = partialVector;
	}

	/**
	 *
	 * @param vector
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
			}
        	else {
        		this.concreteVector[i] = elem;
        		this.fixedIndices.add(i);
        	}
        }
	}
}
