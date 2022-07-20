package symsolve.candidates.traversals;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.FieldDomain;
import korat.finitization.impl.ObjSet;
import korat.finitization.impl.StateSpace;
import symsolve.candidates.traversals.visitors.CandidateVisitor;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Map;

public class BFSCandidateTraverser implements CandidateTraverser {

    Map<Class<?>, Integer> maxIdMap = new HashMap<>();
    Map<Object, Integer> idMap = new IdentityHashMap<>();
    LinkedList<Object> queue = new LinkedList<>();

    StateSpace stateSpace;

    Object rootObject;
    int[] traversedVector;
    CandidateVisitor visitor;


    public BFSCandidateTraverser(StateSpace stateSpace) {
        if (stateSpace == null)
            throw new IllegalArgumentException();
        this.stateSpace = stateSpace;
        rootObject = stateSpace.getRootObject();
    }

    public void traverse(int[] traversedVector, CandidateVisitor visitor) {
        initializeTraverserState(traversedVector, visitor);
        handleRoot();

        while (!allNodesHaveBeenExplored()) {
            Object currentNode = getNextNode();
            handleNode(currentNode);
            loopThroughFieldsOfNode(currentNode);
        }
    }

    private void initializeTraverserState(int[] traversedVector, CandidateVisitor visitor) {
        this.traversedVector = traversedVector;
        this.visitor = visitor;

        maxIdMap.clear();
        idMap.clear();
        queue.clear();

        maxIdMap.put(rootObject.getClass(), 0);
        idMap.put(rootObject, 0);
        queue.add(rootObject);
    }

    private void handleRoot() {
        visitor.setRoot(rootObject, idMap.get(rootObject)); // root ObjSet does not include null, so we don't add 1 to the ID
    }

    private boolean allNodesHaveBeenExplored() {
        return queue.isEmpty();
    }

    private void handleNode(Object node) {
        int currentNodeID = idMap.get(node);
        if (node != rootObject)
            visitor.setCurrentOwner(node, currentNodeID + 1);
        else
            visitor.setCurrentOwner(node, currentNodeID);
    }

    private Object getNextNode() {
        return queue.removeFirst();
    }

    private void loopThroughFieldsOfNode(Object node) {
        int[] fieldIndices = stateSpace.getFieldIndicesFor(node);
        CVElem[] structureList = stateSpace.getStructureList();

        for (int i : fieldIndices) {

            int indexInFieldDomain = traversedVector[i];
            CVElem elem = structureList[i];
            FieldDomain fieldDomain = elem.getFieldDomain();
            String fieldName = elem.getFieldName();

            if (fieldDomain.isPrimitiveType()) {
                handlePrimitiveField(fieldName, indexInFieldDomain);
            } else {
                Object fieldObject = ((ObjSet) fieldDomain).getObject(indexInFieldDomain);
                handleReferenceField(fieldObject, fieldName, indexInFieldDomain);
            }
        }
    }

    private void handlePrimitiveField(String fieldName, int indexInFieldDomain) {
        visitor.accessedPrimitiveField(fieldName, indexInFieldDomain);
    }

    private void handleReferenceField(Object fieldObject, String fieldName, int indexInFieldDomain) {
        if (fieldObject == null) {
            handleNullReferenceField(fieldName, indexInFieldDomain);
        } else if (idMap.containsKey(fieldObject)) {
            handleAlreadyVisitedReferenceField(fieldName, fieldObject);
        } else {
            handleNewReferenceField(fieldName, fieldObject);
        }
    }

    private void handleNullReferenceField(String fieldName, int indexInFieldDomain) {
        visitor.accessedNullReferenceField(fieldName, indexInFieldDomain);
    }

    private void handleAlreadyVisitedReferenceField(String fieldName, Object fieldObject) {
        int fieldObjectID = idMap.get(fieldObject) + 1;
        visitor.accessedVisitedReferenceField(fieldName, fieldObject, fieldObjectID);
    }

    private void handleNewReferenceField(String fieldName, Object fieldObject) {
        int fieldObjectID = 0;
        Class<?> clsOfField = fieldObject.getClass();
        if (maxIdMap.containsKey(clsOfField))
            fieldObjectID = maxIdMap.get(clsOfField) + 1;
        maxIdMap.put(clsOfField, fieldObjectID);
        idMap.put(fieldObject, fieldObjectID);

        fieldObjectID = fieldObjectID + 1;
        visitor.accessedNewReferenceField(fieldName, fieldObject, fieldObjectID);

        addNodeToQueue(fieldObject);
    }

    private void addNodeToQueue(Object node) {
        queue.add(node);
    }

}
