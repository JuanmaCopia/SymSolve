package symsolve.explorers.impl;

import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;

public class ReverseSymmetryBreakingExplorer extends AbstractVectorStateSpaceExplorer {

    private final boolean[] initializedFields;

    
    public ReverseSymmetryBreakingExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        super(stateSpace, accessedIndices, changedFields);
        initializedFields = new boolean[vectorSize];
    }

    @Override
    boolean setNextValue(int lastAccessedFieldIndex) {
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

        if (!initializedFields[lastAccessedFieldIndex]) {
            initializedFields[lastAccessedFieldIndex] = true;
            int maxInstanceIndexInVector = getMaxInstanceInVector(lastAccessedFD);
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

    @Override
    void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        initializedFields[lastAccessedFieldIndex] = false;
    }

    @Override
    public void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++) {
            changedFields.add(i);
            initializedFields[i] = !fixedIndices.contains(i) && candidateVector[i] > 0;
        }
    }

}
