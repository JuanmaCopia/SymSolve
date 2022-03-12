
package symkorat;


import java.util.Set;
import java.util.HashSet;


/**
 *
 */
public class SymKoratVector {


	public static final int SYMBOLIC = -1;

	public static final int NULL = 0;

	private int[] vector;

	private Set<Integer> fixedIndices = new HashSet<Integer>();

	/**
	 *
	 * @return
	 */
	public int[] getVector() {
		return vector;
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
	 * @param vector
	 * @param fixedIndices
	 */
	public SymKoratVector(int[] vector, Set<Integer> fixedIndices ) {
		this.vector = vector;
		this.fixedIndices = fixedIndices;
	}

	/**
	 *
	 * @param vector
	 */
	public SymKoratVector(String vector) {
		String[] vectorElements = vector.split(",");
		int vectorSize = vectorElements.length;

        this.vector = new int[vectorSize];
        for (int i = 0; i < vectorSize; i++) {
        	int elem = Integer.parseInt(vectorElements[i]);
        	if (elem == SymKoratVector.SYMBOLIC) {
				this.vector[i] = SymKoratVector.NULL;
			}
        	else {
        		this.vector[i] = elem;
        		this.fixedIndices.add(i);
        	}
        }
	}

}