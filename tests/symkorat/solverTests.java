package symkorat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import symkorat.SymKorat;

public class solverTests {
	
	private SymKorat symKorat = new SymKorat("symkorat.examples.hashmap.HashMap", Integer.toString(6));

	@Test
	public void hashmapIsSat() {
		assertEquals(false, symKorat.isSat("1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,3,4,5,6,3"));
	}
}
