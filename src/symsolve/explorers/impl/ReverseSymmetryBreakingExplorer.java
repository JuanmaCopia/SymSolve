package symsolve.explorers.impl;

import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;

public class ReverseSymmetryBreakingExplorer extends SymmetryBreakingExplorer {

    public ReverseSymmetryBreakingExplorer(StateSpace stateSpace) {
        super(stateSpace);
    }
    
    @Override
    protected boolean setNextValue(int lastAccessedFieldIndex) {
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
    
    @Override
    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        isInitialized[lastAccessedFieldIndex] = false;
    }

}
