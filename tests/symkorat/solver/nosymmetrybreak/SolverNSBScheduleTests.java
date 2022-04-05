package symkorat.solver.nosymmetrybreak;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import symkorat.SymKorat;

public class SolverNSBScheduleTests {

        private SymKorat symKorat = new SymKorat("symkorat.examples.schedule.Schedule", "10");

        @Test
        public void ScheduleSolverTest0() {

                assertEquals(false, symKorat.isSatNoSymmetryBreak(
                                "-1,-1,-1,-1,-1,1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
                assertEquals(true, symKorat.isSatNoSymmetryBreak(
                                "-1,-1,-1,-1,-1,-1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        }

        @Test
        public void ScheduleSolverTest1() {
                assertEquals(false, symKorat.isSatNoSymmetryBreak(
                                "-1,-1,-1,1,-1,-1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
                assertEquals(true, symKorat.isSatNoSymmetryBreak(
                                "-1,-1,-1,-1,-1,1,2,-1,-1,-1,0,-1,1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        }

        @Test
        public void ScheduleSolverTest3() {
                assertEquals(false, symKorat.isSatNoSymmetryBreak(
                                "-1,-1,-1,1,2,3,4,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
                assertEquals(true, symKorat.isSatNoSymmetryBreak(
                                "-1,-1,-1,0,1,2,3,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        }

}
