package eval.executor;

import java.lang.reflect.Method;

import korat.testing.impl.CannotFindPredicateException;
import korat.testing.impl.CannotInvokePredicateException;
import symsolve.utils.Helper;

public class PredicateExecutor {

    Class<?> predicateClass;
    Method predicate;

    public void initialize(Class<?> predicateClass, String predicateName) throws CannotFindPredicateException {
        this.predicateClass = predicateClass;
        setPredicate(predicateName);
    }

    public void setPredicate(String predicateName) throws CannotFindPredicateException {
        predicate = Helper.loadMethod(predicateClass, predicateName);
    }

    public boolean executePredicate(Object structure) throws CannotInvokePredicateException {
        assert (predicate != null);
        Object[] args = new Object[1];
        args[0] = structure;
        try {
            return (Boolean) predicate.invoke(null, args);
        } catch (Exception e) {
            throw new CannotInvokePredicateException(predicateClass, predicate.getName(), e.getMessage(), e);
        }
    }


}
