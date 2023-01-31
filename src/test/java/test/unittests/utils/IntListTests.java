package test.unittests.utils;

import korat.utils.IntListAI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntListTests {

    @Test
    public void testAdd() {
        IntListAI set = new IntListAI(10);
        assertTrue(set.add(5));
        assertFalse(set.add(5));
        assertTrue(set.add(3));
        assertTrue(set.add(7));
        assertEquals("[5, 3, 7]", set.toString());
    }

    @Test
    public void testRemoveLast() {
        IntListAI set = new IntListAI(10);
        set.add(5);
        set.add(3);
        set.add(7);
        assertEquals(7, set.removeLast());
        assertEquals(2, set.numberOfElements());
        assertEquals("[5, 3]", set.toString());
    }

    @Test
    public void testContains() {
        IntListAI set = new IntListAI(10);
        set.add(5);
        set.add(3);
        set.add(7);
        assertTrue(set.contains(5));
        assertTrue(set.contains(3));
        assertTrue(set.contains(7));
        assertFalse(set.contains(8));
    }

    @Test
    public void testIsEmpty() {
        IntListAI set = new IntListAI(10);
        assertTrue(set.isEmpty());
        set.add(5);
        assertFalse(set.isEmpty());
        set.removeLast();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testNumberOfElements() {
        IntListAI set = new IntListAI(10);
        assertEquals(0, set.numberOfElements());
        set.add(5);
        set.add(3);
        set.add(7);
        assertEquals(3, set.numberOfElements());
    }

    @Test
    public void testToArray() {
        IntListAI set = new IntListAI(10);
        set.add(5);
        set.add(3);
        set.add(7);
        int[] expected = {5, 3, 7};
        assertArrayEquals(expected, set.toArray());
    }

    @Test
    public void testClear() {
        IntListAI set = new IntListAI(10);
        set.add(5);
        set.add(3);
        set.add(7);
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.numberOfElements());
        assertFalse(set.contains(5));
        assertFalse(set.contains(3));
        assertFalse(set.contains(7));
    }
    
}
