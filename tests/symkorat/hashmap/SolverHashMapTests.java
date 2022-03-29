package symkorat.hashmap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import symkorat.SymKorat;

public class SolverHashMapTests {
	
	private SymKorat symKorat = new SymKorat("symkorat.examples.hashmap.HashMap", Integer.toString(6));

	
	@Test
	public void HashMapSolverTest0() {
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest2() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest3() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest4() {
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest5() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest6() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest7() {
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest8() {
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest9() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest10() {
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest11() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest12() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest13() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest14() {
	    assertEquals(true, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest15() {
	    assertEquals(true, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest16() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest17() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest18() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest19() {
	    assertEquals(true, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest20() {
	    assertEquals(true, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest21() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest22() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest23() {
	    assertEquals(true, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest24() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest25() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest26() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest27() {
	    assertEquals(true, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest28() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest29() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest30() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest31() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest32() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest33() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest34() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest35() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest36() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest37() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest38() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest39() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest40() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest41() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest42() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest43() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest44() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest45() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest46() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest47() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest48() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest49() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest50() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest51() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest52() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest53() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest54() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest55() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest56() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest57() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest58() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest59() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest60() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest61() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest62() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest63() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest64() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest65() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest66() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest67() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest68() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest69() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest70() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest71() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest72() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest73() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest74() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest75() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest76() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest77() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest78() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest79() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest80() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest81() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest82() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest83() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest84() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest85() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest86() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest87() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest88() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest89() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest90() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest91() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest92() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest93() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest94() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest95() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest96() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest97() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest98() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest99() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest100() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest101() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest102() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest103() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest104() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest105() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest106() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest107() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest108() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest109() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest110() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest111() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest112() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest113() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest114() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest115() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest116() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest117() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest118() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest119() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest120() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest121() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest122() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest123() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest124() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest125() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest126() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest127() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest128() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest129() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest130() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest131() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest132() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest133() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest134() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest135() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest136() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest137() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest138() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest139() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest140() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest141() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest142() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest143() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest144() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest145() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest146() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest147() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest148() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest149() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest150() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest151() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest152() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest153() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest154() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest155() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest156() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest157() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest158() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest159() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest160() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest161() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest162() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest163() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest164() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest165() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest166() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest167() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest168() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest169() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest170() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest171() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest172() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest173() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest174() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest175() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest176() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest177() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest178() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest179() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest180() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest181() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest182() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest183() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest184() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest185() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest186() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest187() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest188() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest189() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest190() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest191() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest192() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest193() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest194() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest195() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest196() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest197() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest198() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest199() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest200() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest201() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest202() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest203() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest204() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest205() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest206() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest207() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest208() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest209() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest210() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest211() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest212() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest213() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest214() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest215() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest216() {
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest217() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest218() {
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest219() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest220() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest221() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest222() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest223() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest224() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest225() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest226() {
	    assertEquals(true, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest227() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest228() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest229() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest230() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest231() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest232() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest233() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest234() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest235() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest236() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest237() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest238() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest239() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest240() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest241() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest242() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest243() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest244() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest245() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest246() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest247() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest248() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest249() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest250() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest251() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest252() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest253() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest254() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest255() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest256() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest257() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest258() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest259() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest260() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest261() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest262() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest263() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest264() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest265() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest266() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest267() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest268() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest269() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest270() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,0,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest271() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest272() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest273() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest274() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest275() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest276() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest277() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest278() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest279() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest280() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest281() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest282() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest283() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest284() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest285() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest286() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest287() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest288() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest289() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest290() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,0,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest291() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest292() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest293() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest294() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest295() {
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest296() {
	    assertEquals(true, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest297() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest298() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest299() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest300() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest301() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest302() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest303() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest304() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest305() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest306() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest307() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest308() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest309() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest310() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest311() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest312() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest313() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest314() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest315() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest316() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest317() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest318() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest319() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest320() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest321() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest322() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest323() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest324() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest325() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest326() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest327() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest328() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest329() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,2,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest330() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest331() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest332() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest333() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest334() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest335() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest336() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest337() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest338() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest339() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest340() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest341() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest342() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest343() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest344() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest345() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest346() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest347() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest348() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest349() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest350() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest351() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest352() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest353() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest354() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest355() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest356() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest357() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest358() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest359() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest360() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest361() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest362() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest363() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest364() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest365() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest366() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,2,0,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest367() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest368() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest369() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest370() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest371() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest372() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest373() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest374() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest375() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest376() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest377() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest378() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest379() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest380() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest381() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest382() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest383() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest384() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest385() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest386() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest387() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest388() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest389() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest390() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest391() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest392() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest393() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest394() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest395() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest396() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest397() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest398() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest399() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest400() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest401() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest402() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest403() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest404() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest405() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest406() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest407() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest408() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest409() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest410() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,2"));
	}
	
	@Test
	public void HashMapSolverTest411() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest412() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,6"));
	}
	
	@Test
	public void HashMapSolverTest413() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest414() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,5"));
	}
	
	@Test
	public void HashMapSolverTest415() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,3"));
	}
	
	@Test
	public void HashMapSolverTest416() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,-1,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest417() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,1"));
	}
	
	@Test
	public void HashMapSolverTest418() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,4,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest419() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,3,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest420() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest421() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,0,4"));
	}

	@Test
	public void HashMapSolverTest422() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,2,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest423() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest424() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,6,0"));
	}
	
	@Test
	public void HashMapSolverTest425() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,4,6,0"));
	}
	
	@Test
	public void HashMapSolverTest426() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,-1,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest427() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,2,6,0"));
	}
	
	@Test
	public void HashMapSolverTest428() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,3,6,0"));
	}
	
	@Test
	public void HashMapSolverTest429() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,-1,6,0"));
	}
	
	@Test
	public void HashMapSolverTest430() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,1,6,0"));
	}
	
	@Test
	public void HashMapSolverTest431() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest432() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest433() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest434() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,2,0"));
	}
	
	@Test
	public void HashMapSolverTest435() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest436() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest437() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest438() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest439() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,6,4"));
	}
	
	@Test
	public void HashMapSolverTest440() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest441() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest442() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest443() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,-1,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest444() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest445() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest446() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,2,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest447() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,2,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest448() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest449() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,6,4,0"));
	}
	
	@Test
	public void HashMapSolverTest450() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest451() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,6,2"));
	}
	
	@Test
	public void HashMapSolverTest452() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest453() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest454() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,1,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest455() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest456() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,1,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest457() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest458() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest459() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest460() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest461() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest462() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,2,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest463() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest464() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest465() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest466() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest467() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,1,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest468() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,5,0,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest469() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest470() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest471() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest472() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest473() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest474() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest475() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,2,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest476() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest477() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,2,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest478() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest479() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest480() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest481() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,1,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest482() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,2,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest483() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest484() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,-1,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest485() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest486() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest487() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest488() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest489() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,2,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest490() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,4,0,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest491() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest492() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest493() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest494() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest495() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest496() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest497() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest498() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,1,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest499() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest500() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest501() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,-1,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest502() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest503() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest504() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest505() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest506() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest507() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest508() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest509() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,0,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest510() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,0,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest511() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest512() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,3,0,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest513() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest514() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest515() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest516() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest517() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest518() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest519() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest520() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest521() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest522() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest523() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest524() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest525() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest526() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest527() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest528() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest529() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest530() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest531() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest532() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest533() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest534() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest535() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest536() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,0,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest537() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest538() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest539() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest540() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest541() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest542() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest543() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest544() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest545() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest546() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest547() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest548() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest549() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest550() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest551() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest552() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest553() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest554() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest555() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest556() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest557() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest558() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,2"));
	}
	
	@Test
	public void HashMapSolverTest559() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,4"));
	}
	
	@Test
	public void HashMapSolverTest560() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest561() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest562() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,5"));
	}
	
	@Test
	public void HashMapSolverTest563() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest564() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,3"));
	}
	
	@Test
	public void HashMapSolverTest565() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,6"));
	}
	
	@Test
	public void HashMapSolverTest566() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,6,1"));
	}
	
	@Test
	public void HashMapSolverTest567() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest568() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,2,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest569() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,-1,0"));
	}
	
	@Test
	public void HashMapSolverTest570() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,5,0"));
	}
	
