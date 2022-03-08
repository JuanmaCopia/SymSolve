package symkorat;

import java.lang.reflect.Method;
import java.util.ArrayList;

import korat.finitization.IFinitization;
import korat.finitization.impl.Finitization;
import korat.finitization.impl.StateSpace;
import korat.loading.InstrumentingClassLoader;
import korat.testing.ITester;
import korat.testing.impl.AbstractTestCaseGenerator;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;
import korat.testing.impl.CannotInvokePredicateException;
import korat.utils.IIntList;


public class KSolver extends AbstractTestCaseGenerator implements ITester {

    private static KSolver instance = new KSolver();

    public static KSolver getInstance() {
        return instance;
    }

    protected ClassLoader classLoader;

    protected KSolver() {
        classLoader = new InstrumentingClassLoader();
        Finitization.setClassLoader(classLoader);
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    /*
     * -------------------------------------------------------------------------
     * Implementation of ITester interface.
     * -------------------------------------------------------------------------
     */

    private boolean traceStarted;

    public void startFieldTrace() {
        traceStarted = true;
        accessedFields.clear();
    }

    public void continueFieldTrace() {
        traceStarted = true;
    }

    public void stopFieldTrace() {
        traceStarted = false;
    }

    public void notifyFieldAccess(Object obj, String field) {
        if (!traceStarted)
            return;

        int accessedFieldIndex = stateSpace.getIndexInCandidateVector(obj,
                field);

        if (accessedFieldIndex != -1)
            accessedFields.add(accessedFieldIndex);
    }

    public void notifyFieldAccess(int accessedFieldIndex) {
        if (!traceStarted)
            return;

        if (accessedFieldIndex != -1)
            accessedFields.add(accessedFieldIndex);
    }


    /*
     * -------------------------------------------------------------------------
     * Info that listeners may query in the middle of the search process.
     * -------------------------------------------------------------------------
     */

    public int[] getCandidateVector() {
        return stateSpaceExplorer.getCandidateVector().clone();
    }

    public boolean isPredicateOK() {
        return predicateOK;
    }

    public IIntList getAccessedFields() {
        return stateSpaceExplorer.getAccessedFields();
    }

    public StateSpace getStateSpace() {
        return stateSpace;
    }


    /*
     * -------------------------------------------------------------------------
     * Internal stuff.
     * -------------------------------------------------------------------------
     */

    protected StateSpace stateSpace;

    protected IIntList accessedFields;

    protected boolean predicateOK;

    protected Class<?> clazz;

    protected String[] finArgs;

    Method finMethod;

    IFinitization fin;

    Method predicate;

    public ArrayList<String> vectorDescription;

    String[] finitizationArgs;

    SolverStateSpaceExplorer stateSpaceExplorer;

    public KoratCandidateVector kcv;

    public void initialize(String className, String finArgs) throws ClassNotFoundException, CannotFindFinitizationException, CannotInvokeFinitizationException, CannotFindPredicateException {
    	this.clazz = classLoader.loadClass(className);
    	this.finArgs = finArgs.split(",");

    	String[] cs = className.split("\\.");
    	String finName = "fin" + cs[cs.length - 1];
    	this.finMethod = getFinMethod(clazz, finName, this.finArgs);

    	this.fin = invokeFinMethod(clazz, this.finMethod, this.finArgs);
		this.predicate = getPredicateMethod(fin.getFinClass(), "repOK");
        this.stateSpace = ((Finitization) fin).getStateSpace();
        this.kcv = new KoratCandidateVector(stateSpace.getStructureList());
    }

    private Method getFinMethod(Class<?> cls, String finName, String[] finArgs)
            throws CannotFindFinitizationException {

        Method finitize = null;
        for (Method m : cls.getDeclaredMethods()) {
            if (finName.equals(m.getName())
                    && m.getParameterTypes().length == finArgs.length) {
                finitize = m;
                break;
            }
        }
        if (finitize == null) {
            throw new CannotFindFinitizationException(cls, finName);
        }
        return finitize;

    }

    private IFinitization invokeFinMethod(Class<?> cls, Method finitize,
            String[] finArgs) throws CannotInvokeFinitizationException {

        int paramNumber = finArgs.length;
        Class<?>[] finArgTypes = finitize.getParameterTypes();
        Object[] finArgValues = new Object[paramNumber];

        for (int i = 0; i < paramNumber; i++) {
            Class<?> clazz = finArgTypes[i];
            String arg = finArgs[i].trim();
            Object val;

            if (clazz == boolean.class || clazz == Boolean.class) {
                val = Boolean.parseBoolean(arg);
            } else if (clazz == byte.class || clazz == Byte.class) {
                val = Byte.parseByte(arg);
            } else if (clazz == double.class || clazz == Double.class) {
                val = Double.parseDouble(arg);
            } else if (clazz == float.class || clazz == Float.class) {
                val = Float.parseFloat(arg);
            } else if (clazz == int.class || clazz == Integer.class) {
                val = Integer.parseInt(arg);
            } else if (clazz == long.class || clazz == Long.class) {
                val = Long.parseLong(arg);
            } else if (clazz == short.class || clazz == Short.class) {
                val = Short.parseShort(arg);
            } else if (clazz == String.class) {
                val = arg;
            } else
                throw new CannotInvokeFinitizationException(cls, finitize.getName(),
                        "Only parameters of primitive classes are allowed");

            finArgValues[i] = val;
        }

        try {
            return (IFinitization) finitize.invoke(null, (Object[]) finArgValues);
        } catch (Exception e) {
            throw new CannotInvokeFinitizationException(cls, finitize.getName(), e);
        }

    }
    
    public boolean runAutoHybridRepok(KoratCandidateVector kcv) throws CannotInvokePredicateException, CannotFindPredicateException {
    	stateSpaceExplorer = new SolverStateSpaceExplorer(fin, kcv);
        accessedFields = stateSpaceExplorer.getAccessedFields();

        Object candidate = stateSpaceExplorer.buildCandidate();
        if (checkPredicate(candidate, predicate))
            return true;
        else {
        	for (int i = 0; i < accessedFields.numberOfElements(); i++) {
        		int index = accessedFields.get(i);
        		if (!kcv.fixedIndexes.contains(index))
        			return true;
        	}	
        }
        return false;
    }

    public boolean startSolverExploration(KoratCandidateVector kcv) throws CannotInvokePredicateException, CannotFindPredicateException {
    	stateSpaceExplorer = new SolverStateSpaceExplorer(fin, kcv);
        accessedFields = stateSpaceExplorer.getAccessedFields();

        Object nextStructure = null;
        while (true) {
        	nextStructure = stateSpaceExplorer.nextTestCase();
            if (nextStructure == null)
                return false;
            if (checkPredicate(nextStructure, predicate))
                return true;
        }
    }
    
    public boolean startSolverExplorationNoIsmBreak(KoratCandidateVector kcv) throws CannotInvokePredicateException, CannotFindPredicateException {
    	stateSpaceExplorer = new SolverStateSpaceExplorer(fin, kcv);
        accessedFields = stateSpaceExplorer.getAccessedFields();

        Object nextStructure = null;
        while (true) {
        	nextStructure = stateSpaceExplorer.nextTestCaseNoIsmBreak();
            if (nextStructure == null)
                return false;
            if (checkPredicate(nextStructure, predicate))
                return true;
        }
    }
    

    protected Method getPredicateMethod(Class<?> testClass, String predicateName)
            throws CannotFindPredicateException {
        try {
            return testClass.getMethod(predicateName, (Class[]) null);
        } catch (Exception e) {
            throw new CannotFindPredicateException(testClass, predicateName, e);
        }
    }

    protected boolean checkPredicate(Object testCase, Method predicate)
            throws CannotInvokePredicateException {
        startFieldTrace();
        try {
            return (Boolean) predicate.invoke(testCase, (Object[]) null);
        } catch (Exception e) {
            throw new CannotInvokePredicateException(testCase.getClass(),
                    predicate.getName(), e.getMessage(), e);
        } finally {
            stopFieldTrace();
        }
    }

}
