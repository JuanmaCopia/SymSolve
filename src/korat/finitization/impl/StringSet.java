package korat.finitization.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringSet extends FieldDomain {

    protected List<String> sortedStringList;

    Set<String> stringSet;

    Map<String, Integer> valueIndexMap;

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

    public Map<String, Integer> getValueIndexMap() {
        return valueIndexMap;
    }
    
    public String getString(int index) {
        return sortedStringList.get(index);
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
