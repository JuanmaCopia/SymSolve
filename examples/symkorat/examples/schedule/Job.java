package symkorat.examples.schedule;


public class Job {
	private Job next;

	private Job prev;

	private int val;

	private int priority;
	
	public Job(int newNum) {
		next=null;
		prev=null;
		val=newNum;
	}

	public Job getNext() {
		return next;
	}
	
	public Job getPrev() {
		return prev;
	}
	
	public void setNext(Job newNext) {
		next = newNext;
	}
	
	public void setPrev(Job newPrev) {
		prev = newPrev;
	}

	public int getVal() {
		return val;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setVal(int newVal) {
		val = newVal;
	}
	
	public void setPriority(int newPriority) {
		priority = newPriority;
	}
	
	public String toString() {
       final StringBuilder buf = new StringBuilder(1);
       //buf.append(this.val);	
       //buf.append(",");	
       buf.append(this.priority);	
       return buf.toString();
	}
	
}