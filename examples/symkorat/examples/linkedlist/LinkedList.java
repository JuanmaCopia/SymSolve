
package symkorat.examples.linkedlist;

import java.util.HashSet;
import java.util.Set;

import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;

public class LinkedList {
	
	public Entry header = new Entry();
	public int size = 0;
	
	
	public static class Entry {
		public int element;
		public Entry next;
		public Entry previous;
	}
	
	
	public static IFinitization finLinkedList(int nodesNum) {
        IFinitization f = FinitizationFactory.create(LinkedList.class);
        IObjSet nodes = f.createObjSet(Entry.class, nodesNum, true);
        f.set("header", nodes);
        f.set("Entry.next", nodes);
        f.set("Entry.previous", nodes);
        return f;
    }
	
	  
	public boolean repOK() {
		if (header == null)
			return false;
		
		Set<Entry> visited = new HashSet<Entry>();
		visited.add(header);
		Entry current = header;
		
		while (true) {
			Entry next = current.next;
			if (next == null)
				return false;
			if (next.previous != current)
				return false;
			current = next;
			if (!visited.add(next))
				break;
		}
		if (current != header)
			return false;
		
		return true;
	}
	
	public boolean repOKPrim() {
        return false;
    }
}
