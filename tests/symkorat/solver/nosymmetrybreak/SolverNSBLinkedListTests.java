package symkorat.solver.nosymmetrybreak;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import symsolve.SymSolve;
import symsolve.explorers.impl.ExplorationStrategy;

public class SolverNSBLinkedListTests {

    private SymSolve symKorat = new SymSolve("symkorat.examples.linkedlist.LinkedList", "5",
            ExplorationStrategy.NO_SYMMETRY_BREAK);

    @Test
    public void LinkedListSolverTest0() {
        assertEquals(true, symKorat.isSat("1,2,-1,1,1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,-1,3,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSat("1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,4,-1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,4,3,-1,-1"));
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,3,-1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSat("1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,4,2,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("1,2,-1,2,1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,0,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,3,2,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,2,-1,-1,-1,-1,-1"));
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,-1,1,-1,-1,-1,-1"));
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,4,-1,-1,3,-1,-1"));
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,2,3,-1,-1"));
        assertEquals(true, symKorat.isSat("1,2,-1,1,-1,-1,-1,-1,-1,-1,-1"));
    }

}
