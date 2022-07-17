package symsolve;

import org.junit.jupiter.api.Test;
import symsolve.config.SolverConfig;
import symsolve.explorers.impl.SymmetryBreakStrategy;
import symsolve.vector.SymSolveVector;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SymmetryBreakSystemTests {

    @Test
    public void isSatisfiableHashMapTest() {
        SolverConfig config = new SolverConfig("examples.hashmap.HashMap", "2", SymmetryBreakStrategy.SYMMETRY_BREAK);
        SymSolve symSolve = new SymSolve(config);
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 2, -1, -1, 0"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 0, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 2, -1, -1, 2"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 2, -1, -1, 1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 2, -1, -1, 0"));
    }

    @Test
    public void isSatisfiableTreeMapTest() {
        String className = "examples.treemap.TreeMap";
        SolverConfig config = new SolverConfig(className, "5", SymmetryBreakStrategy.SYMMETRY_BREAK);
        SymSolve symSolve = new SymSolve(config);
        assertTrue(symSolve.isSatisfiable("0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 2, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 1, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, 1, -1, 0, 0, 2, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, 0, -1, 0, 0, 2, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 5, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 1, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, 1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, 4, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, 2, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, 1, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 3, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 4, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 2, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 1, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, 1, -1, 0, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, 0, -1, 0, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, 5, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, 5, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 1, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, -1, 3, -1, -1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 0, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 2, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 1, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 0, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 3, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 2, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 0, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 3, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 2, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 1, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 0, 5, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 0, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 0, 1, 1, -1, 5, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 3, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 2, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 0, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 0, 3, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 0, 2, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 0, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 0, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 0, 4, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 0, 4, -1, 1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 0, 4, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 0, 1, 1, -1, 0, 4, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 3, -1, -1, 0, 0, 1, 1, -1, 0, 4, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 2, -1, -1, 0, 0, 1, 1, -1, 0, 4, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 1, -1, -1, 0, 0, 1, 1, -1, 0, 4, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 0, 4, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 0, 1, 1, -1, 0, 5, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 4, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 3, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 2, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, -1, 1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, -1, 1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, -1, 1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, -1, 1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, -1, 1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 4, 1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 3, 1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 2, 1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 4, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 3, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 2, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 3, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 2, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 0, 1, 1, -1, 5, 0, 1, 1, -1, -1, -1, -1, -1, -1, 0, 0, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 1, 1, -1, 5, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 0, 1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, 5, 1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 0, -1, 1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 5, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 5, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 1, 1, -1, 4, 5, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 0, 1, 1, -1, 5, 4, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 0, 1, 1, -1, 4, 5, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 3, -1, -1, 0, 0, 1, 1, -1, 4, 5, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 2, -1, -1, 0, 0, 1, 1, -1, 4, 5, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 1, -1, -1, 0, 0, 1, 1, -1, 4, 5, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 0, 1, 1, -1, 4, 5, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, 1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 0, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, 1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 4, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 5, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 5, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, -1, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 2, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 1, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, 1, -1, 0, 0, 2, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, 0, -1, 0, 0, 2, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 0, 5, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, 2, 1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, -1, -1, -1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 1, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, 1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, 4, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, 2, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, 1, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 3, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 4, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 2, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 1, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 0, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, 1, -1, 0, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, 0, -1, 0, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, 5, 0, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, 5, -1, -1, -1, 0, 0, 2, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 2, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 1, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 3, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 2, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, -1, 3, -1, -1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 0, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 1, 2, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 2, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 2, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 3, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 1, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 0, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 2, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 3, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 1, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, 4, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, 2, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, 3, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, 1, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, 5, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, -1, 4, -1, 0, -1, 0, 0, 1, 1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, -1, 5, -1, 0, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 2, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 3, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 1, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 2, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 3, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 1, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 4, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 4, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 4, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 4, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 2, -1, -1, 4, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 3, -1, -1, 4, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 1, -1, -1, 4, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 4, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 5, 0, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 4, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 4, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, 4, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 4, 4, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 2, 4, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 3, 4, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 1, 4, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, -1, 1, -1, 0, 0, 1, 1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, -1, 1, -1, 0, 0, 1, 1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, -1, 1, -1, 0, 0, 1, 1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, -1, 1, -1, 0, 0, 1, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, -1, 1, -1, 0, 0, 1, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 4, 1, -1, 0, 0, 1, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 2, 1, -1, 0, 0, 1, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 3, 1, -1, 0, 0, 1, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 2, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 3, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 1, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 0, 5, 1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, 0, 0, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 1, 1, -1, 0, 0, 1, 1, -1, 0, 5, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 0, 1, -1, 0, 0, 1, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, 5, 1, -1, 0, 0, 1, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 0, 4, -1, 1, -1, 0, 0, 1, 1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 4, 5, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 4, 5, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, 4, 5, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 4, 5, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 4, -1, -1, 5, 4, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 2, -1, -1, 4, 5, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 3, -1, -1, 4, 5, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, 1, -1, -1, 4, 5, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, 0, -1, -1, 4, 5, -1, 1, -1, 0, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 2, -1, -1, -1, 0, 0, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 1, 2, -1, -1, -1, 0, 0, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 0, 2, -1, -1, -1, 0, 0, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 3, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 3, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 3, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 2, -1, -1, -1, 0, 3, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 1, 2, -1, -1, -1, 0, 3, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 2, -1, -1, -1, 0, 3, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 3, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 0, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 2, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 2, -1, -1, -1, 3, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 1, 2, -1, -1, -1, 3, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 2, -1, -1, -1, 3, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 0, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 0, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 0, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 0, 1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 4, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 5, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 0, 5, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, -1, 2, -1, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 0, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 2, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 0, 2, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 0, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 0, 4, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 4, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 3, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 0, 4, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 0, 3, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 0, 3, 0, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 0, 3, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 4, -1, -1, -1, 0, 0, 3, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 3, -1, -1, -1, 0, 0, 3, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 2, -1, -1, -1, 0, 0, 3, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 1, -1, -1, -1, 0, 0, 3, 1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 0, -1, -1, -1, 0, 0, 3, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, -1, -1, -1, 1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, -1, -1, -1, 0"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 5, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 4, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 3, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 2, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 0, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 0, 5, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 0, 4, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 0, 3, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 0, 2, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 0, 1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, -1, 0, 0, 3, 1, -1, 0, 0, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, 1, -1, 0, 0, 3, 1, -1, 0, 0, -1, -1"));
        assertTrue(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, 0, -1, 0, 0, 3, 1, -1, 0, 0, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 0, 2, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 0, 1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 0, 0, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 0, 5, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 0, 5, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("1, -1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1"));
    }

    @Test
    public void isSatisfiableScheduleTest() {
        String className = "examples.schedule.Schedule";
        SolverConfig config = new SolverConfig(className, "4", SymmetryBreakStrategy.SYMMETRY_BREAK);
        SymSolve symSolve = new SymSolve(config);
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 0, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 0, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 0, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 0, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 3, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, -1, 1, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 0, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 0, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 0, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 0, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 3, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, -1, 1, 2, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 0, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 0, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 0, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 0, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 0, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 0, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertTrue(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 3, 0, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 0, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
        assertFalse(symSolve.isSatisfiable("-1, -1, -1, -1, 1, 2, 3, -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1"));
    }

    @Test
    public void searchAnotherSolutionTreeMapTest() {
        String className = "examples.treemap.TreeMap";
        SolverConfig config = new SolverConfig(className, "5", SymmetryBreakStrategy.SYMMETRY_BREAK);
        SymSolve symSolve = new SymSolve(config);

        int[] concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        List<Integer> fixedInd = Arrays.asList(0, 3, 8);
        Set<Integer> fixedIndices = new HashSet<>(fixedInd);
        SymSolveVector queryVector = new SymSolveVector(concreteVector, fixedIndices);
        int[] solutionVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 2, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 2, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 5, 3, 2, 4, 0, 1, 1, 3, 5, 1, 0, 0, 0, 0, 2, 1, 4, 0, 0, 1, 1, 2, 0, 0, 2, 1};
        fixedInd = Arrays.asList(0, 16, 3, 8, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 5, 3, 2, 5, 0, 1, 1, 3, 4, 1, 0, 0, 0, 0, 2, 1, 2, 0, 0, 2, 1, 4, 0, 0, 1, 1};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 5, 3, 2, 5, 0, 1, 1, 3, 4, 1, 0, 0, 0, 0, 2, 1, 2, 0, 0, 2, 1, 4, 0, 0, 1, 1};
        fixedInd = Arrays.asList(0, 16, 3, 8, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 16, 3, 8, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 16, 3, 8, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 16, 3, 8, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 2, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 2, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 9, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 9, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 9, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 2, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 9, 10, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 9, 10, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 3, 2, 4, 0, 1, 1, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 8, 9, 10, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 2, 3, 0, 1, 1, 0, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 3, 0, 1, 1, 4, 0, 1, 1, 3, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 19, 4, 20, 8, 9, 10);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 2, 2, 3, 0, 1, 1, 4, 0, 1, 1, 4, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 3, 0, 1, 1, 4, 0, 1, 1, 4, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 19, 4, 20, 8, 9, 10);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 3, 0, 1, 1, 4, 0, 1, 1, 4, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 3, 2, 3, 0, 1, 1, 4, 0, 1, 1, 4, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 19, 4, 20, 8, 9, 10);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 3, 0, 1, 2, 4, 0, 1, 1, 4, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 5, 3, 2, 5, 0, 1, 1, 3, 4, 1, 0, 0, 0, 0, 2, 1, 2, 0, 0, 2, 1, 4, 0, 0, 1, 1};
        fixedInd = Arrays.asList(0, 3, 8, 9, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 5, 3, 2, 5, 0, 1, 1, 3, 4, 1, 1, 0, 0, 0, 2, 0, 2, 0, 0, 2, 0, 4, 0, 0, 1, 1};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 5, 3, 2, 5, 0, 1, 1, 3, 4, 1, 1, 0, 0, 0, 2, 0, 2, 0, 0, 2, 0, 4, 0, 0, 1, 1};
        fixedInd = Arrays.asList(0, 3, 8, 9, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 2, 1, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 2, 2, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 2, 1, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 9);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 2, 2, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 1, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 9, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 1, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 1, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 9, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 1, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 1, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 9, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 3, 2, 2, 3, 0, 1, 0, 0, 0, 1, 1, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 2, 1, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 9, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 2, 2, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 2, 1, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 9, 10, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 2, 2, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 2, 1, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 4, 9, 10, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 2, 2, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 2, 1, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 4, 5, 9, 10, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 2, 2, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 4, 9, 10, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 4, 9, 10, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 4, 9, 10, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 3, 2, 2, 3, 0, 1, 0, 0, 0, 1, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 16, 3, 4, 9, 10, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 16, 3, 4, 9, 10, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 3, 1, 2, 3, 0, 1, 0, 0, 0, 1, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 16, 3, 4, 9, 10, 11);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 3, 2, 2, 3, 0, 1, 0, 0, 0, 1, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 0, 0, 3, 1, 1, 1, 0, 0, 2, 0, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 9);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 2, 2, 4, 0, 1, 0, 0, 3, 1, 1, 1, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 2, 2, 4, 0, 1, 0, 0, 3, 1, 1, 1, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 9);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 0, 0, 3, 1, 1, 1, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 3, 2, 4, 0, 1, 0, 0, 3, 1, 1, 1, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 3, 9);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 3, 2, 4, 0, 1, 0, 0, 3, 1, 1, 2, 0, 0, 2, 0, 4, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 5, 1, 5, 2, 0, 1, 3, 3, 4, 1, 0, 2, 0, 0, 2, 1, 4, 0, 0, 2, 1, 0, 0, 0, 1, 1};
        fixedInd = Arrays.asList(0, 16, 4, 8, 13);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 1, 4, 2, 0, 1, 3, 3, 0, 1, 1, 2, 0, 0, 2, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 16, 4, 8, 13);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 1, 4, 2, 0, 1, 4, 3, 0, 1, 1, 2, 0, 0, 2, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 1, 4, 2, 0, 1, 2, 0, 3, 1, 1, 3, 0, 0, 2, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 4, 8, 9, 10, 13, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 1, 4, 2, 0, 1, 2, 0, 3, 1, 1, 4, 0, 0, 2, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 4, 1, 2, 3, 0, 1, 0, 0, 0, 1, 1, 2, 0, 4, 1, 1, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(0, 18, 3, 4, 20, 13, 14, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 4, 1, 2, 3, 0, 1, 0, 0, 0, 1, 1, 2, 0, 4, 1, 1, 4, 0, 0, 3, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 5, 1, 5, 2, 0, 1, 3, 3, 4, 1, 0, 2, 0, 0, 2, 1, 4, 0, 0, 2, 1, 0, 0, 0, 1, 1};
        fixedInd = Arrays.asList(0, 18, 4, 20, 8, 9);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 5, 1, 5, 2, 0, 1, 3, 3, 4, 1, 1, 2, 0, 0, 2, 0, 4, 0, 0, 2, 0, 0, 0, 0, 1, 1};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 5, 1, 5, 2, 0, 1, 3, 3, 4, 1, 1, 2, 0, 0, 2, 0, 4, 0, 0, 2, 0, 0, 0, 0, 1, 1};
        fixedInd = Arrays.asList(0, 18, 4, 20, 8, 9);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));

    }

    @Test
    public void searchAnotherSolutionHashMapTest() {
        SolverConfig config = new SolverConfig("examples.hashmap.HashMap", "2", SymmetryBreakStrategy.SYMMETRY_BREAK);
        SymSolve symSolve = new SymSolve(config);

        int[] concreteVector = new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Integer> fixedInd = Arrays.asList(1, 19);
        Set<Integer> fixedIndices = new HashSet<>(fixedInd);
        SymSolveVector queryVector = new SymSolveVector(concreteVector, fixedIndices);
        int[] solutionVector = new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 16, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 16, 0, 0, 0, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 15, 15, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 15, 15, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 31, 31, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 31, 31, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 16, 16, 0, 15, 15, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 16, 16, 0, 15, 15, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 16, 16, 0, 31, 31, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 16, 16, 0, 31, 31, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 14, 14, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 14, 14, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 30, 30, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 30, 30, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 16, 16, 0, 14, 14, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 16, 16, 0, 13, 13, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 16, 16, 0, 29, 29, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 16, 16, 0, 29, 29, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 12, 12, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 12, 12, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 28, 28, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 28, 28, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 16, 16, 0, 12, 12, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 16, 16, 0, 12, 12, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 16, 16, 0, 28, 28, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 16, 16, 0, 28, 28, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 11, 11, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 11, 11, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 27, 27, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 27, 27, 0};
        fixedInd = Arrays.asList(1, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 16, 16, 0, 11, 11, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 5, 5, 0};
        fixedInd = Arrays.asList(2, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 21, 21, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 21, 21, 0};
        fixedInd = Arrays.asList(2, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 17, 0, 5, 5, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 17, 0, 5, 5, 0};
        fixedInd = Arrays.asList(2, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 17, 0, 21, 21, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 19, 0, 2, 2, 0};
        fixedInd = Arrays.asList(19, 4);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 18, 18, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 18, 18, 0};
        fixedInd = Arrays.asList(19, 4);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 19, 0, 18, 18, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 21, 21, 0, 11, 11, 0};
        fixedInd = Arrays.asList(19, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 21, 21, 0, 27, 27, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 21, 21, 0, 27, 27, 0};
        fixedInd = Arrays.asList(19, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 5, 0, 10, 10, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 5, 0, 10, 10, 0};
        fixedInd = Arrays.asList(19, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 5, 0, 26, 26, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 20, 20, 0};
        fixedInd = Arrays.asList(19, 7);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 0, 20, 20, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 0, 20, 20, 0};
        fixedInd = Arrays.asList(19, 7);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 3, 3, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 3, 3, 0};
        fixedInd = Arrays.asList(19, 7);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 0, 3, 3, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 0, 3, 3, 0};
        fixedInd = Arrays.asList(19, 7);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 19, 19, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 8, 8, 0, 9, 9, 0};
        fixedInd = Arrays.asList(19, 9);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 8, 8, 0, 25, 25, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 8, 8, 0, 25, 25, 0};
        fixedInd = Arrays.asList(19, 9);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 24, 24, 0, 9, 9, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 24, 24, 0, 9, 9, 0};
        fixedInd = Arrays.asList(19, 9);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 24, 24, 0, 25, 25, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 25, 25, 0, 17, 17, 0};
        fixedInd = Arrays.asList(19, 10);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9, 9, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9, 9, 0, 0, 0, 0};
        fixedInd = Arrays.asList(19, 10);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 25, 25, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 25, 25, 0, 0, 0, 0};
        fixedInd = Arrays.asList(19, 10);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 9, 9, 0, 16, 16, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 11, 11, 0, 12, 12, 0};
        fixedInd = Arrays.asList(19, 12);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 11, 11, 0, 28, 28, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 11, 11, 0, 28, 28, 0};
        fixedInd = Arrays.asList(19, 12);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 27, 27, 0, 12, 12, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 27, 27, 0, 12, 12, 0};
        fixedInd = Arrays.asList(19, 12);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 27, 27, 0, 28, 28, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 12, 12, 0, 13, 13, 0};
        fixedInd = Arrays.asList(19, 13);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 12, 12, 0, 29, 29, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 12, 12, 0, 29, 29, 0};
        fixedInd = Arrays.asList(19, 13);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 28, 28, 0, 13, 13, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 28, 28, 0, 13, 13, 0};
        fixedInd = Arrays.asList(19, 13);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 28, 28, 0, 29, 29, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 29, 29, 0, 14, 14, 0};
        fixedInd = Arrays.asList(19, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 29, 29, 0, 30, 30, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 29, 29, 0, 30, 30, 0};
        fixedInd = Arrays.asList(19, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 13, 13, 0, 12, 12, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 13, 13, 0, 12, 12, 0};
        fixedInd = Arrays.asList(19, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 29, 29, 0, 12, 12, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 29, 29, 0, 12, 12, 0};
        fixedInd = Arrays.asList(19, 14);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 13, 13, 0, 28, 28, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 30, 30, 0, 12, 12, 0};
        fixedInd = Arrays.asList(19, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 14, 14, 0, 28, 28, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 14, 14, 0, 28, 28, 0};
        fixedInd = Arrays.asList(19, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 30, 30, 0, 28, 28, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 30, 30, 0, 28, 28, 0};
        fixedInd = Arrays.asList(19, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 14, 14, 0, 11, 11, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 14, 14, 0, 11, 11, 0};
        fixedInd = Arrays.asList(19, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 30, 30, 0, 11, 11, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 30, 30, 2, 14, 14, 0};
        fixedInd = Arrays.asList(19, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 14, 14, 2, 30, 30, 0};
        fixedInd = Arrays.asList(19, 22, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 30, 30, 2, 14, 14, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 30, 30, 2, 14, 14, 0};
        fixedInd = Arrays.asList(19, 22, 15);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 0, 0, 0, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 0, 0, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 15, 15, 0, 14, 14, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 18, 18, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 0, 1, 1, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 0, 1, 1, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 1, 1, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 1, 1, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 0, 17, 17, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 0, 17, 17, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 17, 17, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 17, 17, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 0, 0, 0, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 0, 0, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 0, 16, 16, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 0, 16, 16, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 16, 16, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 0, 16, 16, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 2, 31, 31, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 2, 15, 15, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 2, 15, 15, 0};
        fixedInd = Arrays.asList(16, 19);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 15, 15, 2, 31, 31, 0};
        fixedInd = Arrays.asList(16, 19, 22);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 2, 15, 15, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 31, 31, 2, 15, 15, 0};
        fixedInd = Arrays.asList(16, 19, 22);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));
    }

    @Test
    public void searchAnotherSolutionScheduleTest() {
        String className = "examples.schedule.Schedule";
        SolverConfig config = new SolverConfig(className, "2", SymmetryBreakStrategy.SYMMETRY_BREAK);
        SymSolve symSolve = new SymSolve(config);

        int[] concreteVector = new int[]{0, 0, 0, 0, 3, 4, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Integer> fixedInd = Arrays.asList(6);
        Set<Integer> fixedIndices = new HashSet<>(fixedInd);
        SymSolveVector queryVector = new SymSolveVector(concreteVector, fixedIndices);
        int[] solutionVector = new int[]{1, 1, 0, 0, 3, 4, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 1, 0, 0, 3, 4, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 3, 4, 1, 2, 2, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 3, 4, 1, 2, 2, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 3, 4, 1, 2, 2, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 3, 4, 1, 2, 0, 2, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 2, 1, 0, 0, 0};
        fixedInd = Arrays.asList(17, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 3, 4, 1, 2, 0, 2, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2, 2, 1, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 2, 4, 1, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 0, 0, 0};
        fixedInd = Arrays.asList(17, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 2, 4, 1, 3, 0, 0, 0, 1, 0, 0, 1, 2, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 2};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 2, 4, 1, 3, 0, 0, 0, 1, 0, 0, 1, 2, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 2};
        fixedInd = Arrays.asList(17, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 2, 4, 1, 3, 0, 0, 1, 1, 0, 0, 0, 2, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 2};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 3, 2, 1, 4, 2, 0, 0, 2, 0, 1, 1, 2, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(17, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 3, 2, 1, 4, 2, 0, 1, 2, 0, 1, 0, 2, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 3, 2, 1, 4, 2, 0, 1, 2, 0, 1, 0, 2, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(17, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 3, 2, 1, 4, 0, 2, 1, 2, 1, 0, 0, 2, 0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{0, 0, 0, 0, 3, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(17, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 1, 0, 0, 3, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 1, 0, 0, 3, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1};
        fixedInd = Arrays.asList(17, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 3, 1, 2, 4, 2, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 2};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 2, 0, 0, 3, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 2, 0, 0, 3, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 2, 0, 1, 3, 0, 1, 0, 3, 0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 2, 0, 1, 3, 0, 1, 0, 3, 0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 2, 1, 3, 1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 2, 2, 1, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 2, 1, 3, 1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 2, 2, 1, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 2, 0, 3, 1, 0, 1, 3, 0, 0, 0, 0, 0, 0, 2, 2, 1, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 2, 0, 3, 1, 0, 1, 3, 0, 0, 0, 0, 0, 0, 2, 2, 1, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 1, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 1, 2, 2, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 1, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 1, 2, 2, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 1, 1};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 1, 1};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 1, 1};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 1, 1};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 1, 0, 0, 1, 2, 3, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 1, 0, 0, 1, 2, 3, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 2};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 2};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 2};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 2};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 2, 0, 0, 1, 3, 0, 0, 0, 1, 1, 1, 1, 2, 2, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 2, 0, 0, 1, 3, 0, 0, 0, 1, 1, 1, 1, 2, 2, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 2, 0, 0, 0, 3, 0, 0, 0, 1, 1, 1, 1, 2, 2, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 2, 0, 0, 0, 3, 0, 0, 0, 1, 1, 1, 1, 2, 2, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 2, 0, 0, 2, 0, 1, 1, 2, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 2, 0, 0, 2, 0, 1, 1, 2, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 2, 0, 1, 2, 0, 1, 0, 2, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 2, 0, 1, 2, 0, 1, 0, 2, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 2, 1, 2, 1, 0, 0, 2, 0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 2, 1, 2, 1, 0, 0, 2, 0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 2, 0, 2, 1, 0, 1, 2, 0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 2, 0, 2, 1, 0, 1, 2, 0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{1, 1, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{1, 1, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 1, 2, 2, 0, 0, 0, 1, 1, 1};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 1, 2, 2, 0, 0, 0, 1, 1, 1};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 1, 2, 2, 0, 0, 0, 1, 1, 1};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 1, 2, 2, 0, 0, 0, 1, 1, 1};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 3, 0, 0, 0, 2, 0, 0, 0, 1, 2, 2, 1, 1, 1, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 1, 3, 0, 0, 0, 2, 0, 0, 0, 1, 2, 2, 1, 1, 1, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 3, 0, 0, 1, 2, 0, 0, 0, 1, 2, 2, 1, 1, 1, 0, 0, 0};
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));


        concreteVector = new int[]{2, 2, 0, 0, 1, 2, 3, 4, 0, 0, 0, 3, 0, 0, 1, 2, 0, 0, 0, 1, 2, 2, 1, 1, 1, 0, 0, 0};
        fixedInd = Arrays.asList(17, 4, 5, 6);
        fixedIndices = new HashSet<>(fixedInd);
        queryVector = new SymSolveVector(concreteVector, fixedIndices);
        solutionVector = null;
        assertArrayEquals(solutionVector, symSolve.searchAnotherSolution(queryVector));

    }
}
