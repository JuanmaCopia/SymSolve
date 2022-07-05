package symsolve.explorers.impl;

import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;

public class ReverseSymmetryBreakingExplorer extends SymmetryBreakingExplorer {

    public ReverseSymmetryBreakingExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        super(stateSpace, accessedIndices, changedFields);
    }

    @Override
    protected boolean setNextValue(int lastAccessedFieldIndex) {
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

    @Override
    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        initializedFields[lastAccessedFieldIndex] = false;
    }

}