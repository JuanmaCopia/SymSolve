package symsolve.explorers.impl;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;

public class SymmetryBreakingExplorer extends SymbolicVectorExplorer {

    public SymmetryBreakingExplorer(StateSpace stateSpace) {
        super(stateSpace);
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

    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        maxInstances[lastAccessedFieldIndex] = -1;
    }

}
