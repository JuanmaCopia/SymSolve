package symsolve.symmetrybreak;

import org.junit.jupiter.api.Test;
import symsolve.SymSolve;

import static org.junit.jupiter.api.Assertions.assertEquals;

import symsolve.SymSolve;

public class SolverLinkedListTests {

    private SymSolve symKorat = new SymSolve("symkorat.examples.linkedlist.LinkedList", "5");

    @Test
    public void LinkedListSolverTest0() {
        assertEquals(true, symKorat.isSatisfiable("1,2,-1,1,1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,2,-1,3,-1,-1,3,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSatisfiable("1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSatisfiable("1,2,-1,3,-1,4,-1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSatisfiable("1,2,-1,3,-1,1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,2,-1,3,-1,4,-1,4,3,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,2,-1,3,-1,3,-1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSatisfiable("1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSatisfiable("1,2,-1,3,-1,4,2,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,2,-1,2,1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,2,-1,3,-1,0,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,2,-1,3,-1,3,2,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,2,-1,3,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,2,-1,3,-1,-1,1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSatisfiable("1,2,-1,3,-1,4,-1,-1,3,-1,-1"));
        assertEquals(false, symKorat.isSatisfiable("1,2,-1,3,-1,4,-1,2,3,-1,-1"));
        assertEquals(true, symKorat.isSatisfiable("1,2,-1,1,-1,-1,-1,-1,-1,-1,-1"));
    }

}
