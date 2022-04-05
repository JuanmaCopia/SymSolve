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

    private StateSpace stateSpace;

    private CandidateBuilder candidateBuilder;

    private int[] candidateVector;

    private int vectorSize;

    private int[] maxInstances;

    private boolean[] isInitialized;

    protected IIntList accessedFields;

    protected IIntList changedFields;

    private IIntList fixedIndices;

    private HashMap<FieldDomain, Integer> maxFixedInstances;

    private Finitization fin;

    public SolverStateSpaceExplorer(IFinitization ifin) {
        fin = (Finitization) ifin;
        stateSpace = fin.getStateSpace();
        vectorSize = stateSpace.getTotalNumberOfFields();
        this.isInitialized = new boolean[vectorSize];
        this.maxInstances = new int[vectorSize];
        accessedFields = new IntListAI(vectorSize);
        changedFields = new IntListAI(vectorSize);
        fixedIndices = new IntListAI(vectorSize);
        candidateBuilder = new CandidateBuilder(stateSpace, changedFields);
    }

    public void initialize(SymKoratVector vector) {
        this.candidateVector = vector.getConcreteVector();
        if (vectorSize != this.candidateVector.length)
            throw new IllegalArgumentException("The input vector does not match the finitization!");

        accessedFields.clear();
        changedFields.clear();
        fixedIndices.clear();
        for (int i = 0; i < vectorSize; i++) {
            maxInstances[i] = -1;
            isInitialized[i] = false;
            changedFields.add(i);
        }
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

    protected Object getNextCandidate() {
        changedFields.clear();
        while (!accessedFields.isEmpty()) {
            int lastAccessedFieldIndex = accessedFields.removeLast();
            if (setNextValueReverseOrder(lastAccessedFieldIndex))
                return candidateBuilder.buildCandidate(candidateVector);
            backtrack(lastAccessedFieldIndex);
        }
        return null;
    }

    private void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        isInitialized[lastAccessedFieldIndex] = false;
        maxInstances[lastAccessedFieldIndex] = -1;
    }

    private boolean setNextValueReverseOrder(int lastAccessedFieldIndex) {
        CVElem lastAccessedField = stateSpace.getCVElem(lastAccessedFieldIndex);
        if (fixedIndices.contains(lastAccessedFieldIndex) || lastAccessedField.isExcludedFromSearch())
            return false;

        changedFields.add(lastAccessedFieldIndex);
        FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
        int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
        int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

        if (lastAccessedFD.isPrimitiveType()) {
            if (currentInstanceIndex >= maxInstanceIndexForFieldDomain) {
                return false;
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
            } else {
                candidateVector[lastAccessedFieldIndex] = maxInstanceIndexInVector + 1;
            }
            return true;
        }

        if (currentInstanceIndex > 1) {
            candidateVector[lastAccessedFieldIndex]--;
            return true;
        }
        return false;
    }

    private boolean setNextValueInOrder(int lastAccessedFieldIndex) {
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

    protected Object getNextCandidateNoSymmetryBreak() {
        changedFields.clear();
        while (!accessedFields.isEmpty()) {
            int lastAccessedFieldIndex = accessedFields.removeLast();
            if (setNextValueNoSymmetryBreak(lastAccessedFieldIndex))
                return candidateBuilder.buildCandidate(candidateVector);
            backtrack(lastAccessedFieldIndex);
        }
        return null;
    }

    private boolean setNextValueNoSymmetryBreak(int lastAccessedFieldIndex) {
        CVElem lastAccessedField = stateSpace.getCVElem(lastAccessedFieldIndex);
        FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
        int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

        if (lastAccessedField.isExcludedFromSearch() || fixedIndices.contains(lastAccessedFieldIndex))
            return false;

        changedFields.add(lastAccessedFieldIndex);

        int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
        if (currentInstanceIndex >= maxInstanceIndexForFieldDomain)
            return false;

        candidateVector[lastAccessedFieldIndex]++;
        return true;
    }

}
