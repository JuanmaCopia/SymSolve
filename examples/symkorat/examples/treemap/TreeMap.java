package symkorat.examples.treemap;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;


public class TreeMap {
	
	/**
	 * Node in the Tree.  Doubles as a means to pass key-value pairs back to
	 * user (see Map.Entry).
	 */
	public static class Entry {
		int key;
		Object value;
		Entry left = null;
		Entry right = null;
		Entry parent;
		boolean color = BLACK;
	}
	
    public Entry root;
    
    public int size = 0;

    private static final boolean RED = false;
    private static final boolean BLACK = true;


    public static IFinitization finTreeMap(int nodesNum) {
        IFinitization f = FinitizationFactory.create(TreeMap.class);
        IObjSet nodes = f.createObjSet(Entry.class, nodesNum, true);
        f.set("root", nodes, false, false, true);
		f.set("size", f.createIntSet(0, nodesNum));
		f.set("Entry.key", f.createIntSet(0));
		f.set("Entry.left", nodes, false, false, true);
		f.set("Entry.right", nodes, false, false, true);
		f.set("Entry.parent", nodes, false, true, false);
		f.set("Entry.color", f.createBooleanSet());
        return f;
    }

    
    public boolean repOKPrim() {
        return false;
    }
    
    public boolean repOK() {
		if (root == null)
			return true;
		return repOK_Structure() && repOK_Colors();
	}

	public boolean repOK_Structure() {
	    Set<Entry > visited = new HashSet<Entry >();
	    LinkedList<Entry > worklist = new LinkedList<Entry >();
	    visited.add(root);
	    worklist.add(root);
	    if (root.parent != null)
	    	return false;

	    while (!worklist.isEmpty()) {
	    	Entry node = worklist.removeFirst();
	    	Entry left = node.left;
	    	if (left != null) {
	    		if (!visited.add(left))
	    			return false;
	    		if (left.parent != node)
	    			return false;
	    		worklist.add(left);
	    	}
	    	Entry right = node.right;
	    	if (right != null) {
	    		if (!visited.add(right))
	    			return false;
	    		if (right.parent != node)
	    			return false;
	    		worklist.add(right);
	    	}
	    }
	    return true;
	}

	public boolean repOK_Colors() {
		if (root.color != BLACK)
			return false;
		LinkedList<Entry> worklist = new LinkedList<Entry>();
	    worklist.add(root);
	    while (!worklist.isEmpty()) {
	    	Entry current = worklist.removeFirst();
	    	Entry cl = current.left;
	    	Entry cr = current.right;
	    	if (current.color == RED) {
	    		if (cl != null && cl.color == RED)
	    			return false;
	    		if (cr != null && cr.color == RED)
	    			return false;
	    	}
	    	if (cl != null)
	    		worklist.add(cl);
	    	if (cr != null)
	    		worklist.add(cr);
	    }
	    int numberOfBlack = -1;
	    LinkedList<Pair<Entry, Integer>> worklist2 = new LinkedList<Pair<Entry, Integer>>();
	    worklist2.add(new Pair<Entry, Integer>(root, 0));
	    while (!worklist2.isEmpty()) {
	    	Pair<Entry, Integer> p = worklist2.removeFirst();
	    	Entry e = p.first();
	    	int n = p.second();
	    	if (e != null && e.color == BLACK)
	    		n++;
	    	if (e == null) {
	    		if (numberOfBlack == -1)
	    			numberOfBlack = n;
	    		else if (numberOfBlack != n)
	    			return false;
	    	} else {
	    		worklist2.add(new Pair<Entry, Integer>(e.left, n));
	    		worklist2.add(new Pair<Entry, Integer>(e.right, n));
	    	}
	    }
	    return true;
	}
	
	private class Pair<T, U> {
		private T a;
		private U b;

		public Pair(T a, U b) {
			this.a = a;
			this.b = b;
		}

		public T first() {
			return a;
		}

		public U second() {
			return b;
		}
	}

}
