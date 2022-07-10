package symsolve.explorers.impl;

import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;

public class NoSymmetryBreakingExplorer extends SymmetryBreakingExplorer {

    public NoSymmetryBreakingExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        super(stateSpace, accessedIndices, changedFields);
    }

    @Override
    protected boolean setNextValue(int lastAccessedFieldIndex) {
        FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
        int currentInstanceIndex = candidateVector[lastAccessedFieldIndex];

        changedFields.add(lastAccessedFieldIndex);

        int maxInstanceIndexForFieldDomain = lastAccessedFD.getNumberOfElements() - 1;
        if (currentInstanceIndex >= maxInstanceIndexForFieldDomain)
            return false;

        candidateVector[lastAccessedFieldIndex]++;
        return true;
    }

    @Override
    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
    }

}
