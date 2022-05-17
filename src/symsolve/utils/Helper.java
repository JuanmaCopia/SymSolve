package symsolve.utils;

import java.lang.reflect.Method;

import korat.finitization.IFinitization;
import korat.testing.impl.CannotFindFinitizationException;
import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokeFinitizationException;

public class Helper {

    public static IFinitization invokeFinMethod(Class<?> cls, Method finitize, String[] finArgs)
            throws CannotInvokeFinitizationException {

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

    public static Method getPredicateMethod(Class<?> testClass, String predicateName)
            throws CannotFindPredicateException {
        try {
            return testClass.getMethod(predicateName, (Class[]) null);
        } catch (Exception e) {
            throw new CannotFindPredicateException(testClass, predicateName, e);
        }
    }
    
    
    public static Method getFinMethod(Class<?> cls, String finName, String[] finArgs) throws CannotFindFinitizationException {
        Method finitize = null;
        for (Method m : cls.getDeclaredMethods()) {
            if (finName.equals(m.getName()) && m.getParameterTypes().length == finArgs.length) {
                finitize = m;
                break;
            }
        }
        if (finitize == null) {
            throw new CannotFindFinitizationException(cls, finName);
        }
        return finitize;
    }

}
