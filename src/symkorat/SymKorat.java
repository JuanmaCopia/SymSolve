package symkorat;

import korat.config.ConfigLoader;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;


public class SymKorat {


	private KSolver ksolver;

	
	public SymKorat(String className, String finArgs) {
		ksolver = KSolver.getInstance();
		try {
			ksolver.initialize(className, finArgs);
		} catch (CannotFindFinitizationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotInvokeFinitizationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotFindPredicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public boolean isSat(KoratCandidateVector cv) {
        boolean result = false;

        try {
            result = ksolver.startSolverExploration(cv);

        } catch (CannotFindPredicateException e) {

            System.err.println("!!! Korat cannot find predicate method for the class under test:");
            System.err.println("        <class> = " + e.getCls().getName());
            System.err.println("        <predicate> = " + e.getMethodName());
            System.err.println("    Use -"
                    + ConfigLoader.PREDICATE.getSwitches()
                    + " switch to provide custom predicate method name.");

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
    
    public boolean autoHybridRepOK(KoratCandidateVector cv) {
        boolean result = false;

        try {
            result = ksolver.runAutoHybridRepok(cv);

        } catch (CannotFindPredicateException e) {

            System.err.println("!!! Korat cannot find predicate method for the class under test:");
            System.err.println("        <class> = " + e.getCls().getName());
            System.err.println("        <predicate> = " + e.getMethodName());
            System.err.println("    Use -"
                    + ConfigLoader.PREDICATE.getSwitches()
                    + " switch to provide custom predicate method name.");

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
    
    public boolean isSat(String cv) {
        boolean result = false;

        try {
        	initCandidateVector(cv);
            result = ksolver.startSolverExploration(ksolver.kcv);

        } catch (CannotFindPredicateException e) {

            System.err.println("!!! Korat cannot find predicate method for the class under test:");
            System.err.println("        <class> = " + e.getCls().getName());
            System.err.println("        <predicate> = " + e.getMethodName());
            System.err.println("    Use -"
                    + ConfigLoader.PREDICATE.getSwitches()
                    + " switch to provide custom predicate method name.");

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
    
    public boolean isSatNoIsmBreak(KoratCandidateVector cv) {
        boolean result = false;

        try {
            result = ksolver.startSolverExplorationNoIsmBreak(cv);

        } catch (CannotFindPredicateException e) {

            System.err.println("!!! Korat cannot find predicate method for the class under test:");
            System.err.println("        <class> = " + e.getCls().getName());
            System.err.println("        <predicate> = " + e.getMethodName());
            System.err.println("    Use -"
                    + ConfigLoader.PREDICATE.getSwitches()
                    + " switch to provide custom predicate method name.");

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
    
    private void initCandidateVector(String strCV) {
        String[] elemsCV = strCV.split(",");
        ksolver.kcv.candidateVector = new int[elemsCV.length];
        ksolver.kcv.fixedIndexes.clear();
        for (int i = 0; i < elemsCV.length; i++) {
        	int elem = Integer.parseInt(elemsCV[i]);
        	if (elem <= -1)
        		ksolver.kcv.candidateVector[i] = 0;
        	else {
        		ksolver.kcv.candidateVector[i] = elem;
        		ksolver.kcv.fixedIndexes.add(i);
        	}
        }
    }
    
    public KoratCandidateVector getKoratCandidateVector() {
    	return ksolver.kcv;
    }

}
