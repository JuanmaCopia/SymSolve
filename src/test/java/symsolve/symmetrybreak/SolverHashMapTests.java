package symsolve.symmetrybreak;

import org.junit.jupiter.api.Test;
import symsolve.SymSolve;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolverHashMapTests {

    private SymSolve symSolve = new SymSolve("symkorat.examples.hashmap.HashMap", Integer.toString(6));

    @Test
    public void HashMapSolverTest0() {
        assertEquals(false, symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(true,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(true,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
    }

    @Test
    public void HashMapSolverTest1() {
        assertEquals(false, symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(true, symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
    }

    @Test
    public void HashMapSolverTest2() {
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
    }

    @Test
    public void HashMapSolverTest3() {
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
    }

    @Test
    public void HashMapSolverTest4() {
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,3,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
    }

    @Test
    public void HashMapSolverTest5() {
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
    }

    @Test
    public void HashMapSolverTest6() {
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,3,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
    }

    @Test
    public void HashMapSolverTest7() {
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
    }

    @Test
    public void HashMapSolverTest8() {
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,5,-1"));
    }

    @Test
    public void HashMapSolverTest9() {
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,1"));
    }

    @Test
    public void HashMapSolverTest10() {
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,2"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,0"));
        assertEquals(true,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,3"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,3,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,-1,-1"));
    }

    @Test
    public void HashMapSolverTest11() {
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
    }

    @Test
    public void HashMapSolverTest12() {
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
    }

    @Test
    public void HashMapSolverTest13() {
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
    }

    @Test
    public void HashMapSolverTest14() {
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false, symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(true,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,3,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,3,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,0,-1,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
    }

    @Test
    public void HashMapSolverTest15() {
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
    }

    @Test
    public void HashMapSolverTest16() {
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,6"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,2,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,2,-1"));
    }

    @Test
    public void HashMapSolverTest17() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,4"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,-1,-1"));
    }

    @Test
    public void HashMapSolverTest18() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,0,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,4"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,3,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,5"));
    }

    @Test
    public void HashMapSolverTest19() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,5"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,4,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,2,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,3,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,3,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,3"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,-1,-1"));
    }

    @Test
    public void HashMapSolverTest20() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,-1,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,4,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,4,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,2,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,3"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,2,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,3,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,6"));
    }

    @Test
    public void HashMapSolverTest21() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,1,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,-1,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,2,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,3,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,2,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,4,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,2,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,-1,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,0"));
    }

    @Test
    public void HashMapSolverTest22() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,2,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,-1,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,1,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,4,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,2,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,1,4,5,6,0"));
    }

    @Test
    public void HashMapSolverTest23() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,1,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,2,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,2,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,5,2,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,2,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,3,-1"));
    }

    @Test
    public void HashMapSolverTest24() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,-1,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,2,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,1,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,2,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,3,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,1,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,3,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,2,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,4,-1,-1"));
    }

    @Test
    public void HashMapSolverTest25() {
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,-1,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,2,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,2"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,2,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,4,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,0,-1,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,4"));
    }

    @Test
    public void HashMapSolverTest26() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,4,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,5,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,2,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,2,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,3,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,1,-1"));
    }

    @Test
    public void HashMapSolverTest27() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,3"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,4,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,2"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,2,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,2"));
    }

    @Test
    public void HashMapSolverTest28() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,5,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,3"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,4,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,5,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,4"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,-1,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,2,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,1,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,0,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,2,0,-1,-1"));
    }

    @Test
    public void HashMapSolverTest29() {
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,0,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,1,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,0,5"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,0,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,2,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,3,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,3,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,4,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,0,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,3,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,0,3,4,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,-1,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,3"));
    }

    @Test
    public void HashMapSolverTest30() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,3,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,0,3,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,3,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,-1,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,0,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,2,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,3,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,2"));
    }

    @Test
    public void HashMapSolverTest31() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,2,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,1,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,1,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,-1,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,-1,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,0,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,3,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,0,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,2,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,-1,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,4,-1,-1"));
    }

    @Test
    public void HashMapSolverTest32() {
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,0,3,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,0,3,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,5"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,4"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,0,-1,-1,-1"));
    }

    @Test
    public void HashMapSolverTest33() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,3"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,2"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,-1,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,2,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,4,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,6"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,0,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,5"));
    }

    @Test
    public void HashMapSolverTest34() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,2,0,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,2"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,-1,0,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,0,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,1,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,3,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,3,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,4,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,0,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,0,5,6,0"));
    }

    @Test
    public void HashMapSolverTest35() {
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,-1,0,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,0,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,4,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,0,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,0,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,5,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,2,0,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,5,0,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,0,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,0,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,0,6,3"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,-1,-1"));
    }

    @Test
    public void HashMapSolverTest36() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,5,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,2,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,4,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,0,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,0,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,-1,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,0,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,0,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,3,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,5,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,3,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,1,0,0,-1"));
    }

    @Test
    public void HashMapSolverTest37() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,0,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,2,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,4,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,2,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,1,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,0,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,1,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,2,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,-1,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,2,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,0,0"));
    }

    @Test
    public void HashMapSolverTest38() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,5,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,2,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,5,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,5,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,5,6,0,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,6,3,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,4,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,3,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,2,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,3,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,5,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,1,6,0,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,-1,6,0,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,5,0,0,-1"));
    }

    @Test
    public void HashMapSolverTest39() {
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,3,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,3,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,5,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,0,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,5,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,5,6,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,3,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,1,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,1,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,4,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,-1,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,2,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,4,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,5,6,0,0"));
    }

    @Test
    public void HashMapSolverTest40() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,3,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,2,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,-1,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,4,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,1,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,-1,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,1,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,-1,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,5,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,3,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,2,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,4,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,5,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,4,5,0,-1"));
    }

    @Test
    public void HashMapSolverTest41() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,3,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,-1,2,3,4,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,-1,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,5,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,0,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,3,0,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,2,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,1,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,2,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,3,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,1,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,0,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,4,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,2,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,6,0,3"));
    }

    @Test
    public void HashMapSolverTest42() {
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,1,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,0,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,3,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,2,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,0,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,4,5,6,2"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,3"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,2"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,0,4,5,6,0"));
    }

    @Test
    public void HashMapSolverTest43() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,2,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,6"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,1,4,5,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,5,0,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,2,3,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,2,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,5"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,6,2"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,6,0"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,-1,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,2,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,0,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,-1,-1,2,3,4,5,6,0"));
    }

    @Test
    public void HashMapSolverTest44() {
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,-1,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,6,4"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,2,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,0,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,2,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,3,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,4,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,5,6,3"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,0,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,5,3,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,-1,4,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,0,5,6,0"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,1,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,0"));
    }

    @Test
    public void HashMapSolverTest45() {
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,5,2,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,2,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,3,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,0,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,4,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,2,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,2,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,2,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,3,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,-1,0,-1"));
    }

    @Test
    public void HashMapSolverTest46() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,4,5,2,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,0,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,4,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,5,0,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,3,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,2,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,2,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,0,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,4,5,0,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,-1,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,2,3,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,0,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,-1,2,3,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,4,0,-1,-1"));
    }

    @Test
    public void HashMapSolverTest47() {
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,0,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,3,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,1,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,-1,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,1,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,2,4,5,0,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,1,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,-1,4,0,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,-1,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,2,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,0,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,3,0,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,3,4,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,2,-1,-1"));
    }

    @Test
    public void HashMapSolverTest48() {
        assertEquals(false,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,2,-1,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,4,0,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,2,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,0,4,0,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,3,0,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(true, symSolve.isSatisfiable("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
    }

    @Test
    public void HashMapSolverTest49() {
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,2,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,2,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(false, symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(true,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,3,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
        assertEquals(false,
                symSolve.isSatisfiable("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
    }

}
