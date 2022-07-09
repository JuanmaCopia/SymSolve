package korat.finitization.impl;

import korat.finitization.IClassDomain;
import korat.finitization.IObjSet;
import korat.testing.ITester;
import symsolve.PredicateChecker;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

public class ObjSet2 extends FieldDomain implements IObjSet {

    Class<?> classOfField;
    int numOfObjects;
    Object[] fieldDomainValues;
    List<Object> objects = new LinkedList<>();
    boolean includesNull;


    public ObjSet2(Class<?> classOfField, int numOfObjects, boolean includesNull) {
        super(classOfField);
        this.classOfField = classOfField;
        this.includesNull = includesNull;
        this.numOfObjects = numOfObjects;
        initializeFieldDomain();
    }

    private void initializeFieldDomain() {
        allocateObjects();
        setUpFieldDomain();
    }

    private void allocateObjects() {
        ITester tester = PredicateChecker.getInstance();

        for (int i = 0; i < numOfObjects; i++) {
            Object obj;
            try {
                Constructor<?> constructor = classOfField.getConstructor(ITester.class);
                obj = constructor.newInstance(tester);
                objects.add(obj);
            } catch (Exception e) {
                String msg = "{0}: object of class {1} cannot be created";
                msg = MessageFormat.format(msg, e.getMessage(), classOfField.getName());
                System.out.println(msg);
                e.printStackTrace();
                throw new RuntimeException(msg, e);
            }
        }
    }

    private void setUpFieldDomain() {
        if (includesNull) {
            LinkedList<Object> objectsCopy = new LinkedList<>(objects);
            objectsCopy.addFirst(null);
            fieldDomainValues = objectsCopy.toArray();
        } else {
            fieldDomainValues = objects.toArray();
        }
    }

    public List<Object> getObjects() {
        return objects;
    }

    public Object getObject(int index) {
        return fieldDomainValues[index];
        /*return objects.get(index);*/
    }

    public Object getFirstObject() {
        if (includesNull)
            return objects.get(1);
        return objects.get(0);
    }

    @Override
    public boolean addClassDomain(IClassDomain domain) {
        assert (false);
        return false;
    }

    @Override
    public boolean removeClassDomain(IClassDomain domain) {
        assert (false);
        return false;
    }

    @Override
    public IClassDomain removeClassDomain(int index) {
        assert (false);
        return null;
    }

    @Override
    public List<IClassDomain> getClassDomains() {
        assert (false);
        return null;
    }

    @Override
    public Object[] getAllObjects() {
        assert (false);
        return objects.toArray();
    }

    @Override
    public Object[] getObjectsOfClass(Class<?> cls) {
        assert (false);
        return objects.toArray();
    }

    @Override
    public Class<?> getClassOfField() {
        return classOfField;
    }

    @Override
    public int getClassDomainIndexFor(int objectIndex) {
        assert (false);
        return 0;
    }

    @Override
    public int getIndexOfFirstObjectInNextClassDomain(int objectIndex) {
        assert (false);
        return 0;
    }

    @Override
    public int getNumOfClassDomains() {
        assert (false);
        return 1;
    }

    @Override
    public int getSizeOfClassDomain(int classDomainIndex) {
        assert (false);
        return 0;
    }

    @Override
    public int getNumberOfElements() {
        return fieldDomainValues.length;
    }

    @Override
    public ClassDomain getClassDomain(int classDomainIndex) {
        assert (false);
        return null;
    }

    @Override
    public ClassDomain getClassDomainFor(int objectIndex) {
        assert (false);
        return null;
    }

    @Override
    public ClassDomain getNextClassDomainFor(int objectIndex) {
        assert (false);
        return null;
    }

    @Override
    public boolean isPrimitiveType() {
        return false;
    }

    @Override
    public boolean isArrayType() {
        return false;
    }

    @Override
    public void setNullAllowed(boolean allowed) {
        assert (false);
    }

    @Override
    public boolean isNullAllowed() {
        return includesNull;
    }

}