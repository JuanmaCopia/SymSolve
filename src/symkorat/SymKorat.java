
package symkorat;

import java.util.HashMap;

import korat.finitization.impl.CVElem;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;

/**
 * API for the SymKorat Solver.
 *
 * @author Juan Manuel Copia
 */
public class SymKorat {

    private Solver solver;

    /**
     * Creates a SymKorat instance to decide satisfiability for the specified class
     * and bounds.
     *
     * @param className        fully qualified name of the class.
     * @param finitizationArgs arguments to be passed to the finitization method.
     */
    public SymKorat(String className, String finitizationArgs) {
        solver = Solver.getInstance();
        try {
            solver.initialize(className, finitizationArgs);
        } catch (CannotFindFinitizationException e) {
            e.printStackTrace();
        } catch (CannotInvokeFinitizationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (CannotFindPredicateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Decides whether the symbolic instance represented by a vector is SAT.
     *
     * @param cv the vector representing a symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSat(SymKoratVector vector) {
        boolean result = false;

        try {
            result = solver.startSolverExploration(vector);
        } catch (CannotInvokePredicateException e) {
            System.err.println("!!! Korat cannot invoke predicate method:");
            System.err.println("      <class> = " + e.getCls().getName());
            System.err.println("      <predicate> = " + e.getMethodName());
            System.err.println();
            System.err.println("    Stack trace:");
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
    public int[] isSatWithSolution(SymKoratVector vector) {
        int[] result = null;

        try {
            result = solver.startSolverExplorationWithSolution(vector);
        } catch (CannotInvokePredicateException e) {
            System.err.println("!!! Korat cannot invoke predicate method:");
            System.err.println("      <class> = " + e.getCls().getName());
            System.err.println("      <predicate> = " + e.getMethodName());
            System.err.println();
            System.err.println("    Stack trace:");
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Decides whether the symbolic instance represented by a string vector is SAT.
     *
     * @param vector the vector representing a symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSat(String vector) {
        boolean result = false;

        try {
            result = solver.startSolverExploration(new SymKoratVector(vector));
        } catch (CannotInvokePredicateException e) {
            System.err.println("!!! Korat cannot invoke predicate method:");
            System.err.println("      <class> = " + e.getCls().getName());
            System.err.println("      <predicate> = " + e.getMethodName());
            System.err.println();
            System.err.println("    Stack trace:");
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Decides whether the symbolic instance represented by a vector is SAT.
     *
     * @param vector the vector representing a symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSatNoSymmetryBreak(SymKoratVector vector) {
        boolean result = false;

        try {
            result = solver.startSolverExplorationNoSymmetryBreak(vector);
        } catch (CannotInvokePredicateException e) {
            System.err.println("!!! Korat cannot invoke predicate method:");
            System.err.println("      <class> = " + e.getCls().getName());
            System.err.println("      <predicate> = " + e.getMethodName());
            System.err.println();
            System.err.println("    Stack trace:");
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Decides whether the symbolic instance represented by a vector is SAT.
     *
     * @param vector the vector representing a symbolic instance.
     * @return true if the symbolic structure is SAT, false if it is UNSAT.
     */
    public boolean isSatNoSymmetryBreak(String vector) {
        boolean result = false;

        try {
            result = solver.startSolverExplorationNoSymmetryBreak(new SymKoratVector(vector));
        } catch (CannotInvokePredicateException e) {
            System.err.println("!!! Korat cannot invoke predicate method:");
            System.err.println("      <class> = " + e.getCls().getName());
            System.err.println("      <predicate> = " + e.getMethodName());
            System.err.println();
            System.err.println("    Stack trace:");
            e.printStackTrace(System.err);
        }
        return result;
    }

    /**
     * Implements the automatically derived hybrid repOK.
     *
     * @param vector the vector representing a symbolic instance.
     * @return the result of the automatically derived repOK.
     */
    public boolean autoHybridRepOK(SymKoratVector vector) {
        boolean result = false;

        try {
            result = solver.runAutoHybridRepok(vector);
        } catch (CannotInvokePredicateException e) {
            System.err.println("!!! Korat cannot invoke predicate method:");
            System.err.println("      <class> = " + e.getCls().getName());
            System.err.println("      <predicate> = " + e.getMethodName());
            System.err.println();
            System.err.println("    Stack trace:");
            e.printStackTrace(System.err);
        }
        return result;
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
     * Returns the finitization bounds for each class.
     *
     * @return A map of simple class names to number of objects.
     */
    public HashMap<String, Integer> getBounds() {
        return solver.getBounds();
    }

}
