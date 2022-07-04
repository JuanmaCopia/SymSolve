package korat.examples.balancedtree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;


public class BalancedTree {

	public static class Node { 
		Node left;
		Node right; 
	} 

	class Height { 
		int height = 0; 
	} 

	private Node root;
	private int size;

	
	public boolean repOK() {
        if (root == null)
            return size == 0;
        if (!isAcyclic())
        	return false;
        Height height = new Height();
        if (!isBalanced(root, height))
        	return false;
        return true;
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
	
    public boolean isAcyclic() {
        Set<Node> visited = new HashSet<Node>();
        visited.add(root);
        LinkedList<Node> workList = new LinkedList<Node>();
        workList.add(root);
        while (!workList.isEmpty()) {
            Node current = (Node) workList.removeFirst();
            if (current.left != null) {
                if (!visited.add(current.left))
                    return false;
                workList.add(current.left);
            }
            if (current.right != null) {
                if (!visited.add(current.right))
                    return false;
                workList.add(current.right);
            }
        }
        // checks that size is consistent
        return (visited.size() == size);
    }

    public static IFinitization finBalancedTree(int size) {
        return finBalancedTree(size, size, size);
    }

    public static IFinitization finBalancedTree(int nodesNum, int minSize,
            int maxSize) {
        IFinitization f = FinitizationFactory.create(BalancedTree.class);
        IObjSet nodes = f.createObjSet(Node.class, nodesNum, true);
        f.set("root", nodes);
        f.set("size", f.createIntSet(minSize, maxSize));
        f.set("Node.left", nodes);
        f.set("Node.right", nodes);
        return f;
    }
}
