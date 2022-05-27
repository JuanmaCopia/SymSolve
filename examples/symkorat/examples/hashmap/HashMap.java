package symkorat.examples.hashmap;

import java.util.HashSet;

import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;


public class HashMap {


	Entry e0;
	Entry e1;
	Entry e2;
	Entry e3;
	Entry e4;
	Entry e5;
	Entry e6;
	Entry e7;
	Entry e8;
	Entry e9;
	Entry e10;
	Entry e11;
	Entry e12;
	Entry e13;
	Entry e14;
	Entry e15;


	/**
	 * The number of key-value mappings contained in this identity hash map.
	 */
	int size;

	/**
	 * The next size value at which to resize (capacity * load factor).
	 * @serial
	 */
	int threshold;
	
	
	/**
	   * The default initial capacity - MUST be a power of two.
	   */
	static final int DEFAULT_INITIAL_CAPACITY = 16;
	


	public static IFinitization finHashMap(int nodesNum) {

		IFinitization f = FinitizationFactory.create(HashMap.class);

		IObjSet entries = f.createObjSet(Entry.class, nodesNum, true);

		f.set("e0", entries, false, false, true);
		f.set("e1", entries, false, false, true);
		f.set("e2", entries, false, false, true);
		f.set("e3", entries, false, false, true);
		f.set("e4", entries, false, false, true);
		f.set("e5", entries, false, false, true);
		f.set("e6", entries, false, false, true);
		f.set("e7", entries, false, false, true);
		f.set("e8", entries, false, false, true);
		f.set("e9", entries, false, false, true);
		f.set("e10", entries, false, false, true);
		f.set("e11", entries, false, false, true);
		f.set("e12", entries, false, false, true);
		f.set("e13", entries, false, false, true);
		f.set("e14", entries, false, false, true);
		f.set("e15", entries, false, false, true);

		f.set("Entry.next", entries, false, false, true);

		f.set("size", f.createIntSet(0, nodesNum));
		f.set("threshold", f.createIntSet(64));

		return f;
	}
	
	
	Entry getTable(int index) {
		  switch (index) {
			  case 0:
				  return e0;
			  case 1:
				  return e1;
			  case 2:
				  return e2;
			  case 3:
				  return e3;
			  case 4:
				  return e4;
			  case 5:
				  return e5;
			  case 6:
				  return e6;
			  case 7:
				  return e7;
			  case 8:
				  return e8;
			  case 9:
				  return e9;
			  case 10:
				  return e10;
			  case 11:
				  return e11;
			  case 12:
				  return e12;
			  case 13:
				  return e13;
			  case 14:
				  return e14;
			  case 15:
				  return e15;
			  default:
				  throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		  }
	  }

	private boolean isLL(Entry e, HashSet<Entry> visited) {
		Entry current = e;
		while (current != null) {
			if (!visited.add(current))
				return false;
			current = current.next;
		}
		return true;
	}


  public boolean repOK() {
  	HashSet<Entry> visited = new HashSet<Entry>();
  	
  	for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++)
  		if (!isLL(getTable(i), visited))
  			return false;

  	return true;
  }


	public static class Entry {
		public int key;
		public Object value;
		public int hash;
		public Entry next;
	}
	
	public boolean repOKPrim() {
        return false;
    }
}
