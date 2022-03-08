package korat.examples.balancedtree;

import java.util.HashSet;
import java.util.Set;

import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;


public class BalancedTreeDFS {

	public static class Node { 
		Node left;
		Node right; 
	} 

	public static class Height { 
		int height = 0; 
	} 

	private Node root;
	private int size;

	
	public boolean repOK() {
        if (root == null)
            return size == 0;
        HashSet<Node> visited = new HashSet<Node>();
        if (!isAcyclicDFS(visited, root)) {
        	return false;
        }
        Height height = new Height();
        if (!isBalanced(root, height)) {
        	return false;
        }
        return visited.size() == size;
	}
	
	public boolean isBalanced(Node root, Height height) {
		/* If tree is empty then return true */
		if (root == null) { 
		    height.height = 0; 
		    return true;
		} 
		
		/* Get heights of left and right sub trees */
		Height lheight = new Height(), rheight = new Height(); 
		boolean l = isBalanced(root.left, lheight); 
		boolean r = isBalanced(root.right, rheight); 
		int lh = lheight.height, rh = rheight.height; 
		
		/* Height of current node is max of heights of 
		   left and right subtrees plus 1*/
		height.height = (lh > rh ? lh : rh) + 1; 
		
		/* If difference between heights of left and right 
		   subtrees is more than 2 then this node is not balanced 
		   so return 0 */
		if (Math.abs(lh - rh) >= 2) 
		    return false; 
		
		/* If this node is balanced and left and right subtrees 
		   are balanced then return true */
		else
			return l && r; 
	 }
    
    public boolean isAcyclicDFS(Set<Node> visited, Node current) {
    	if (current == null)
    		return true;
    	if (!visited.add(current))
            return false;
    	if (!isAcyclicDFS(visited, current.left))
    		return false;
    	if (!isAcyclicDFS(visited, current.right))
    		return false;
    	return true;
    }

    public static IFinitization finBalancedTreeDFS(int size) {
        return finBalancedTreeDFS(size, size, size);
    }

    public static IFinitization finBalancedTreeDFS(int nodesNum, int minSize, int maxSize) {
        IFinitization f = FinitizationFactory.create(BalancedTreeDFS.class);
        IObjSet nodes = f.createObjSet(Node.class, nodesNum, true);
        f.set("root", nodes);
        f.set("size", f.createIntSet(minSize, maxSize));
        f.set("Node.left", nodes);
        f.set("Node.right", nodes);
        return f;
    }
}
