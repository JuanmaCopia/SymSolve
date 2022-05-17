package symsolve.explorers.impl;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;

public class NoSymmetryBreakingExplorer extends SymmetryBreakingExplorer {

    public NoSymmetryBreakingExplorer(StateSpace stateSpace) {
        super(stateSpace);
    }

    @Override
    protected boolean setNextValue(int lastAccessedFieldIndex) {
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

    @Override
    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
    }

}
