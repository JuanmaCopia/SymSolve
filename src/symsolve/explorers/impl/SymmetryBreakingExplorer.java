package symsolve.explorers.impl;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import korat.utils.IntListAI;

import symsolve.SymSolveVector;
import symsolve.explorers.VectorStateSpaceExplorer;

public class SymmetryBreakingExplorer implements VectorStateSpaceExplorer {

    protected StateSpace stateSpace;

    protected int[] candidateVector;

    protected int vectorSize;

    protected int[] maxInstances;

    protected boolean[] isInitialized;

    protected IIntList accessedFields;

    protected IIntList changedFields;

    protected IIntList fixedIndices;

    protected Map<FieldDomain, Integer> maxFixedInstancePerReferenceFieldDomain = new IdentityHashMap<FieldDomain, Integer>();

    public SymmetryBreakingExplorer(StateSpace stateSpace) {
        this.stateSpace = stateSpace;
        vectorSize = stateSpace.getTotalNumberOfFields();
        this.isInitialized = new boolean[vectorSize];
        this.maxInstances = new int[vectorSize];
        accessedFields = new IntListAI(vectorSize);
        changedFields = new IntListAI(vectorSize);
        fixedIndices = new IntListAI(vectorSize);
    }

    public int[] getNextCandidate() {
        changedFields.clear();
        while (!accessedFields.isEmpty()) {
            int lastAccessedFieldIndex = accessedFields.removeLast();
            if (!fixedIndices.contains(lastAccessedFieldIndex)) {
                changedFields.add(lastAccessedFieldIndex);
                if (setNextValue(lastAccessedFieldIndex))
                    return candidateVector;
                backtrack(lastAccessedFieldIndex);
            }
        }
        return null;
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

    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        maxInstances[lastAccessedFieldIndex] = -1;
    }

    protected int getMaxInstanceInVector(FieldDomain fieldDomain, int currentInstanceIndex) {
        Integer maxInstance = this.maxFixedInstancePerReferenceFieldDomain.get(fieldDomain);
        if (maxInstance == null)
            maxInstance = 0;
        if (currentInstanceIndex > maxInstance)
            maxInstance = currentInstanceIndex;
        for (int i = 0; i < accessedFields.numberOfElements(); i++) {
            int index = accessedFields.get(i);
            if (!this.fixedIndices.contains(index) && stateSpace.getFieldDomain(index) == fieldDomain) {
                int value = candidateVector[index];
                if (value > maxInstance)
                    maxInstance = value;
            }
        }
        return maxInstance;
    }

    public void initialize(SymSolveVector vector) {
        resetExplorerState();
        setCandidateVector(vector.getConcreteVector());
        calculateMaxFixedInstancePerReferenceFieldDomain(vector.getFixedIndices());
    }

    private void setCandidateVector(int[] vector) {
        this.candidateVector = vector;
        if (vectorSize != this.candidateVector.length)
            throw new IllegalArgumentException("The input vector does not match the finitization!");
    }

    private void resetExplorerState() {
        this.accessedFields.clear();
        for (int i = 0; i < this.vectorSize; i++) {
            this.maxInstances[i] = -1;
            this.isInitialized[i] = false;
            this.changedFields.add(i);
        }
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

    public void resetChangedFields() {
        for (int i = 0; i < this.vectorSize; i++)
            this.changedFields.add(i);
    }

    public IIntList getAccessedFields() {
        return accessedFields;
    }

    public IIntList getChangedFields() {
        return changedFields;
    }

    public int[] getCandidateVector() {
        return candidateVector;
    }

}
