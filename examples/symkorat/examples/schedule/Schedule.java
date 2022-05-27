
package symkorat.examples.schedule;


import java.util.HashSet;
import java.util.Set;

import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;


public class Schedule {
	/**
	 * A job descriptor.
	 */

	public int allocProcNum;

	public int numProcesses;

	public Job curProc;

	/**
	 * 0th element unused
	 */
	public List prio_0;
	public List prio_1;
	public List prio_2;
	public List prio_3;

	public List blockQueue;

	public static IFinitization finSchedule(int jobsNum) {
        IFinitization f = FinitizationFactory.create(Schedule.class);
        
        f.set("allocProcNum", f.createIntSet(0));
        f.set("numProcesses", f.createIntSet(0));
        
        IObjSet lists = f.createObjSet(List.class, 4, true);
        IObjSet jobs = f.createObjSet(Job.class, jobsNum, true);
        
        f.set("List.mem_count", f.createIntSet(0));
        f.set("List.first", jobs);
        f.set("List.last", jobs);
        
        f.set("Job.next", jobs);
        f.set("Job.prev", jobs);
        f.set("Job.val", f.createIntSet(0));
        f.set("Job.priority", f.createIntSet(0, jobsNum));
        
        f.set("curProc", jobs);
        
        f.set("prio_0", lists, false, true, true);
        f.set("prio_1", lists, false, false, true);
        f.set("prio_2", lists, false, false, true);
        f.set("prio_3", lists, false, false, true);
        f.set("blockQueue", lists, false, false, true);

        return f;
    }
	
	
	private boolean isDLL(List list, Set<Job> visited) {
		Job current = list.getFirst();
		Job last = list.getLast();
		
		if (current == null)
			return last == null;
		
        if (current.getPrev() != null)
        	return false;
        
        if (!visited.add(current))
        	return false;

        while (true) {

            Job next = current.getNext();
            if (next == null) 
            	break;
            if (next.getPrev() != current)
                return false;
            if (!visited.add(next))
                return false;
            
            current = next;
        }
        
		if (last != current)
            return false;

        return true;
	}
	
	public boolean repOKPrim() {
        return false;
    }
	
    public boolean repOK() {
    	if (
			blockQueue == null ||
			prio_0 != null ||
			prio_1 == null ||
			prio_2 == null ||
			prio_3 == null
    	)
    		return false;
    	
    	HashSet<List> listSet = new HashSet<List>();
    	if (
    		!listSet.add(prio_1) ||
    		!listSet.add(prio_2) ||
    		!listSet.add(prio_3) ||
    		!listSet.add(blockQueue)
    	)
    		return false;
    	
        Set<Job> visited = new HashSet<Job>();

    	if (!isDLL(prio_1, visited))
    		return false;
    	
    	if (!isDLL(prio_2, visited))
    		return false;
    	
    	if (!isDLL(prio_3, visited))
    		return false;
    	
    	if (!isDLL(blockQueue, visited))
    		return false;
    	
        return true;
    }

}
