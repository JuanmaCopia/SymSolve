package symsolve.candidates.traversals.visitors;

import symsolve.bounds.Bounds;

public class BoundCalculatorVisitor implements CandidateVisitor {

    Bounds bounds;

    public BoundCalculatorVisitor(Bounds bounds) {
        this.bounds = bounds;
    }

    @Override
    public void visited(Class<?> ownerClass, String fieldName, int ownerID, int fieldValueID) {
        bounds.addBound(ownerClass, fieldName, ownerID, fieldValueID);
    }

}
