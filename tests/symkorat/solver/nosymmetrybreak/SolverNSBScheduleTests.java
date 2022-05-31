package symkorat.solver.nosymmetrybreak;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import symsolve.SymSolve;
import symsolve.explorers.impl.SymmetryBreakStrategy;

public class SolverNSBScheduleTests {

        private SymSolve symKorat = new SymSolve("symkorat.examples.schedule.Schedule", "10",
                        SymmetryBreakStrategy.NO_SYMMETRY_BREAK);

        @Test
        public void ScheduleSolverTest0() {

                assertEquals(false, symKorat.isSatisfiable(
                                "-1,-1,-1,-1,-1,1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
                assertEquals(true, symKorat.isSatisfiable(
                                "-1,-1,-1,-1,-1,-1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        }

        @Test
        public void ScheduleSolverTest1() {
                assertEquals(false, symKorat.isSatisfiable(
                                "-1,-1,-1,1,-1,-1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
                assertEquals(true, symKorat.isSatisfiable(
                                "-1,-1,-1,-1,-1,1,2,-1,-1,-1,0,-1,1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        }

        @Test
        public void ScheduleSolverTest3() {
                assertEquals(false, symKorat.isSatisfiable(
                                "-1,-1,-1,1,2,3,4,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
                assertEquals(true, symKorat
                                .isSatisfiable(
                                                "-1,-1,-1,0,1,2,3,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
        }

}
