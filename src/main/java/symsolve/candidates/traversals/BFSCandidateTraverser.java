package symsolve.candidates.traversals;

import korat.finitization.impl.*;
import symsolve.candidates.traversals.visitors.CandidateVisitor;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;

public class BFSCandidateTraverser implements CandidateTraverser {

    StateSpace stateSpace;
    Class<?> rootClass;
    Object rootObject;

    public BFSCandidateTraverser(Finitization finitization) {
        stateSpace = finitization.getStateSpace();
        rootClass = finitization.getRootClass();
        rootObject = finitization.getRootObject();
    }

    public void traverse(int[] vector, CandidateVisitor visitor) {
        HashMap<Class<?>, Integer> maxIdMap = new HashMap<Class<?>, Integer>();
        IdentityHashMap<Object, Integer> idMap = new IdentityHashMap<Object, Integer>();

        maxIdMap.put(rootClass, 0);
        idMap.put(rootObject, 0);

        CVElem[] structureList = stateSpace.getStructureList();
        LinkedList<Object> worklist = new LinkedList<Object>();
        worklist.add(rootObject);

        while (!worklist.isEmpty()) {
            Object currentOwner = worklist.removeFirst();
            int currentOwnerID = idMap.get(currentOwner);
            Class<?> currentOwnerClass = currentOwner.getClass();

            int[] fieldIndices = stateSpace.getFieldIndicesFor(currentOwner);

            for (int i : fieldIndices) {
                CVElem elem = structureList[i];
                int indexInFieldDomain = vector[i];
                FieldDomain fieldDomain = elem.getFieldDomain();
                String fieldName = elem.getFieldName();
                Class<?> clsOfField = fieldDomain.getClassOfField();

                if (fieldDomain.isPrimitiveType()) {
                    visitor.visited(currentOwnerClass, fieldName, currentOwnerID, indexInFieldDomain);
                } else {  // The field is of reference type
                    ObjSet set = (ObjSet) fieldDomain;
                    Object fieldValue = set.getObject(indexInFieldDomain);

                    if (fieldValue == null) {
                        visitor.visited(currentOwnerClass, fieldName, currentOwnerID, indexInFieldDomain);

                    } else if (idMap.containsKey(fieldValue)) {
                        int fieldValueID = idMap.get(fieldValue);
                        visitor.visited(currentOwnerClass, fieldName, currentOwnerID, fieldValueID + 1);

                    } else {
                        int fieldValueID = 0;
                        if (maxIdMap.containsKey(clsOfField))
                            fieldValueID = maxIdMap.get(clsOfField) + 1;
                        maxIdMap.put(clsOfField, fieldValueID);
                        idMap.put(fieldValue, fieldValueID);

                        visitor.visited(currentOwnerClass, fieldName, currentOwnerID, fieldValueID + 1);

                        worklist.add(fieldValue);
                    }
                }
            }
        }
    }
}
