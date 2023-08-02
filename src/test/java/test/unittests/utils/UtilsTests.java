package test.unittests.utils;

import org.junit.jupiter.api.Test;
import symsolve.vector.SymSolveSolution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UtilsTests {

    @Test
    public void testUniqueIdentifier0() {
        int[] a1 = {5, 6, 7};
        int[] a2 = {8, 9};

        int[] result = SymSolveSolution.getUniqueIdentifier(a1, a2);

        int[] expected = {5, 6, 7, -999, 8, 9};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUniqueIdentifier1() {
        int[] a1 = {5, 6, 7};
        int[] a2 = {8, 9, 6};

        int[] result = SymSolveSolution.getUniqueIdentifier(a1, a2);

        int[] expected = {5, 6, 7, -999, 8, 9, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUniqueIdentifier2() {
        int[] a1 = {5, 6, 7};
        int[] a2 = {8, 9, 6, 10};

        int[] result = SymSolveSolution.getUniqueIdentifier(a1, a2);

        int[] expected = {5, 6, 7, -999, 8, 9, 6, 10};
        assertArrayEquals(expected, result);
    }
}
