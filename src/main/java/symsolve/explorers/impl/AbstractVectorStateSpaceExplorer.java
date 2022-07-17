package symsolve.explorers.impl;

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


    public AbstractVectorStateSpaceExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        this.stateSpace = stateSpace;
        this.accessedIndices = accessedIndices;
        this.changedFields = changedFields;
        vectorSize = accessedIndices.getLength();
        fixedIndices = new IntListAI(vectorSize);
    }

    public int[] getCandidateVector() {
        return candidateVector;
    }

    public void initialize(SymSolveVector vector) {
        setCandidateVector(vector);
        setFixedIndices(vector.getFixedIndices());
        setUpExplorerState();
    }

    public int[] getNextCandidate() {
        changedFields.clear();
        while (!accessedIndices.isEmpty()) {
            int lastAccessedFieldIndex = accessedIndices.removeLast();
            if (!fixedIndices.contains(lastAccessedFieldIndex)) {
                changedFields.add(lastAccessedFieldIndex);
                if (setNextValue(lastAccessedFieldIndex))
                    return candidateVector;
                backtrack(lastAccessedFieldIndex);
            }
        }
        return null;
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

    int getMaxInstanceInVector(FieldDomain fieldDomain) {
        int maxInstance = 0;
        for (Integer index : stateSpace.getIndicesOfFieldDomain(fieldDomain)) {
            int value = candidateVector[index];
            if (value > maxInstance)
                maxInstance = value;
        }
        return maxInstance;
    }

    abstract boolean setNextValue(int lastAccessedFieldIndex);

    abstract void backtrack(int lastAccessedFieldIndex);

    abstract void setUpExplorerState();
    
}
