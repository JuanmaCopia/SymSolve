package symsolve.explorers.impl;

import java.util.HashMap;
import java.util.Set;

import korat.finitization.impl.CandidateBuilder;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import korat.utils.IntListAI;
import symsolve.SymbolicVector;

public abstract class SymbolicVectorExplorer {

    protected StateSpace stateSpace;

    protected CandidateBuilder candidateBuilder;

    protected int[] candidateVector;

    protected int vectorSize;

    protected int[] maxInstances;

    protected boolean[] isInitialized;

    protected IIntList accessedFields;

    protected IIntList changedFields;

    protected IIntList fixedIndices;

    protected HashMap<FieldDomain, Integer> maxFixedInstances;

    public SymbolicVectorExplorer(StateSpace stateSpace) {
        this.stateSpace = stateSpace;
        vectorSize = stateSpace.getTotalNumberOfFields();
        this.isInitialized = new boolean[vectorSize];
        this.maxInstances = new int[vectorSize];
        accessedFields = new IntListAI(vectorSize);
        changedFields = new IntListAI(vectorSize);
        fixedIndices = new IntListAI(vectorSize);
        candidateBuilder = new CandidateBuilder(stateSpace, changedFields);
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

    public void initialize(SymbolicVector vector) {
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

    public Object getNextCandidate() {
        changedFields.clear();
        while (!accessedFields.isEmpty()) {
            int lastAccessedFieldIndex = accessedFields.removeLast();
            if (setNextValue(lastAccessedFieldIndex))
                return candidateBuilder.buildCandidate(candidateVector);
            backtrack(lastAccessedFieldIndex);
        }
        return null;
    }

    protected abstract void backtrack(int lastAccessedFieldIndex);

    protected abstract boolean setNextValue(int lastAccessedFieldIndex);

}
