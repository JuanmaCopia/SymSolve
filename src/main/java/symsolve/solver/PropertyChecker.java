package symsolve.solver;


import korat.finitization.impl.Finitization;
import korat.finitization.impl.StateSpace;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import korat.utils.IIntList;
import korat.utils.IntListAI;
import symsolve.candidates.CandidateBuilder;
import symsolve.candidates.PredicateChecker;
import symsolve.config.SymSolveConfig;
import symsolve.explorers.VectorStateSpaceExplorer;
import symsolve.explorers.VectorStateSpaceExplorerFactory;
import symsolve.explorers.impl.SymbolicVectorExplorerFactory;
import symsolve.utils.Helper;
import symsolve.vector.SymSolveVector;

import java.lang.reflect.Method;

public class PropertyChecker {

    StateSpace stateSpace;
    VectorStateSpaceExplorer symbolicVectorSpaceExplorer;
    CandidateBuilder candidateBuilder;
    Class<?> rootClass;
    Finitization finitization;
    PredicateChecker predicateChecker;
    Method predicate;
    Method property;
    IIntList accessedIndices;
    IIntList changedFields;


    public PropertyChecker(SymSolveConfig params, String finitizationName) throws ClassNotFoundException, CannotFindFinitizationException,
            CannotInvokeFinitizationException, CannotFindPredicateException {

        rootClass = Finitization.getClassLoader().loadClass(params.getFullyQualifiedClassName());

        finitization = Helper.getFinitization(rootClass, finitizationName, params.getFinitizationArgs());
        predicateChecker = new PredicateChecker();
        finitization.initialize(predicateChecker);

        stateSpace = finitization.getStateSpace();
        int vectorSize = stateSpace.getTotalNumberOfFields();

        accessedIndices = new IntListAI(vectorSize);
        changedFields = new IntListAI(vectorSize);

        predicateChecker.initialize(rootClass, params.getPredicateName(), accessedIndices);
        predicate = predicateChecker.getPredicate();

        candidateBuilder = new CandidateBuilder(stateSpace, changedFields);

        VectorStateSpaceExplorerFactory heapExplorerFactory = new SymbolicVectorExplorerFactory(stateSpace, accessedIndices, changedFields);
        symbolicVectorSpaceExplorer = heapExplorerFactory.makeSymbolicVectorExplorer(params);
    }

    public boolean checkProperty(SymSolveVector input, SymSolveVector output, String propertyMethodName) throws CannotInvokePredicateException, CannotFindPredicateException {
        property = Helper.getPredicateMethod(rootClass, propertyMethodName);
        symbolicVectorSpaceExplorer.initialize(input);
        int[] vector = symbolicVectorSpaceExplorer.getCandidateVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate)) {
                int[] correspondingOutput = calculateCorrespondingOutput(vector, output);
                Object outputStructure = candidateBuilder.buildCandidate(correspondingOutput);
                if (violatesPredicate(predicate, outputStructure))
                    return false;
                if (violatesPredicate(property, outputStructure))
                    return false;
            }
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return true;
    }

    private int[] calculateCorrespondingOutput(int[] inputVector, SymSolveVector output) {
        changedFields.clear();
        int[] correspondingOutput = inputVector.clone();
        int[] outputVector = output.getConcreteVector();
        for (Integer index : output.getFixedIndices()) {
            correspondingOutput[index] = outputVector[index];
            changedFields.add(index);
        }
        return correspondingOutput;
    }

/*    public boolean checkPropertyForCandidate(SymSolveVector initialVector, String propertyMethodName) throws CannotInvokePredicateException, CannotFindPredicateException {
        if (property == null)
            property = Helper.getPredicateMethod(rootClass, propertyMethodName);
        predicateChecker.setPredicate(property);
        symbolicVectorSpaceExplorer.initialize(initialVector);
        int[] vector = symbolicVectorSpaceExplorer.getCandidateVector();
        while (vector != null) {
            Object candidate = candidateBuilder.buildCandidate(vector);
            if (predicateChecker.checkPredicate(candidate))
                return true;
            vector = symbolicVectorSpaceExplorer.getNextCandidate();
        }
        return false;
    }*/

    private boolean violatesPredicate(Method predicate, Object candidate) throws CannotInvokePredicateException {
        assert (candidate != null);
        boolean predicateEvaluation;
        try {
            predicateEvaluation = (Boolean) predicate.invoke(candidate, (Object[]) null);
        } catch (Exception e) {
            throw new CannotInvokePredicateException(rootClass, predicate.getName(), e.getMessage(), e);
        }
        return !predicateEvaluation;
    }

    public StateSpace getStateSpace() {
        return stateSpace;
    }

}
