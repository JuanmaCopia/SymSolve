
package symkorat;

import korat.finitization.impl.CVElem;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;

/**
 * Main class for the SymKorat Solver.
 * @author Juan Manuel Copia
 */
public class SymKorat {


	private Solver solver;


	/**
	 *
	 * @return
	 */
	public CVElem[] getVectorFormat() {
		return solver.getStateSpace().getStructureList();
	}


    /**
     * Creates a Solver instance for the specified class and bounds.
     *
     * @param className fully qualified name of the class.
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
        } catch (CannotFindPredicateException e) {
            System.err.println("!!! Korat cannot find predicate method for the class under test:");
            System.err.println("        <class> = " + e.getCls().getName());
            System.err.println("        <predicate> = " + e.getMethodName());
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
    public boolean isSat(String stringVector) {
        boolean result = false;

        try {
        	SymKoratVector vector = new SymKoratVector(stringVector);
            result = solver.startSolverExploration(vector);
        } catch (CannotFindPredicateException e) {
            System.err.println("!!! Korat cannot find predicate method for the class under test:");
            System.err.println("        <class> = " + e.getCls().getName());
            System.err.println("        <predicate> = " + e.getMethodName());
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
    public boolean isSatNoIsmBreak(SymKoratVector vector) {
        boolean result = false;

        try {
            result = solver.startSolverExplorationNoIsmBreak(vector);
        } catch (CannotFindPredicateException e) {
            System.err.println("!!! Korat cannot find predicate method for the class under test:");
            System.err.println("        <class> = " + e.getCls().getName());
            System.err.println("        <predicate> = " + e.getMethodName());
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
        } catch (CannotFindPredicateException e) {
            System.err.println("!!! Korat cannot find predicate method for the class under test:");
            System.err.println("        <class> = " + e.getCls().getName());
            System.err.println("        <predicate> = " + e.getMethodName());
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
}
