package symsolve.explorers.impl;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import korat.utils.IntListAI;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.vector.SymSolveVector;

import java.util.Set;

public abstract class AbstractVectorStateSpaceExplorer implements VectorStateSpaceExplorer {

    protected StateSpace stateSpace;

    protected int[] candidateVector;
    protected int vectorSize;

    protected IIntList accessedIndices;
    protected IIntList changedFields;
    protected IIntList fixedIndices;

    protected int currentIndex;
    protected int currentValue;

    protected FieldDomain currentFieldDomain;
    protected int maxFieldDomainValue;

    protected Object currentFieldOwner;
    protected String currentFieldName;
    protected boolean isCurrentFieldPrimitive;


    public AbstractVectorStateSpaceExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        this.stateSpace = stateSpace;
        this.accessedIndices = accessedIndices;
        this.changedFields = changedFields;
        vectorSize = accessedIndices.getLength();
        fixedIndices = new IntListAI(vectorSize);
    }


    public void initialize(SymSolveVector vector) {
        setCandidateVector(vector);
        setFixedIndices(vector.getFixedIndices());
        setUpExplorerState();
    }

    private void setCandidateVector(SymSolveVector vector) {
        this.candidateVector = vector.getConcreteVector();
        if (vectorSize != this.candidateVector.length)
            throw new IllegalArgumentException(String.format("Wrong vector size! Expected: %d, but got: %d", vectorSize, this.candidateVector.length));
    }

    private void setFixedIndices(Set<Integer> fixedIndices) {
        this.fixedIndices.clear();
        for (Integer index : fixedIndices) {
            this.fixedIndices.add(index);
        }
    }

    void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++)
            changedFields.add(i);
    }

    public int[] getNextCandidate() {
        resetChangedFields();
        while (!accessedIndices.isEmpty()) {
            int lastAccessedIndex = accessedIndices.removeLast();
            if (isIndexFixed(lastAccessedIndex)) {
                setCurrentField(lastAccessedIndex);
                setIndexAsChanged(lastAccessedIndex);
                if (setNextValue())
                    return candidateVector;
                backtrack();
            }
        }
        return null;
    }

    abstract boolean setNextValue();

    abstract void backtrack();

    private void setCurrentField(int lastAccessedIndex) {
        currentIndex = lastAccessedIndex;
        currentValue = candidateVector[lastAccessedIndex];
        currentFieldDomain = stateSpace.getFieldDomain(lastAccessedIndex);
        maxFieldDomainValue = currentFieldDomain.getNumberOfElements() - 1;
        CVElem cvElem = stateSpace.getCVElem(currentIndex);
        currentFieldOwner = cvElem.getObj();
        currentFieldName = cvElem.getFieldName();
        isCurrentFieldPrimitive = currentFieldDomain.isPrimitiveType();
    }

    boolean isIndexFixed(int index) {
        return !fixedIndices.contains(index);
    }

    void setIndexAsChanged(int index) {
        changedFields.add(index);
    }

    void resetChangedFields() {
        changedFields.clear();
    }

    int getMaxInstanceInVector(FieldDomain fieldDomain) {
        int maxInstance = 0;
        for (Integer index : stateSpace.getIndicesOfFieldDomain(fieldDomain)) {
            int value = candidateVector[index];
            if (value > maxInstance)
                maxInstance = value;
        }
        return maxInstance;
    }

    public int[] getCandidateVector() {
        return candidateVector;
    }


    void setCurrentFieldValue(int newValue) {
        candidateVector[currentIndex] = newValue;
    }

    void resetCurrentFieldValue() {
        candidateVector[currentIndex] = 0;
    }

    void increaseCurrentFieldValue() {
        candidateVector[currentIndex]++;
    }

    void decreaseCurrentFieldValue() {
        candidateVector[currentIndex]--;
    }

}
