package symkorat.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import symkorat.SymKorat;

public class SolverLinkedListTests {
	
	private SymKorat symKorat = new SymKorat("symkorat.examples.linkedlist.LinkedList", "5");


    @Test
    public void LinkedListSolverTest0() {
        assertEquals(false, symKorat.isSat("0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest1() {
        assertEquals(false, symKorat.isSat("1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest2() {
        assertEquals(true, symKorat.isSat("1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest3() {
        assertEquals(false, symKorat.isSat("1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest4() {
        assertEquals(true, symKorat.isSat("1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest5() {
        assertEquals(false, symKorat.isSat("1,2,-1,2,1,-1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest6() {
        assertEquals(true, symKorat.isSat("1,2,-1,1,1,-1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest7() {
        assertEquals(true, symKorat.isSat("1,2,-1,1,-1,-1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest8() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,-1,3,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest9() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,3,2,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest10() {
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,4,2,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest11() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,-1,1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest12() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,3,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest13() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,2,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest14() {
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest15() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,0,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest16() {
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,4,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest17() {
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,4,-1,-1,3,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest18() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,4,3,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest19() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,2,3,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest20() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,0,3,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest21() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,-1,5,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest22() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,4,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest23() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,3,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest24() {
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,4,-1,1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest25() {
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest26() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,3,4"));
    }

    @Test
    public void LinkedListSolverTest27() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,0,4"));
    }

    @Test
    public void LinkedListSolverTest28() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,-1,2"));
    }

    @Test
    public void LinkedListSolverTest29() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,-1,0"));
    }

    @Test
    public void LinkedListSolverTest30() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,4,-1"));
    }

    @Test
    public void LinkedListSolverTest31() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,3,-1"));
    }

    @Test
    public void LinkedListSolverTest32() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,2,-1"));
    }

    @Test
    public void LinkedListSolverTest33() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,0,-1"));
    }

    @Test
    public void LinkedListSolverTest34() {
        assertEquals(false, symKorat.isSat("1,2,-1,0,-1,-1,-1,-1,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest35() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,0,-1,-1,-1"));
    }

    @Test
    public void LinkedListSolverTest36() {
        assertEquals(false, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,5,-1"));
    }

    @Test
    public void LinkedListSolverTest37() {
        assertEquals(true, symKorat.isSat("1,2,-1,3,-1,4,-1,5,-1,1,-1"));
    }
}
