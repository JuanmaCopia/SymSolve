package korat.finitization.impl;

import korat.finitization.*;
import korat.loading.InstrumentingClassLoader;
import korat.utils.RandomStrings;

import java.util.*;


public class Finitization implements IFinitization {

    protected static ClassLoader classLoader = new InstrumentingClassLoader();
    private final Class<?> rootClass;
    private final Map<Class<?>, Map<String, IFieldDomain>> clsDomainsMap = new HashMap<>();
    private final Set<ObjSet> objSets = new LinkedHashSet<>();
    private final List<CVElem> vectorDescriptor = new ArrayList<>();
    private final StateSpace stateSpace = new StateSpace();
    private final Map<String, IntSet> integerFieldsMinMax = new HashMap<String, IntSet>();
    boolean isInitialized = false;
    ObjSet rootObjSet;


    public Finitization(Class<?> rootClass) {
        this.rootClass = rootClass;
        rootObjSet = new ObjSet(rootClass, 1, false);
        objSets.add(rootObjSet);
        clsDomainsMap.put(rootClass, new LinkedHashMap<>());
    }

    public static ClassLoader getClassLoader() {
        return classLoader;
    }

    public static void setClassLoader(ClassLoader classLoader2) {
        classLoader = classLoader2;
    }

    private String createFieldName(Class<?> cls, String fieldName) {
        return cls.getSimpleName() + "." + fieldName;
    }

    public int[] getInitialCandidateVector() {

        int size = getStateSpace().getTotalNumberOfFields();
        return new int[size];

    }

    public StateSpace getStateSpace() {
        if (!isInitialized)
            initialize();
        return stateSpace;
    }

    private void initialize() {
        addObjectsToVectorDescriptor();
        createStateSpace();
        isInitialized = true;
    }

    private void createStateSpace() {
        stateSpace.setStructureList(vectorDescriptor.toArray(new CVElem[0]));
        Object rootObject = rootObjSet.getFirstObject();
        stateSpace.setRootObject(rootObject);
        stateSpace.initialize();
    }

    @Override
    public Class<?> getFinClass() {
        return rootClass;
    }

    public IIntSet createIntSet(int min, int diff, int max) {
        return new IntSet(min, diff, max);
    }

    public IIntSet createIntSet(int min, int max) {
        return new IntSet(min, max);
    }

    public IIntSet createIntSet(int singleValue) {
        return new IntSet(singleValue);
    }

    public IBooleanSet createBooleanSet() {
        return new BooleanSet();
    }

    public IByteSet createByteSet(byte min, byte diff, byte max) {
        return new ByteSet(min, diff, max);
    }

    public IByteSet createByteSet(byte min, byte max) {
        return new ByteSet(min, max);
    }

    public IByteSet createByteSet(byte singleValue) {
        return new ByteSet(singleValue);
    }

    public IShortSet createShortSet(short min, short diff, short max) {
        return new ShortSet(min, diff, max);
    }

    public IShortSet createShortSet(short min, short max) {
        return new ShortSet(min, max);
    }

    public IShortSet createShortSet(short singleValue) {
        return new ShortSet(singleValue);
    }

    public ILongSet createLongSet(long min, long diff, long max) {
        return new LongSet(min, diff, max);
    }

    public ILongSet createLongSet(long min, long max) {
        return new LongSet(min, max);
    }

    public ILongSet createLongSet(long singleValue) {
        return new LongSet(singleValue);
    }

    public IDoubleSet createDoubleSet(double min, double diff, double max) {
        return new DoubleSet(min, diff, max);
    }

    public IDoubleSet createDoubleSet(double min, double max) {
        return new DoubleSet(min, max);
    }

    public IDoubleSet createDoubleSet(double singleValue) {
        return new DoubleSet(singleValue);
    }

    public IFloatSet createFloatSet(float min, float diff, float max) {
        return new FloatSet(min, diff, max);
    }

    public IFloatSet createFloatSet(float min, float max) {
        return new FloatSet(min, max);
    }

    public IFloatSet createFloatSet(float singleValue) {
        return new FloatSet(singleValue);
    }

    public StringSet createRandomStringSet(int setSize, int minLength, int maxLength) {
        return new StringSet(RandomStrings.generateRandomStringSet(setSize, minLength, maxLength));
    }

    @Override
    public IObjSet createObjSet(Class<?> fieldBaseClass, int numOfInstances, boolean includeNull) {
        return new ObjSet(fieldBaseClass, numOfInstances, includeNull);
    }

    public void set(Class<?> cls, String fieldName, IFieldDomain fieldDomain) {
        if (!clsDomainsMap.containsKey(cls))
            clsDomainsMap.put(cls, new LinkedHashMap<>());

        Map<String, IFieldDomain> fieldsMap = clsDomainsMap.get(cls);

        fieldsMap.put(fieldName, fieldDomain);

        if (fieldDomain instanceof IntSet) {
            this.integerFieldsMinMax.put(createFieldName(cls, fieldName), (IntSet) fieldDomain);
        } else if (fieldDomain instanceof ObjSet) {
            objSets.add((ObjSet) fieldDomain);
        }
    }

    public IFieldDomain getFieldDomain(Class<?> cls, String fieldName) {
        Map<String, IFieldDomain> fieldsMap = clsDomainsMap.get(cls);
        if (fieldsMap == null)
            return null;
        return fieldsMap.get(fieldName);
    }

    public Map<String, IntSet> getIntegerFieldsMinMaxMap() {
        return this.integerFieldsMinMax;
    }

    private void addObjectsToVectorDescriptor() {
        for (ObjSet objectSet : objSets) {
            for (Object obj : objectSet.getObjects()) {
                addFieldsToVectorDescriptor(obj);
            }
        }
    }

    private void addFieldsToVectorDescriptor(Object obj) {
        Class<?> cls = obj.getClass();
        Map<String, IFieldDomain> fieldsMap = clsDomainsMap.get(cls);
        if (fieldsMap != null) {
            for (Map.Entry<String, IFieldDomain> e : fieldsMap.entrySet()) {
                String fieldName = e.getKey();
                IFieldDomain fd = e.getValue();
                System.out.println("\nFieldDomain class: " + fd.getClass());
                FieldDomain fieldDomain = (FieldDomain) e.getValue();
                CVElem elem = new CVElem(obj, fieldName, fieldDomain, stateSpace);
                vectorDescriptor.add(elem);
            }
        }
    }


    /*public StringSet createRandomStringSet(int setSize, int minLength, int maxLength) {
        return new StringSet(RandomStrings.generateRandomStringSet(setSize, minLength, maxLength));
    }

    public StringSet createStringSet(Set<String> set) {
        return new StringSet(set);
    }

    public Set<Class<?>> getClasses() {
        return classDomains.keySet();
    }

    public List<String> getFieldNames(Class<?> cls) {
        Map<String, IFieldDomain> fieldDomains = clsDomainsMap.get(cls);
        Set<String> fieldNames = fieldDomains.keySet();
        return new ArrayList<String>(fieldNames);
    }*/


}
