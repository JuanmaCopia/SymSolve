package symkorat;

import java.util.HashMap;
import java.util.Set;

import korat.finitization.IFinitization;
import korat.finitization.impl.CVElem;
import korat.finitization.impl.CandidateBuilder;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.Finitization;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import korat.utils.IntListAI;

public class SolverStateSpaceExplorer {

    protected StateSpace stateSpace;

    protected CandidateBuilder candidateBuilder;

    protected int[] candidateVector;
    
    protected int[] maxInstances;
    
    protected boolean[] isInitialized;

    protected IIntList accessedFields;

    protected IIntList changedFields;

    protected IIntList fixedIndices;
    
    protected HashMap<FieldDomain, Integer> maxFixedInstances;

    public SolverStateSpaceExplorer(IFinitization ifin, SymKoratVector vector) {
        Finitization fin = (Finitization) ifin;
        stateSpace = fin.getStateSpace();

        int vectorSize = stateSpace.getTotalNumberOfFields();
        this.candidateVector = vector.getConcreteVector();
        if (vectorSize != this.candidateVector.length)
            throw new IllegalArgumentException("The input vector does not match the finitization!");
        
        this.isInitialized = new boolean[vectorSize];
        this.maxInstances = new int[vectorSize];
        accessedFields = new IntListAI(vectorSize);
        changedFields = new IntListAI(vectorSize);
        fixedIndices = new IntListAI(vectorSize);
        for (int i = 0; i < vectorSize; i++) {
        	maxInstances[i] = -1;
            changedFields.add(i);
        }

        candidateBuilder = new CandidateBuilder(stateSpace, changedFields);
        initializeMaxFixedInstances(vector.getFixedIndices());
    }

    protected IIntList getAccessedFields() {
        return accessedFields;
    }

    protected int[] getCandidateVector() {
        return candidateVector;
    }

    protected Object buildCandidate() {
        return candidateBuilder.buildCandidate(candidateVector);
    }

    
    private void initializeMaxFixedInstances(Set<Integer> fi) {
    	maxFixedInstances = new HashMap<FieldDomain, Integer>();
        for (Integer i : fi) {
        	this.fixedIndices.add(i);
        	FieldDomain fd = stateSpace.getFieldDomain(i);
        	if (!fd.isPrimitiveType()) {
	        	Integer maxInstance = maxFixedInstances.get(fd);
	        	if (maxInstance == null) {
	        		if (fd.getClassOfField() == stateSpace.getRootObject().getClass())
	        			maxInstance = 1;
	        		else
	        			maxInstance = 0;
	        	}
		    	int value = candidateVector[i];
		        if (maxInstance < value)
		        	maxInstance = value;
		        maxFixedInstances.put(fd, maxInstance);
        	}
    	}
    }
    
    
    protected boolean firstTestCase = true;

    protected Object nextTestCase() {
        if (firstTestCase) {
            firstTestCase = false;
        } else {
            boolean hasNext = getNextCandidateReverseOrder();
            if (!hasNext)
                return null;
        }
        return candidateBuilder.buildCandidate(candidateVector);
    }

    private boolean getNextCandidateReverseOrder() {
        changedFields.clear();

        while (!accessedFields.isEmpty()) {
            int lastAccessedFieldIndex = accessedFields.removeLast();
            CVElem lastAccessedField = stateSpace.getCVElem(lastAccessedFieldIndex);

            if (fixedIndices.contains(lastAccessedFieldIndex) || lastAccessedField.isExcludedFromSearch())
                continue;

            changedFields.add(lastAccessedFieldIndex);

            FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
            int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
            int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

            if (lastAccessedFD.isPrimitiveType()) {
            	if (currentInstanceIndex >= maxInstanceIndexForFieldDomain) {
                    candidateVector[lastAccessedFieldIndex] = 0;
                    continue;
                }
                candidateVector[lastAccessedFieldIndex]++;
                return true;
            }
            // Is a reference field
            
            if (!isInitialized[lastAccessedFieldIndex]) {
            	isInitialized[lastAccessedFieldIndex] = true;
                int maxInstanceIndexInVector = getMaxInstanceInVector(lastAccessedFD, currentInstanceIndex);
                if (maxInstanceIndexInVector >= maxInstanceIndexForFieldDomain) {
                	candidateVector[lastAccessedFieldIndex] = maxInstanceIndexInVector;
                }
                else {
                	candidateVector[lastAccessedFieldIndex] = maxInstanceIndexInVector +  1;
                }
                return true;
            }

            if (currentInstanceIndex > 1) {
                candidateVector[lastAccessedFieldIndex]--;
                return true;
            }

            isInitialized[lastAccessedFieldIndex] = false;
            candidateVector[lastAccessedFieldIndex] = 0;
        }

        return false;
    }
    
