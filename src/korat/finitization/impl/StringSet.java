package korat.finitization.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class StringSet extends FieldDomain {

    protected List<String> sortedStringList;

    Set<String> stringSet;

    Map<String, Integer> valueIndexMap;

    StringSet(int setSize, int minLength, int maxLength) {
        this(generateRandomStringSet(setSize, minLength, maxLength));
    }

    StringSet(Set<String> stringSet) {
        super(String.class);
        this.stringSet = stringSet;
        this.valueIndexMap = new HashMap<String, Integer>();
        this.sortedStringList = new ArrayList<String>(stringSet);
        initialize();
    }

    private void initialize() {
        Collections.sort(this.sortedStringList);
        for (int i = 0; i < this.sortedStringList.size(); i++)
            valueIndexMap.put(this.sortedStringList.get(i), i);
    }

    private static Set<String> generateRandomStringSet(int setSize, int minLength, int maxLength) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < setSize; i++)
            addRandomStringToSet(set, minLength, maxLength);
        assert (setSize == set.size());
        return set;
    }

    private static void addRandomStringToSet(Set<String> set, int minLength, int maxLength) {
        Random r = new Random();
        int length = r.nextInt((maxLength - minLength) + 1) + minLength;
        String elem = generateRandomString(length);
        while (set.contains(elem))
            elem = generateRandomString(length);
        set.add(elem);
    }

    private static String generateRandomString(int stringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1).limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return generatedString;
    }

    public Map<String, Integer> getValueIndexMap() {
        return valueIndexMap;
    }

    @Override
    public boolean isPrimitiveType() {
        return true;
    }

    @Override
    public boolean isArrayType() {
        return false;
    }

    @Override
    public int getClassDomainIndexFor(int objectIndex) {
        if (!checkObjectIndex(objectIndex))
            return -1;

        return objectIndex;
    }

    @Override
    public int getIndexOfFirstObjectInNextClassDomain(int objectIndex) {
        return -1;
    }

    @Override
    public int getNumOfClassDomains() {
        return 1;
    }

    public int getSizeOfClassDomain(int classDomainIndex) {
        if (!checkClassDomainIndex(classDomainIndex))
            return -1;

        return getNumberOfElements();
    }

    @Override
    public int getNumberOfElements() {
        return sortedStringList.size();
    }

    @Override
    public ClassDomain getClassDomain(int classDomainIndex) {
        return null;
    }

    @Override
    public ClassDomain getClassDomainFor(int objectIndex) {
        return null;
    }

    @Override
    public ClassDomain getNextClassDomainFor(int objectIndex) {
        return null;
    }

}
