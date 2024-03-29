package symsolve;

import korat.finitization.impl.Finitization;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.config.SolverConfig;
import symsolve.solver.Solver;
import symsolve.vector.SymSolveSolution;
import symsolve.vector.SymSolveVector;

import java.util.HashMap;
import java.util.Map;


public class SymSolve {


    SolverConfig config;
    private Solver solver;

    private final Map<int[], SymSolveSolution> cache = new HashMap<>();
    private final Map<int[], SymSolveSolution> nextSolutionCache = new HashMap<>();


    /**
     * Creates a SymSolve instance according to the provides configuration parameters.
     *
     * @param config The configuration parameters.
     */
    public SymSolve(SolverConfig config) {
        this.config = config;
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
     * @param vector The vector representing a partially symbolic instance.
     * @return True if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSatisfiable(String vector) {
        return isSatisfiable(new SymSolveVector(vector));
    }

    /**
     * Decides whether a partially symbolic instance represented by a vector is SAT.
     *
     * @param vector The vector representing a partially symbolic instance.
     * @return True if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSatisfiable(SymSolveVector vector) {
        SymSolveSolution solution = null;

        int[] query = vector.createPartialVector();
        if (cache.containsKey(query)) {
            solution = cache.get(query);
            return solution != null;
        }

        try {
            solution = solver.startSearch(vector);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }

        cache.put(query, solution);
        return solution != null;
    }

    /**
     * Decides whether the symbolic instance represented by a vector is SAT. If it
     * is, returns the solution.
     *
     * @param vector The vector representing a partially symbolic instance.
     * @return The solution vector if the symbolic structure is SAT, null if it is
     * UNSAT.
     */
    public SymSolveSolution solve(SymSolveVector vector) {
        int[] query = vector.createPartialVector();
        if (cache.containsKey(query)) {
            return cache.get(query);
        }

        SymSolveSolution solution = null;
        try {
            solution = solver.startSearch(vector);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }

        cache.put(query, solution);
        return solution;
    }

    /**
     * Decides whether a partially symbolic instance represented by a string vector
     * is SAT according to the hybrid repOK strategy.
     *
     * @param vector The vector representing a partially symbolic instance.
     * @return True if the symbolic structure is SAT, false if it is UNSAT.
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
     * Starts the search from a previous solution
     *
     * @return the new solution vector if found, null otherwise.
     */
    public SymSolveSolution getNextSolution(SymSolveSolution previousSolution) {
        int[] query = previousSolution.getUniqueIdentifier();
        if (nextSolutionCache.containsKey(query)) {
            return nextSolutionCache.get(query);
        }

        SymSolveSolution result = null;
        try {
            result = solver.getNextSolution(previousSolution);
        } catch (CannotInvokePredicateException e) {
            e.printStackTrace(System.err);
        }

        nextSolutionCache.put(query, result);
        return result;
    }


    public Finitization getFinitization() {
        return solver.getFinitization();
    }

}
