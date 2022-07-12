package symsolve.explorers.impl;

import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import korat.utils.IntListAI;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.vector.SymSolveVector;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

public class SymmetryBreakingExplorer implements VectorStateSpaceExplorer {

    private final int[] maxInstances;
    protected StateSpace stateSpace;
    protected int[] candidateVector;
    protected int vectorSize;
    protected IIntList accessedIndices;
    protected IIntList changedFields;
    protected IIntList fixedIndices;

    protected Map<FieldDomain, Integer> maxFixedInstancePerReferenceFieldDomain = new IdentityHashMap<>();

    public SymmetryBreakingExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        this.stateSpace = stateSpace;
        this.accessedIndices = accessedIndices;
        this.changedFields = changedFields;
        vectorSize = accessedIndices.getLength();
        fixedIndices = new IntListAI(vectorSize);
        maxInstances = new int[vectorSize];
    }

    public int[] getCandidateVector() {
        return candidateVector;
    }

    public void initialize(SymSolveVector vector) {
        setCandidateVector(vector);
        calculateMaxFixedInstancePerReferenceFieldDomain(vector.getFixedIndices());
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

    public void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++) {
            changedFields.add(i);
            if (!fixedIndices.contains(i) && candidateVector[i] > 0) {
                FieldDomain fieldDomain = stateSpace.getFieldDomain(i);
                maxInstances[i] = maxFixedInstancePerReferenceFieldDomain.get(fieldDomain);
            } else {
                maxInstances[i] = -1;
            }
        }
    }

    private void setCandidateVector(SymSolveVector vector) {
        this.candidateVector = vector.getConcreteVector();
        if (vectorSize != this.candidateVector.length)
            throw new IllegalArgumentException(String.format("Wrong vector size! Expected: %d, but got: %d", vectorSize, this.candidateVector.length));
    }

    private void calculateMaxFixedInstancePerReferenceFieldDomain(Set<Integer> fixedIndices) {
        this.maxFixedInstancePerReferenceFieldDomain.clear();
        this.fixedIndices.clear();
        for (Integer index : fixedIndices) {
            this.fixedIndices.add(index);
            FieldDomain fieldDomain = stateSpace.getFieldDomain(index);
            if (!fieldDomain.isPrimitiveType()) {
                int value = candidateVector[index];
                Integer currentMaxFDInstance = this.maxFixedInstancePerReferenceFieldDomain.get(fieldDomain);
                if (currentMaxFDInstance == null || value > currentMaxFDInstance)
                    this.maxFixedInstancePerReferenceFieldDomain.put(fieldDomain, value);
            }
        }

    }

    protected boolean setNextValue(int lastAccessedFieldIndex) {
        FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
        int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
        int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

        if (currentInstanceIndex >= maxInstanceIndexForFieldDomain)
            return false;

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
        return false;
    }

    protected int getMaxInstanceInVector(FieldDomain fieldDomain, int currentInstanceIndex) {
        Integer maxInstance = this.maxFixedInstancePerReferenceFieldDomain.get(fieldDomain);
        if (maxInstance == null)
            maxInstance = 0;
        if (currentInstanceIndex > maxInstance)
            maxInstance = currentInstanceIndex;
        for (int i = 0; i < accessedIndices.numberOfElements(); i++) {
            int index = accessedIndices.get(i);
            if (!this.fixedIndices.contains(index) && stateSpace.getFieldDomain(index) == fieldDomain) {
                int value = candidateVector[index];
                if (value > maxInstance)
                    maxInstance = value;
            }
        }
        return maxInstance;
    }

    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        maxInstances[lastAccessedFieldIndex] = -1;
    }

}
