package symsolve;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.IntSet;
import korat.finitization.impl.StateSpace;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.explorers.impl.SymmetryBreakStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * API for the SymSolve tool.
 *
 * @author Juan Manuel Copia
 */
public class SymSolve {

    private Solver solver;

    /**
     * Creates a SymSolve instance that decides satisfiability of partially symbolic
     * heaps, represented as vectors, for the specified class and bounds. The search
     * of the state space of vectors is performed using symmetry breaking enabled.
     *
     * @param className        fully qualified name of the class.
     * @param finitizationArgs arguments to be passed to the finitization method.
     */
    public SymSolve(String className, String finitizationArgs) {
        this(new ConfigParameters(className, finitizationArgs));
    }

    private SymSolve(ConfigParameters config) {
        try {
            solver = new Solver(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a SymSolve instance that decides satisfiability of partially symbolic
     * heaps, represented as vectors, for the specified class and bounds. The search
     * of the state space of vectors is performed using the specified strategy.
     *
     * @param className             fully qualified name of the class.
     * @param finitizationArgs      arguments to be passed to the finitization
     *                              method.
     * @param symmetryBreakStrategy symmetry break strategy to be used by the
     *                              solver.
     */
    public SymSolve(String className, String finitizationArgs, SymmetryBreakStrategy symmetryBreakStrategy) {
        this(new ConfigParameters(className, finitizationArgs, symmetryBreakStrategy));
    }

    /**
     * Creates a SymSolve instance that decides satisfiability of partially symbolic
     * heaps, represented as vectors, for the specified class and bounds. The search
     * of the state space of vectors is performed using the specified strategy.
     *
     * @param className             fully qualified name of the class.
     * @param finitizationArgs      arguments to be passed to the finitization
     *                              method.
     * @param symmetryBreakStrategy symmetry break strategy to be used by the
     *                              solver.
     * @param predicateName         name of the predicate method.
     */
    public SymSolve(String className, String finitizationArgs, SymmetryBreakStrategy symmetryBreakStrategy, String predicateName) {
        this(new ConfigParameters(className, finitizationArgs, symmetryBreakStrategy, predicateName));
    }

    /**
     * Decides whether a partially symbolic instance represented by a string vector
     * is SAT.
     *
     * @param vector the vector representing a partially symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSatisfiable(String vector) {
        return isSatisfiable(new SymSolveVector(vector));
    }

    /**
     * Decides whether a partially symbolic instance represented by a vector is SAT.
     *
     * @param vector the vector representing a partially symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSatisfiable(SymSolveVector vector) {
        boolean result = false;

        try {
            result = solver.startSearch(vector);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Decides whether the symbolic instance represented by a vector is SAT. If it
     * is, returns the vector solution.
     * public HashMap<String, IntSet> getIntegerFieldsMinMaxMap() {
     * return this.integerFieldsMinMax;
     * }
     *
     * @param vector the vector representing a partially symbolic instance.
     * @return the solution vector if the symbolic structure is SAT, null if it is
     * UNSAT.
     */
    public int[] solve(SymSolveVector vector) {
        if (isSatisfiable(vector))
            return solver.getCandidateVector();
        return null;
    }

    /**
     * Resumes the search where it was left off. If a new solution is found, it is
     * returned.
     *
     * @return a solution vector if founded, null otherwise.
     */
    public int[] searchAnotherSolution(SymSolveVector vector) {
        boolean isSat = false;
        try {
            isSat = solver.searchOtherSolution(vector);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }
        if (isSat)
            return solver.getCandidateVector();
        return null;
    }

    /**
     * Returns All the solutions for the provided partially symbolic instance
     * represented by vector.
     *
     * @param vector the vector representing a partially symbolic instance.
     * @return All the solution vectors found for that partially symbolic vector. If
     * no solution is found, an empty set is returned.
     */
    public Set<int[]> getAllSolutions(SymSolveVector vector) {
        Set<int[]> vectorSolutions = null;
        try {
            vectorSolutions = solver.getAllSolutions(vector);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }
        return vectorSolutions;
    }

/*    public Bounds calculateBounds() {
        Bounds bounds = null;
        try {
            bounds = solver.calculateBounds();
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }
        return bounds;
    }*/

    /**
     * Decides whether a partially symbolic instance represented by a string vector
     * is SAT according to the hybrid repOK strategy.
     *
     * @param vector the vector representing a partially symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSatAutoHybridRepOK(SymSolveVector vector) {
        boolean result = false;
        try {
            result = solver.runAutoHybridRepok(vector);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }
        return result;
    }


    public boolean runRepOK(SymSolveVector vector) {
        boolean result = false;
        try {
            result = solver.runRepOK(vector);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Sets the predicate that will determine the satisfiability of vectors during
     * solver search.
     *
     * @param predicateName name of the predicate to be used.
     */
    public void setPredicate(String predicateName) {
        PredicateChecker predicateChecker = PredicateChecker.getInstance();
        try {
            predicateChecker.setPredicate(predicateName);
        } catch (CannotFindPredicateException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param solutionVector
     * @return
     */
    public String generateStructureCode(int[] solutionVector) {
        return solver.generateStructureCode(solutionVector);
    }


    /**
     * Returns the representation format of the vector.
     *
     * @return A vector describing the types and fields that represent the
     * structure.
     */
    public CVElem[] getVectorFormat() {
        return solver.getStateSpace().getStructureList().clone();
    }

    /**
     * Returns a map of class names to the maximum number of allowed objects
     * (bounds) of that class to construct possible concretizations.
     *
     * @return A map of simple class names to maximum number of objects.
     */
    public HashMap<String, Integer> getScopes() {
        return solver.getScopes();
    }

    public Map<String, IntSet> getIntegerFieldsMinMaxMap() {
        return this.solver.getIntegerFieldsMinMaxMap();
    }


    public StateSpace getStateSpace() {
        return solver.getStateSpace();
    }

}
