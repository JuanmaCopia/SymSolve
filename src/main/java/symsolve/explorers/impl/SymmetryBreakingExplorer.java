package symsolve.explorers.impl;

import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;

public class SymmetryBreakingExplorer extends AbstractVectorStateSpaceExplorer {

    private final int[] maxInstances;


    public SymmetryBreakingExplorer(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields) {
        super(stateSpace, accessedIndices, changedFields);
        maxInstances = new int[vectorSize];
    }

    @Override
    boolean setNextValue(int lastAccessedFieldIndex) {
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
            maxInstances[lastAccessedFieldIndex] = getMaxInstanceInVector(lastAccessedFD);
        }
        if (currentInstanceIndex <= maxInstances[lastAccessedFieldIndex]) {
            candidateVector[lastAccessedFieldIndex]++;
            return true;
        }
        return false;
    }

    @Override
    void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        maxInstances[lastAccessedFieldIndex] = -1;
    }

    @Override
    void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++) {
            changedFields.add(i);
            if (!fixedIndices.contains(i) && candidateVector[i] > 0) {
                FieldDomain fieldDomain = stateSpace.getFieldDomain(i);
                if (!fieldDomain.isPrimitiveType())
                    maxInstances[i] = getMaxInstanceInVector(fieldDomain);
            } else {
                maxInstances[i] = -1;
            }
        }
    }

}