	@Test
	public void HashMapSolverTest571() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,2,0"));
	}
	
	@Test
	public void HashMapSolverTest572() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest573() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,1,0"));
	}
	
	@Test
	public void HashMapSolverTest574() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest575() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest576() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest577() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest578() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,0,3"));
	}
	
	@Test
	public void HashMapSolverTest579() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest580() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest581() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,0,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest582() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,0,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest583() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,3,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest584() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,1,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest585() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest586() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,3,6,0"));
	}
	
	@Test
	public void HashMapSolverTest587() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest588() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest589() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest590() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,0,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest591() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,-1,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest592() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,2,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest593() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest594() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest595() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,3,0"));
	}
	
	@Test
	public void HashMapSolverTest596() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,6,0"));
	}
	
	@Test
	public void HashMapSolverTest597() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,4,0"));
	}
	
	@Test
	public void HashMapSolverTest598() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,0,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest599() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,6,0,5"));
	}
	
	@Test
	public void HashMapSolverTest600() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest601() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest602() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,3,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest603() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest604() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest605() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,3,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest606() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,-1,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest607() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest608() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,0,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest609() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,0,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest610() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest611() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest612() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest613() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest614() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest615() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest616() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest617() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest618() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest619() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,5,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest620() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest621() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest622() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest623() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest624() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,1,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest625() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest626() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,1,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest627() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,3,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest628() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest629() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest630() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,2,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest631() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest632() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,0,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest633() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,0,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest634() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest635() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest636() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,-1,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest637() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest638() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,0,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest639() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest640() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest641() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,4,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest642() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest643() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,0,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest644() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,0,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest645() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,0,0,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest646() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,0,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest647() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest648() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest649() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest650() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest651() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest652() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest653() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest654() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest655() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest656() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest657() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest658() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest659() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest660() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest661() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest662() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,-1,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest663() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest664() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest665() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest666() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest667() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest668() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,3"));
	}
	
	@Test
	public void HashMapSolverTest669() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,1"));
	}
	
	@Test
	public void HashMapSolverTest670() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest671() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,5"));
	}
	
	@Test
	public void HashMapSolverTest672() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,4"));
	}
	
	@Test
	public void HashMapSolverTest673() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,6"));
	}
	
	@Test
	public void HashMapSolverTest674() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest675() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,6,2"));
	}
	
	@Test
	public void HashMapSolverTest676() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest677() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest678() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest679() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,0"));
	}
	
	@Test
	public void HashMapSolverTest680() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest681() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,2"));
	}
	
	@Test
	public void HashMapSolverTest682() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,4"));
	}
	
	@Test
	public void HashMapSolverTest683() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest684() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest685() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,3,0"));
	}
	
	@Test
	public void HashMapSolverTest686() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,1,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest687() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest688() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest689() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,3,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest690() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,4,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest691() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest692() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,-1,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest693() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest694() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest695() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest696() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest697() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,6"));
	}
	
	@Test
	public void HashMapSolverTest698() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,3"));
	}
	
	@Test
	public void HashMapSolverTest699() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,2,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest700() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,1"));
	}
	
	@Test
	public void HashMapSolverTest701() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,0,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest702() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,2,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest703() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest704() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest705() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest706() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest707() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest708() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest709() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest710() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,4,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest711() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,0,5"));
	}
	
	@Test
	public void HashMapSolverTest712() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest713() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest714() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,0,6,3"));
	}
	
	@Test
	public void HashMapSolverTest715() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest716() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest717() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest718() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest719() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,-1,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest720() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest721() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest722() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest723() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest724() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest725() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest726() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,0,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest727() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest728() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest729() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest730() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,-1,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest731() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,0,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest732() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest733() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest734() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,1,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest735() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,3,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest736() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest737() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest738() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest739() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest740() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,2,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest741() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest742() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest743() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,2,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest744() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,0,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest745() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest746() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,1"));
	}
	
	@Test
	public void HashMapSolverTest747() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,3"));
	}
	
	@Test
	public void HashMapSolverTest748() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,6"));
	}
	
	@Test
	public void HashMapSolverTest749() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest750() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,2,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest751() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest752() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,5"));
	}
	
	@Test
	public void HashMapSolverTest753() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,2"));
	}
	
	@Test
	public void HashMapSolverTest754() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,0,4"));
	}
	
	@Test
	public void HashMapSolverTest755() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,2,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest756() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,1,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest757() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,1,0"));
	}
	
	@Test
	public void HashMapSolverTest758() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,-1,0"));
	}
	
	@Test
	public void HashMapSolverTest759() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest760() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,5,0"));
	}
	
	@Test
	public void HashMapSolverTest761() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,3,0"));
	}
	
	@Test
	public void HashMapSolverTest762() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest763() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest764() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest765() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,1"));
	}
	
	@Test
	public void HashMapSolverTest766() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,3,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest767() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,-1,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest768() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,6,3,0"));
	}
	
	@Test
	public void HashMapSolverTest769() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,2,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest770() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,2,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest771() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,1,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest772() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,3"));
	}
	
	@Test
	public void HashMapSolverTest773() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest774() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest775() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest776() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest777() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,5"));
	}
	
	@Test
	public void HashMapSolverTest778() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,4,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest779() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest780() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest781() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,2,0"));
	}
	
	@Test
	public void HashMapSolverTest782() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest783() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,4,0"));
	}
	
	@Test
	public void HashMapSolverTest784() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest785() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,6"));
	}
	
	@Test
	public void HashMapSolverTest786() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,3,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest787() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,3,6,0"));
	}
	
	@Test
	public void HashMapSolverTest788() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,-1,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest789() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,6,0"));
	}
	
	@Test
	public void HashMapSolverTest790() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,1,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest791() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest792() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,4,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest793() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,3,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest794() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest795() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,2"));
	}
	
	@Test
	public void HashMapSolverTest796() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,1,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest797() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest798() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,0,4"));
	}
	
	@Test
	public void HashMapSolverTest799() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,5,6,0,0"));
	}
	
	@Test
	public void HashMapSolverTest800() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,2,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest801() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,-1,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest802() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest803() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest804() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest805() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,4,6,0"));
	}
	
	@Test
	public void HashMapSolverTest806() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,3,6,0"));
	}
	
	@Test
	public void HashMapSolverTest807() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,-1,6,0"));
	}
	
	@Test
	public void HashMapSolverTest808() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,1,6,0"));
	}
	
	@Test
	public void HashMapSolverTest809() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest810() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest811() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,1,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest812() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,3,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest813() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,-1,6,0"));
	}
	
	@Test
	public void HashMapSolverTest814() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest815() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,4,6,0"));
	}
	
	@Test
	public void HashMapSolverTest816() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest817() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,2,6,0"));
	}
	
	@Test
	public void HashMapSolverTest818() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest819() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,4,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest820() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest821() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest822() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,0,6,0,3"));
	}
	
	@Test
	public void HashMapSolverTest823() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,3,6,0"));
	}
	
	@Test
	public void HashMapSolverTest824() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,5,6,3,0,0"));
	}
	
	@Test
	public void HashMapSolverTest825() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,1,6,0"));
	}
	
	@Test
	public void HashMapSolverTest826() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,0,5"));
	}
	
	@Test
	public void HashMapSolverTest827() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest828() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest829() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,0,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest830() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,4,0"));
	}
	
	@Test
	public void HashMapSolverTest831() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,1,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest832() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest833() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,2,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest834() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,2,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest835() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest836() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,2,0"));
	}
	
	@Test
	public void HashMapSolverTest837() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest838() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest839() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,-1,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest840() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,6,0,3"));
	}
	
	@Test
	public void HashMapSolverTest841() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,3,6,0"));
	}
	
	@Test
	public void HashMapSolverTest842() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,0,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest843() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest844() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,2,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest845() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest846() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest847() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest848() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,4,5,6,2"));
	}
	
	@Test
	public void HashMapSolverTest849() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,-1"));
	}
	
	@Test
	public void HashMapSolverTest850() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest851() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest852() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest853() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,0,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest854() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest855() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest856() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,6,2"));
	}
	
	@Test
	public void HashMapSolverTest857() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest858() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest859() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,1,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest860() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,2,6,0"));
	}
	
	@Test
	public void HashMapSolverTest861() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest862() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,6,0"));
	}
	
	@Test
	public void HashMapSolverTest863() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,-1,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest864() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,2,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest865() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest866() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,6,6,0"));
	}
	
	@Test
	public void HashMapSolverTest867() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,5,0,6,0"));
	}
	
	@Test
	public void HashMapSolverTest868() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest869() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,0,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest870() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,5"));
	}
	
	@Test
	public void HashMapSolverTest871() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,6,2"));
	}
	
	@Test
	public void HashMapSolverTest872() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,6"));
	}
	
	@Test
	public void HashMapSolverTest873() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest874() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,2,0"));
	}
	
	@Test
	public void HashMapSolverTest875() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest876() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,6,4"));
	}
	
	@Test
	public void HashMapSolverTest877() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest878() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest879() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,1,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest880() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,0,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest881() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,-1,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest882() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest883() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,-1,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest884() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,3,0,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest885() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,-1,-1,3,0,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest886() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest887() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,2,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest888() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,6,4"));
	}
	
	@Test
	public void HashMapSolverTest889() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,6,4,0"));
	}
	
	@Test
	public void HashMapSolverTest890() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,2,5,6,0"));
	}
	
	@Test
	public void HashMapSolverTest891() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest892() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest893() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest894() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,5,6,3"));
	}
	
	@Test
	public void HashMapSolverTest895() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest896() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest897() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest898() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,1,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest899() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest900() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest901() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest902() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,2,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest903() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest904() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest905() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest906() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest907() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,2,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest908() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest909() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest910() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,3,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest911() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,4,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest912() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,-1,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest913() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,2,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest914() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest915() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,0,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest916() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,5,3,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest917() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest918() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest919() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest920() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,-1,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest921() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,2,3,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest922() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest923() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest924() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,2,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest925() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest926() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest927() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest928() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest929() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,0,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest930() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,-1,-1,3,4,5,0,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest931() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,0,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest932() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,0,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest933() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest934() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,5,0,4,-1"));
	}
	
	@Test
	public void HashMapSolverTest935() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest936() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest937() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest938() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest939() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,0,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest940() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest941() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest942() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,3,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest943() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,2,4,5,0,-1"));
	}
	
	@Test
	public void HashMapSolverTest944() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,4,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest945() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,-1,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest946() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest947() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest948() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest949() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,4,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest950() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,-1,-1,3,4,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest951() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest952() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,-1,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest953() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,0,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest954() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,1,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest955() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,-1,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest956() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,1,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest957() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest958() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,1,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest959() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest960() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest961() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest962() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,3,0,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest963() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest964() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,-1,-1,-1,-1,2,3,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest965() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,0,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest966() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest967() {
	    assertEquals(true, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,2,-1,-1,3,4,0,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest968() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,-1,-1,4,0,3,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest969() {
	    assertEquals(false, symKorat.isSat("0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,-1,-1,-1,3,4,0,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest970() {
	    assertEquals(true, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest971() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest972() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest973() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest974() {
	    assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest975() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest976() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest977() {
	    assertEquals(false, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest978() {
	    assertEquals(true, symKorat.isSat("-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest979() {
	    assertEquals(false, symKorat.isSat("-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,2,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest980() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,2,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest981() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest982() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest983() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest984() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest985() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,1"));
	}
	
	@Test
	public void HashMapSolverTest986() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest987() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,3,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest988() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,1,-1"));
	}
	
	@Test
	public void HashMapSolverTest989() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest990() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest991() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest992() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,5,-1"));
	}
	
	@Test
	public void HashMapSolverTest993() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest994() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest995() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,3,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest996() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,2,-1"));
	}
	
	@Test
	public void HashMapSolverTest997() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,2,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest998() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,2,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest999() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1000() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1001() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1002() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1003() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest1004() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,0,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1005() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,2,3,4,5,6,4"));
	}
	
	@Test
	public void HashMapSolverTest1006() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,2,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1007() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1008() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,2,3,1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1009() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1010() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1011() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1012() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,-1,-1,-1"));
	}
	
	@Test
	public void HashMapSolverTest1013() {
	    assertEquals(false, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,4,5,3,-1"));
	}
	
	@Test
	public void HashMapSolverTest1014() {
	    assertEquals(true, symKorat.isSat("-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,2,3,-1,-1,-1,-1"));
	}
}
