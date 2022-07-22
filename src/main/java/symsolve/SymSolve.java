package symsolve;

import korat.finitization.impl.CVElem;
import korat.finitization.impl.IntSet;
import korat.finitization.impl.StateSpace;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.candidates.PredicateChecker;
import symsolve.config.SolverConfig;
import symsolve.solver.Solver;
import symsolve.vector.SymSolveVector;

import java.util.HashMap;
import java.util.Map;

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
        this(new SolverConfig(className, finitizationArgs));
    }

    public SymSolve(SolverConfig config) {
        try {
            solver = new Solver(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
