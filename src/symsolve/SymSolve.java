
package symsolve;

import java.util.HashMap;

import korat.finitization.impl.CVElem;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.explorers.impl.ExplorationStrategy;

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
        solver = Solver.getInstance();
        try {
            solver.initialize(new ConfigParameters(className, finitizationArgs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a SymSolve instance that decides satisfiability of partially symbolic
     * heaps, represented as vectors, for the specified class and bounds. The search
     * of the state space of vectors is performed using the specified strategy.
     *
     * @param className        fully qualified name of the class.
     * @param finitizationArgs arguments to be passed to the finitization method.
     * @param stategy          search Strategy to be used by SymSolve.
     */
    public SymSolve(String className, String finitizationArgs, ExplorationStrategy strategy) {
        solver = Solver.getInstance();
        try {
            solver.initialize(new ConfigParameters(className, finitizationArgs, strategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the representation format of the vector.
     *
     * @return A vector describing the types and fields that represent the
     *         structure.
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
    public HashMap<String, Integer> getBounds() {
        return solver.getBounds();
    }

    /**
     * Decides whether a partially symbolic instance represented by a vector is SAT.
     *
     * @param vector the vector representing a partially symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSat(SymbolicVector vector) {
        boolean result = false;

        try {
            result = solver.startSolverExploration(vector);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Decides whether a partially symbolic instance represented by a string vector
     * is SAT.
     *
     * @param vector the vector representing a partially symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSat(String vector) {
        boolean result = false;
        try {
            result = solver.startSolverExploration(new SymbolicVector(vector));
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Decides whether the symbolic instance represented by a vector is SAT. If it
     * is, returns the vector solution.
     *
     * @param cv the vector representing a symbolic instance.
     * @return the solution vector if the symbolic structure is SAT, null if it is
     *         UNSAT.
     */
    public int[] isSatWithSolution(SymbolicVector vector) {
        if (isSat(vector))
            return solver.getCandidateVector();
        return null;
    }

    /**
     * Decides whether a partially symbolic instance represented by a string vector
     * is SAT according to the hybrid repOK strategy.
     *
     * @param vector the vector representing a partially symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSatAutoHybridRepOK(SymbolicVector vector) {
        boolean result = false;
        try {
            result = solver.runAutoHybridRepok(vector);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

}
