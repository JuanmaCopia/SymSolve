package symkorat;

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

    protected IIntList accessedFields;

    protected IIntList changedFields;

    protected Set<Integer> fixedIndices;

    protected Class<?> rootClass;

    public SolverStateSpaceExplorer(IFinitization ifin, SymKoratVector vector) {
    	Finitization fin = (Finitization)ifin;
    	stateSpace = fin.getStateSpace();

    	this.candidateVector = vector.getVector();
        this.fixedIndices = vector.getFixedIndices();

    	int totalNumberOfFields = stateSpace.getTotalNumberOfFields();
    	if (totalNumberOfFields != this.candidateVector.length)
    		throw new IllegalArgumentException();

        accessedFields = new IntListAI(totalNumberOfFields);
        changedFields = new IntListAI(totalNumberOfFields);
        for (int i = 0; i < totalNumberOfFields; i++)
            changedFields.add(i);

        candidateBuilder = new CandidateBuilder(stateSpace, changedFields);
        rootClass = stateSpace.getRootObject().getClass();

        resetMaxInstancesInVector();
    }

    public IIntList getAccessedFields() {
        return accessedFields;
    }

    public int[] getCandidateVector() {
        return candidateVector;
    }

    public Object buildCandidate() {
        return candidateBuilder.buildCandidate(candidateVector);
    }

    protected boolean firstTestCase = true;

    public Object nextTestCase() {
        if (firstTestCase) {
            firstTestCase = false;
        } else {
            // find next candidate vector
            boolean hasNext = getNextCandidate();
            if (!hasNext)
                // if vector is invalid, return null
                return null;
        }
        return candidateBuilder.buildCandidate(candidateVector);
    }

    protected boolean getNextCandidate() {
        changedFields.clear();

        while (!accessedFields.isEmpty()) {
            int lastAccessedFieldIndex = accessedFields.removeLast();
            CVElem lastAccessedField = stateSpace.getCVElem(lastAccessedFieldIndex);

            if (lastAccessedField.isExcludedFromSearch() || fixedIndices.contains(lastAccessedFieldIndex))
            	continue;

            changedFields.add(lastAccessedFieldIndex);

            FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
            int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
            int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

            if (currentInstanceIndex >= maxInstanceIndexForFieldDomain) {
                candidateVector[lastAccessedFieldIndex] = 0;
                lastAccessedField.maxInstanceInVector = -1;
                continue;
            }

            if (lastAccessedFD.isPrimitiveType()) {
        		candidateVector[lastAccessedFieldIndex]++;
                return true;
            }

            // Is a reference field
            if (lastAccessedField.maxInstanceInVector == -1) {

            	int maxInstanceIndexInVector = 0;
    			if (lastAccessedFD.getClassOfField() == rootClass)
    				maxInstanceIndexInVector = 1;

            	// Add previously visited instances to alternatives
            	for (int i = 0; i < candidateVector.length; i++) {
            		if (stateSpace.getFieldDomain(i) == lastAccessedFD) {
            			int value = candidateVector[i];
        				if (maxInstanceIndexInVector < value)
        					maxInstanceIndexInVector = value;
            		}
            	}
            	lastAccessedField.maxInstanceInVector = maxInstanceIndexInVector;
            }

    		if (currentInstanceIndex <= lastAccessedField.maxInstanceInVector) {
    			candidateVector[lastAccessedFieldIndex]++;
    			return true;
    		}

    		lastAccessedField.maxInstanceInVector = -1;
			candidateVector[lastAccessedFieldIndex] = 0;
        }

        return false;
    }

    public Object nextTestCaseNoIsmBreak() {
        if (firstTestCase) {
            firstTestCase = false;
        } else {
            // find next candidate vector
            boolean hasNext = getNextCandidateNoIsmBreak();
            if (!hasNext)
                // if vector is invalid, return null
                return null;
        }
        return candidateBuilder.buildCandidate(candidateVector);
    }

    protected boolean getNextCandidateNoIsmBreak() {
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


    public void resetMaxInstancesInVector() {
    	CVElem[] structureList = stateSpace.getStructureList();
    	for (int i = 0; i < structureList.length; i++)
    		structureList[i].maxInstanceInVector = -1;
    }

}
