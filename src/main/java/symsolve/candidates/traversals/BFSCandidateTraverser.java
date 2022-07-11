package symsolve.candidates.traversals;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.ObjSet;
import korat.finitization.impl.StateSpace;
import symsolve.candidates.traversals.visitors.CandidateVisitor;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;

public class BFSCandidateTraverser implements CandidateTraverser {

    StateSpace stateSpace;
    Class<?> rootClass;
    Object rootObject;

    public BFSCandidateTraverser(StateSpace stateSpace) {
        if (stateSpace == null)
            throw new IllegalArgumentException();
        this.stateSpace = stateSpace;
        rootObject = stateSpace.getRootObject();
        rootClass = rootObject.getClass();
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
            Object currentOwnerObject = worklist.removeFirst();
            int currentOwnerID = idMap.get(currentOwnerObject);

            visitor.setCurrentOwner(currentOwnerObject, currentOwnerID);

            int[] fieldIndices = stateSpace.getFieldIndicesFor(currentOwnerObject);

            for (int i : fieldIndices) {
                CVElem elem = structureList[i];
                int indexInFieldDomain = vector[i];
                FieldDomain fieldDomain = elem.getFieldDomain();
                String fieldName = elem.getFieldName();
                Class<?> clsOfField = fieldDomain.getClassOfField();

                if (fieldDomain.isPrimitiveType()) {
                    visitor.accessedPrimitiveField(fieldName, indexInFieldDomain);
                } else {  // The field is of reference type
                    ObjSet set = (ObjSet) fieldDomain;
                    Object fieldObject = set.getObject(indexInFieldDomain);

                    if (fieldObject == null) {
                        visitor.accessedNullReferenceField(fieldName, indexInFieldDomain);
                    } else if (idMap.containsKey(fieldObject)) {
                        int fieldObjectID = idMap.get(fieldObject) + 1;
                        visitor.accessedVisitedReferenceField(fieldName, fieldObject, fieldObjectID);
                    } else {
                        int fieldObjectID = 0;
                        if (maxIdMap.containsKey(clsOfField))
                            fieldObjectID = maxIdMap.get(clsOfField) + 1;
                        maxIdMap.put(clsOfField, fieldObjectID);
                        idMap.put(fieldObject, fieldObjectID);

                        fieldObjectID = fieldObjectID + 1;
                        visitor.accessedNewReferenceField(fieldName, fieldObject, fieldObjectID);

                        worklist.add(fieldObject);
                    }
                }
            }
        }
    }
}
