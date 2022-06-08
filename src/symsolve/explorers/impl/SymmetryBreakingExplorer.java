package symsolve.explorers.impl;

import java.util.HashMap;
import java.util.Set;

import korat.finitization.impl.CVElem;
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

    protected HashMap<FieldDomain, Integer> maxFixedInstances;

    public SymmetryBreakingExplorer(StateSpace stateSpace) {
        this.stateSpace = stateSpace;
        vectorSize = stateSpace.getTotalNumberOfFields();
        this.isInitialized = new boolean[vectorSize];
        this.maxInstances = new int[vectorSize];
        accessedFields = new IntListAI(vectorSize);
        changedFields = new IntListAI(vectorSize);
        fixedIndices = new IntListAI(vectorSize);
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

    public void initialize(SymSolveVector vector) {
        setCandidateVector(vector.getConcreteVector());
        resetExplorerState();
        initializeMaxFixedInstances(vector.getFixedIndices());
    }

    private void setCandidateVector(int[] vector) {
        this.candidateVector = vector;
        if (vectorSize != this.candidateVector.length)
            throw new IllegalArgumentException("The input vector does not match the finitization!");
    }

    private void resetExplorerState() {
        this.accessedFields.clear();
        this.fixedIndices.clear();
        for (int i = 0; i < this.vectorSize; i++) {
            this.maxInstances[i] = -1;
            this.isInitialized[i] = false;
            this.changedFields.add(i);
        }
    }
    
    public void resetChangedFields() {
        for (int i = 0; i < this.vectorSize; i++)
            this.changedFields.add(i);
    }

    private void initializeMaxFixedInstances(Set<Integer> fi) {
        maxFixedInstances = new HashMap<FieldDomain, Integer>();
        for (Integer i : fi) {
            this.fixedIndices.add(i);
            FieldDomain fd = stateSpace.getFieldDomain(i);
            if (!fd.isPrimitiveType()) {
                int maxFixedInstance = getMaxFixedInstanceForFieldDomain(fd, candidateVector[i]);
                maxFixedInstances.put(fd, maxFixedInstance);
            }
        }
    }

    private int getMaxFixedInstanceForFieldDomain(FieldDomain fieldDomain, int currentIndexValue) {
        Integer maxInstance = maxFixedInstances.get(fieldDomain);
        if (maxInstance == null) {
            if (fieldDomain.getClassOfField() == stateSpace.getRootObject().getClass())
                maxInstance = 1;
            else
                maxInstance = 0;
        }
        return Math.max(maxInstance, currentIndexValue);
    }

    public int[] getNextCandidate() {
        changedFields.clear();
        while (!accessedFields.isEmpty()) {
            int lastAccessedFieldIndex = accessedFields.removeLast();
            if (setNextValue(lastAccessedFieldIndex))
                return candidateVector;
            backtrack(lastAccessedFieldIndex);
        }
        return null;
    }

    protected boolean setNextValue(int lastAccessedFieldIndex) {
        CVElem lastAccessedField = stateSpace.getCVElem(lastAccessedFieldIndex);
        if (fixedIndices.contains(lastAccessedFieldIndex) || lastAccessedField.isExcludedFromSearch())
            return false;

        changedFields.add(lastAccessedFieldIndex);
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

    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        maxInstances[lastAccessedFieldIndex] = -1;
    }

}
