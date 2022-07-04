package symkorat.examples.treeset;


import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;


public class TreeSet {
	
	private transient TreeMap m; // The backing Map


    public static IFinitization finTreeSet(int nodesNum) {
        IFinitization f = FinitizationFactory.create(TreeSet.class);
        IObjSet treemap = f.createObjSet(TreeMap.class, 1, true);
        f.set("m", treemap);
        IObjSet nodes = f.createObjSet(TreeMap.Entry.class, nodesNum, true);
        f.set("TreeMap.root", nodes, false, false, true);
		f.set("TreeMap.size", f.createIntSet(0, nodesNum));
		// f.set(TreeMap.Entry.class, "key", f.createIntSet(0));
		f.set(TreeMap.Entry.class, "left", nodes);
		f.set(TreeMap.Entry.class, "right", nodes);
		f.set(TreeMap.Entry.class, "parent", nodes);
		f.set(TreeMap.Entry.class, "color", f.createBooleanSet());
        return f;
    }

    public boolean repOK() {
		if (m == null)
			return false;
		return m.repOK();
	}
    
    public boolean repOKPrim() {
        return false;
    }
}
