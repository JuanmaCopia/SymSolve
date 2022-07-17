package symsolve.explorers.impl;

import korat.finitization.IFieldDomain;
import korat.finitization.IObjSet;
import korat.finitization.impl.CVElem;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.ObjSet;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import symsolve.bounds.Bounds;
import symsolve.candidates.traversals.visitors.CalculateNodesLabelSetVisitor;

import java.util.*;

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
/*
        System.out.println("\n Last accessed index: " + lastAccessedFieldIndex);
        System.out.printf("Possible Values for field %s is: %s%n", stateSpace.getCVElem(lastAccessedFieldIndex).getFieldName(), possibleValues);*/

        if (!possibleValues.isEmpty()) {
            candidateVector[lastAccessedFieldIndex] = possibleValues.remove(0);
/*            Utils.printVectorFormat(candidateVector, stateSpace.getStructureList());
            System.out.println("result vector: " + Arrays.toString(candidateVector));*/
            return true;
        }
        return false;
    }

    @Override
    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        optionsList[lastAccessedFieldIndex] = null;
    }

    private List<Integer> getPossibleValuesForCurrentField(int lastAccessedFieldIndex) {
        HashMap<Object, Set<Integer>> objectsLabelSets = calculateObjectsLabelSets();

/*        for (Map.Entry<Object, Set<Integer>> e : objectsLabelSets.entrySet()) {
            System.out.println("\nObject of class: " + e.getKey().getClass().getSimpleName());
            System.out.println("\t\tLabels: " + e.getValue().toString());
        }
        System.out.println("\n");*/

        List<Integer> targetLabelSet = getTargetLabelSet(objectsLabelSets, lastAccessedFieldIndex);


        FieldDomain lastAccessedFD = stateSpace.getFieldDomain(lastAccessedFieldIndex);
        if (lastAccessedFD.isPrimitiveType())
            return targetLabelSet;

        ObjSet objSet = (ObjSet) lastAccessedFD;
        int maxInstanceIndexForFieldDomain = objSet.getNumberOfElements() - 1;

        Set<Integer> possibleValues = new HashSet<>();

        int startIndex = 0;
        if (objSet.isNullAllowed())
            startIndex = 1;

        boolean newInstanceAdded = false;
        for (int i = startIndex; i < maxInstanceIndexForFieldDomain; i++) {
            Object candObj = objSet.getObject(i);
            if (objectsLabelSets.containsKey(candObj)) {
                Set<Integer> objLabelSet = objectsLabelSets.get(candObj);

                Set<Integer> intersection = new HashSet<>(objLabelSet);
                intersection.retainAll(targetLabelSet);
                if (!intersection.isEmpty()) {
                    possibleValues.add(i);
                }
            } else if (!newInstanceAdded) {
                if (!targetLabelSet.isEmpty()) {
                    possibleValues.add(i);
                    newInstanceAdded = true;
                }
            }
        }

        return new ArrayList<Integer>(possibleValues);
    }

    private List<Integer> getTargetLabelSet(HashMap<Object, Set<Integer>> labelSets, int fieldIndex) {
        CVElem cvElem = stateSpace.getCVElem(fieldIndex);
        Object ownerObject = cvElem.getObj();
        Class<?> ownerClass = ownerObject.getClass();
        String fieldName = cvElem.getFieldName();

        Set<Integer> ownerLabelSet = labelSets.get(ownerObject);
        Set<Integer> boundValues = bounds.getTargets(ownerClass, fieldName, ownerLabelSet);

        IFieldDomain fieldDomain = cvElem.getFieldDomain();
        if (!fieldDomain.isPrimitiveType()) {
            IObjSet objSet = (ObjSet) fieldDomain;
            if (objSet.isNullAllowed())
                boundValues.remove(0);
        }

        /*        System.out.println(String.format("target label set for field %s is: %s", fieldName, boundValues));*/
        return new ArrayList<>(boundValues);
    }

    private HashMap<Object, Set<Integer>> calculateObjectsLabelSets() {
        CalculateNodesLabelSetVisitor visitor = new CalculateNodesLabelSetVisitor(stateSpace, bounds);
        return visitor.calculateLabelSets(candidateVector);
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
