package korat.utils;

public class IntListAI implements IIntList {

    int[] elems;
    int[] cvelems;
    int lastElementIndex = -1;
    int cnt;
    int maxSize;

    public IntListAI(int size) {
        maxSize = size;
        elems = new int[maxSize];
        cvelems = new int[maxSize];
        cnt = 1;
    }

    public IntListAI(IntListAI other) {
        maxSize = other.maxSize;
        elems = other.elems.clone();
        cvelems = other.cvelems.clone();
        cnt = other.cnt;
        lastElementIndex = other.lastElementIndex;
    }

    public int getMaxSize() {
        return maxSize;
    }


    public int numberOfElements() {
        return lastElementIndex + 1;
    }

    public boolean isEmpty() {
        return lastElementIndex == -1;
    }

    public boolean contains(int elem) {
        return cvelems[elem] == cnt;
    }

    public int[] toArray() {
        int size = lastElementIndex + 1;
        int[] ret = new int[size];
        System.arraycopy(elems, 0, ret, 0, size);
        return ret;
    }

    public boolean add(int elem) {
        if (cvelems[elem] == cnt) // if contains the element
            return false;

        elems[++lastElementIndex] = elem;
        cvelems[elem] = cnt;

        return true;
    }

    public int removeLast() {
        int ret = elems[lastElementIndex--];
        cvelems[ret] = -1;
        return ret;
    }

    public void clear() {
        cnt++;
        //it is ok to overflow.
        if (cnt == -1) {
            cvelems = new int[cvelems.length];
            cnt = 1;
        }
        lastElementIndex = -1;
    }

    public IntListAI clone() {
        return new IntListAI(this);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        int size = numberOfElements();
        for (int i = 0; i < size - 1; i++)
            sb.append(elems[i]).append(", ");
        sb.append(elems[size - 1]).append("]");

        return sb.toString();
    }

}
