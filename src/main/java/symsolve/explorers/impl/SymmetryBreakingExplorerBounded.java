package symsolve.explorers.impl;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.StateSpace;
import korat.utils.IIntList;
import symsolve.bounds.Bounds;
import symsolve.candidates.traversals.visitors.ObjectIDMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SymmetryBreakingExplorerBounded extends SymmetryBreakingExplorer {

    Bounds bounds;
    List<Integer>[] boundList;

    public SymmetryBreakingExplorerBounded(StateSpace stateSpace, IIntList accessedIndices, IIntList changedFields, Bounds bounds) {
        super(stateSpace, accessedIndices, changedFields);
        this.bounds = bounds;
        boundList = new ArrayList[vectorSize];
    }

    @Override
    public void setUpExplorerState() {
        for (int i = 0; i < vectorSize; i++) {
            changedFields.add(i);
            if (!fixedIndices.contains(i) && candidateVector[i] > 0) {
                List<Integer> possibleValues = getPossibleValuesForCurrentField(i);
                removeAlreadyExploredValues(possibleValues, candidateVector[i]);
                boundList[i] = possibleValues;
            } else {
                boundList[i] = null;
            }
        }
    }

    @Override
    protected boolean setNextValue(int lastAccessedFieldIndex) {
        List<Integer> possibleValues = boundList[lastAccessedFieldIndex];
        if (possibleValues == null) {
            possibleValues = getPossibleValuesForCurrentField(lastAccessedFieldIndex);
            boundList[lastAccessedFieldIndex] = possibleValues;
        }

        if (!possibleValues.isEmpty()) {
            /*System.out.println("\n\nVector: ");
            Utils.printVectorFormat(candidateVector, stateSpace.getStructureList());
            CVElem cvElem = stateSpace.getCVElem(lastAccessedFieldIndex);
            Object ownerObject = cvElem.getObj();
            Class<?> cls = ownerObject.getClass();
            String fieldName = cvElem.getFieldName();
            int ownerId = getObjectID(ownerObject);

            System.out.println("\nField: " + cls.getSimpleName() + "." + fieldName);
            System.out.println("Owner ID: " + ownerId);
            System.out.println("Current possible values: " + possibleValues);*/
            candidateVector[lastAccessedFieldIndex] = possibleValues.remove(0);
            /*System.out.println("setted value for index " + lastAccessedFieldIndex + " == " + candidateVector[lastAccessedFieldIndex]);
            Utils.printVectorFormat(candidateVector, stateSpace.getStructureList());*/
            return true;
        }
        return false;
    }

    @Override
    protected void backtrack(int lastAccessedFieldIndex) {
        candidateVector[lastAccessedFieldIndex] = 0;
        boundList[lastAccessedFieldIndex] = null;
    }

    private List<Integer> getPossibleValuesForCurrentField(int fieldIndex) {
        CVElem cvElem = stateSpace.getCVElem(fieldIndex);
        Object ownerObject = cvElem.getObj();
        Class<?> cls = ownerObject.getClass();
        String fieldName = cvElem.getFieldName();
        int ownerId = getObjectID(ownerObject);

        /*System.out.println("\nField: " + cls.getSimpleName() + "." + fieldName);
        System.out.println("Owner ID: " + ownerId);*/
        Set<Integer> boundValues = bounds.getAllowedValues(cls, fieldName, ownerId);
        //System.out.println("Bounds: " + boundValues.toString());
        return new ArrayList<>(boundValues);
    }

    private int getObjectID(Object object) {
        ObjectIDMapper visitor = new ObjectIDMapper(stateSpace);
        Map<Object, Integer> objectIDs = visitor.calculateObjectsIDs(candidateVector);
        assert (objectIDs.containsKey(object));
        return objectIDs.get(object);
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
