package symsolve.explorers.impl;

import korat.finitization.IFieldDomain;
import korat.finitization.IObjSet;
import korat.finitization.impl.CVElem;
import korat.finitization.impl.ObjSet;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import symsolve.bounds.Bounds;
import symsolve.candidates.traversals.visitors.CalculateNodesLabelSetVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SymmetryBreakingExplorerBounded extends SymmetryBreakingExplorer {

    Bounds bounds;
    List<Integer>[] optionsList;

    public SymmetryBreakingExplorerBounded(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields, Bounds bounds) {
        super(stateSpace, accessedIndices, changedFields);
        this.bounds = bounds;
        optionsList = new ArrayList[vectorSize];
    }

    @Override
    public void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++) {
            changedFields.add(i);
            if (!fixedIndices.contains(i) && candidateVector[i] > 0) {
                List<Integer> possibleValues = getPossibleValuesForCurrentField(i);
                removeAlreadyExploredValues(possibleValues, candidateVector[i]);
                optionsList[i] = possibleValues;
            } else {
                optionsList[i] = null;
            }
        }
    }

    @Override
    protected boolean setNextValue(int lastAccessedFieldIndex) {
        List<Integer> possibleValues = optionsList[lastAccessedFieldIndex];
        if (possibleValues == null) {
            possibleValues = getPossibleValuesForCurrentField(lastAccessedFieldIndex);
            optionsList[lastAccessedFieldIndex] = possibleValues;
        }

        if (!possibleValues.isEmpty()) {
            candidateVector[lastAccessedFieldIndex] = possibleValues.remove(0);
            return true;
        }
        return false;
    }

    @Override
    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        optionsList[lastAccessedFieldIndex] = null;
    }

    private List<Integer> getPossibleValuesForCurrentField(int fieldIndex) {
        CVElem cvElem = stateSpace.getCVElem(fieldIndex);
        Object ownerObject = cvElem.getObj();
        Class<?> ownerClass = ownerObject.getClass();
        String fieldName = cvElem.getFieldName();

        CalculateNodesLabelSetVisitor visitor = new CalculateNodesLabelSetVisitor(stateSpace, bounds);
        HashMap<Object, Set<Integer>> labelSets = visitor.calculateLabelSets(candidateVector);

        Set<Integer> ownerLabelSet = labelSets.get(ownerObject);
        Set<Integer> boundValues = bounds.getTargets(ownerClass, fieldName, ownerLabelSet);

        IFieldDomain fieldDomain = cvElem.getFieldDomain();
        if (!fieldDomain.isPrimitiveType()) {
            IObjSet objSet = (ObjSet) fieldDomain;
            if (objSet.isNullAllowed())
                boundValues.remove(0);
        }
        return new ArrayList<>(boundValues);
    }


    private void removeAlreadyExploredValues(List<Integer> possibleValues, int currentValue) {
        int numOfRemovals = 1;
        for (Integer value : possibleValues) {
            if (value != currentValue)
                numOfRemovals++;
        }
        for (int i = 0; i < numOfRemovals; i++)
            possibleValues.remove(0);
    }

}
