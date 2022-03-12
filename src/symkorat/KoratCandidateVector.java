package symkorat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;

import korat.finitization.impl.CVElem;


public class KoratCandidateVector {

	private class Pair<T, U> {
		public T first;
		public U second;

		public Pair(T a, U b) {
			this.first = a;
			this.second = b;
		}
	}

	public static final int SYM = -1;

	public static final int NULL = 0;

	HashSet<String> vectorFieldNames = new HashSet<String>();

	LinkedList<String> classOrder = new LinkedList<String>();

	HashMap<String, Integer> numElems = new HashMap<String, Integer>();

	HashMap<String, ArrayList<Pair<String,Integer>>> subvectors = new HashMap<String, ArrayList<Pair<String,Integer>>>();

	int length;

	public int[] candidateVector;

	public int[] originalVector;

	public HashSet<Integer> fixedIndices = new HashSet<Integer>();


	public KoratCandidateVector(CVElem[] structureList) {
		length = structureList.length;

		for (int i = 0; i < structureList.length; i++) {

            CVElem elem = structureList[i];
            String ownerClassName = elem.getObj().getClass().getSimpleName();
            String fieldName = elem.getFieldName();

            ArrayList<Pair<String,Integer>> subv = subvectors.get(ownerClassName);
			if (subv == null) {
				subv = new ArrayList<Pair<String,Integer>>();
				subvectors.put(ownerClassName, subv);
				numElems.put(ownerClassName, 0);
				classOrder.add(ownerClassName);
			}

			vectorFieldNames.add(ownerClassName + "." + fieldName);
			subv.add(new Pair<String,Integer>(fieldName, SYM));
        }
	}

	public void initialize() {
		fixedIndices.clear();

		for (String cls : subvectors.keySet()) {
			ArrayList<Pair<String,Integer>> sv = subvectors.get(cls);

			for (Pair<String,Integer> p : sv) {
				p.second = SYM;
			}

			numElems.put(cls, 0);
		}
	}

	public boolean containsField(String fieldName) {
		return vectorFieldNames.contains(fieldName);
	}

	public void add(String ownerClassName, String fieldName, int value) {
		ArrayList<Pair<String,Integer>> subv = subvectors.get(ownerClassName);

		if (subv == null)
			throw new IllegalArgumentException(ownerClassName + "not found in subvectors");

		Integer index = numElems.get(ownerClassName);
		Pair<String,Integer> kCVElem = subv.get(index);

		if (!kCVElem.first.equals(fieldName))
			throw new IllegalArgumentException(fieldName + " is different from " + kCVElem.first);

		kCVElem.second = value;
		numElems.put(ownerClassName, index + 1);
	}


	public HashSet<String> getVectorFieldNames() {
		return vectorFieldNames;
	}

	public String getVectorDescription() {
		String vector = "";
		for (String cls : classOrder) {
			ArrayList<Pair<String,Integer>> sv = subvectors.get(cls);

			for (Pair<String,Integer> p : sv)
				vector += cls + "." + p.first + ", ";
		}
		return vector.substring(0, vector.length() - 2);
	}

	public String getStringPartialVector() {
		return Arrays.toString(originalVector);
	}

	public String getStringPartialVector2() {
		String vector = "";
		for (int i = 0; i < originalVector.length; i++) {
			vector += originalVector[i];
			if (i < originalVector.length - 1)
				vector += ",";
		}
		return vector;
	}

	public String getStringCV() {
		return Arrays.toString(candidateVector);
	}

	public void calculateCandidateVector() {
		candidateVector = new int[length];
		originalVector = new int[length];
		int index = 0;
		for (String cls : classOrder) {
			ArrayList<Pair<String,Integer>> sv = subvectors.get(cls);

			for (Pair<String,Integer> p : sv) {
				int value = p.second;
				originalVector[index] = value;
				if (value <= -1)
					candidateVector[index]= 0;
				else {
					fixedIndices.add(index);
					candidateVector[index]= value;
				}
				index++;
			}
		}
	}
}