    private boolean getNextCandidateInOrder() {
        changedFields.clear();

        while (!accessedFields.isEmpty()) {
            int lastAccessedFieldIndex = accessedFields.removeLast();
            CVElem lastAccessedField = stateSpace.getCVElem(lastAccessedFieldIndex);

            if (fixedIndices.contains(lastAccessedFieldIndex) || lastAccessedField.isExcludedFromSearch())
                continue;

            changedFields.add(lastAccessedFieldIndex);

            FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
            int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
            int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

            if (currentInstanceIndex >= maxInstanceIndexForFieldDomain) {
                candidateVector[lastAccessedFieldIndex] = 0;
                maxInstances[lastAccessedFieldIndex] = -1;
                continue;
            }

            if (lastAccessedFD.isPrimitiveType()) {
                candidateVector[lastAccessedFieldIndex]++;
                return true;
            }

            // Is a reference field
            if (maxInstances[lastAccessedFieldIndex] == -1) {
                maxInstances[lastAccessedFieldIndex] = getMaxInstanceInVector(lastAccessedFD, currentInstanceIndex);
            }

            if (currentInstanceIndex <= maxInstances[lastAccessedFieldIndex]) {
                candidateVector[lastAccessedFieldIndex]++;
                return true;
            }

            maxInstances[lastAccessedFieldIndex] = -1;
            candidateVector[lastAccessedFieldIndex] = 0;
        }

        return false;
    }
    
    
    private int getMaxInstanceInVector(FieldDomain fieldDomain, int currentInstanceIndex) {
    	Integer maxInstance = maxFixedInstances.get(fieldDomain);
    	if (maxInstance == null)
    		maxInstance = 0;
    	maxInstance = currentInstanceIndex > maxInstance ? currentInstanceIndex : maxInstance;
    	for (int i = 0; i < accessedFields.numberOfElements(); i++) {
    		int index = accessedFields.get(i);
    		if (!fixedIndices.contains(index) && stateSpace.getFieldDomain(index) == fieldDomain) {
	    		int value = candidateVector[index];
	            if (maxInstance < value)
	            	maxInstance = value;
    		}
        }
         return maxInstance;
    }

    
    protected Object nextTestCaseNoIsmBreak() {
        if (firstTestCase) {
            firstTestCase = false;
        } else {
            boolean hasNext = getNextCandidateNoIsmBreak();
            if (!hasNext)
                return null;
        }
        return candidateBuilder.buildCandidate(candidateVector);
    }

    private boolean getNextCandidateNoIsmBreak() {
        changedFields.clear();

        while (!accessedFields.isEmpty()) {
            int lastAccessedFieldIndex = accessedFields.removeLast();
            CVElem lastAccessedField = stateSpace.getCVElem(lastAccessedFieldIndex);
            FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
            int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

            if (lastAccessedField.isExcludedFromSearch() || fixedIndices.contains(lastAccessedFieldIndex))
                continue;

            changedFields.add(lastAccessedFieldIndex);

            int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
            if (currentInstanceIndex >= maxInstanceIndexForFieldDomain) {
                candidateVector[lastAccessedFieldIndex] = 0;
                continue;
            }

            candidateVector[lastAccessedFieldIndex]++;
            return true;
        }

        return false;
    }

}
