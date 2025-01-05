package eval.explorers;

import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import korat.utils.IntListAI;

import java.util.IdentityHashMap;
import java.util.Map;

public class BoundedExhaustiveExplorer {


    protected StateSpace stateSpace;

    protected int[] candidateVector;
    protected int vectorSize;

    protected IntListAI accessedIndices;
    protected IntListAI changedFields;

    protected int currentIndex;
    protected int currentValue;

    protected FieldDomain currentFieldDomain;
    protected int maxFieldDomainValue;

    // protected Object currentFieldOwner;
    // protected String currentFieldName;
    protected boolean isCurrentFieldPrimitive;

    protected Map<FieldDomain, Integer> maxFixedInstancePerReferenceFieldDomain = new IdentityHashMap<>();


    protected int[] maxInstances;

    public BoundedExhaustiveExplorer(StateSpace stateSpace) {
        this.stateSpace = stateSpace;
        vectorSize = stateSpace.getTotalNumberOfFields();
        accessedIndices = new IntListAI(vectorSize);
        changedFields = new IntListAI(vectorSize);
        maxInstances = new int[vectorSize];
        candidateVector = new int[vectorSize];
        for (int i = 0; i < vectorSize; i++) {
            changedFields.add(i);
            maxInstances[i] = -1;
        }
    }

    public void backtrack() {
        candidateVector[currentIndex] = 0;
        maxInstances[currentIndex] = -1;
    }

    public int[] getCandidateVector() {
        return candidateVector;
    }

    public int[] getNextCandidate() {
        changedFields.clear();
        while (!accessedIndices.isEmpty()) {
            int lastAccessedIndex = accessedIndices.removeLast();
            setCurrentField(lastAccessedIndex);
            changedFields.add(lastAccessedIndex);
            if (setNextValue())
                return candidateVector;
            backtrack();
        }
        return null;
    }

    private void setCurrentField(int lastAccessedIndex) {
        currentIndex = lastAccessedIndex;
        currentValue = candidateVector[lastAccessedIndex];
        currentFieldDomain = stateSpace.getFieldDomain(lastAccessedIndex);
        maxFieldDomainValue = currentFieldDomain.getNumberOfElements() - 1;
        // CVElem cvElem = stateSpace.getCVElem(currentIndex);
        // currentFieldOwner = cvElem.getObj();
        // currentFieldName = cvElem.getFieldName();
        isCurrentFieldPrimitive = currentFieldDomain.isPrimitiveType();
    }

    private boolean setNextValue() {
        if (currentValue >= maxFieldDomainValue)
            return false;

        if (isCurrentFieldPrimitive) {
            candidateVector[currentIndex]++;
            return true;
        }
        return setNextReferenceTypeValue();
    }

    protected boolean setNextReferenceTypeValue() {
        if (maxInstances[currentIndex] == -1)
            maxInstances[currentIndex] = getMaxInstanceInVector();

        if (currentValue <= maxInstances[currentIndex]) {
            candidateVector[currentIndex]++;
            return true;
        }
        return false;
    }

    protected int getMaxInstanceInVector() {
        Integer maxInstance = this.maxFixedInstancePerReferenceFieldDomain.get(currentFieldDomain);
        if (maxInstance == null)
            maxInstance = 0;
        for (Integer index : accessedIndices.toArray()) {
            if (stateSpace.getFieldDomain(index) == currentFieldDomain) {
                int value = candidateVector[index];
                if (value > maxInstance)
                    maxInstance = value;
            }
        }
        return maxInstance;
    }

    public IIntList getAccessedIndices() {
        return accessedIndices;
    }

    public IIntList getChangedFields() {
        return changedFields;
    }
}
