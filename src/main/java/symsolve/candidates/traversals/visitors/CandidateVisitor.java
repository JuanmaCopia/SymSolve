package symsolve.candidates.traversals.visitors;

public interface CandidateVisitor {

    void visited(Class<?> currentOwnerClass, String fieldName, int currentOwnerID, int indexInFieldDomain);

}
