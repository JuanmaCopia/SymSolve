package korat.examples.binarytree;

import java.util.HashSet;
import java.util.Set;

import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;

public class BinaryTreeDFS {
	
	public static class Node {
        Node left;
        Node right;
    }

    private Node root;
    private int size;
    
    public boolean repOK() {
        if (root == null)
            return size == 0;
        HashSet<Node> visited = new HashSet<Node>();
        if (!isAcyclicDFS(visited, root))
        	return false;
        return visited.size() == size;
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

    public static IFinitization finBinaryTreeDFS(int size) {
        return finBinaryTreeDFS(size, size, size);
    }

    public static IFinitization finBinaryTreeDFS(int nodesNum, int minSize,
            int maxSize) {
        IFinitization f = FinitizationFactory.create(BinaryTreeDFS.class);
        IObjSet nodes = f.createObjSet(Node.class, nodesNum, true);
        f.set("root", nodes);
        f.set("size", f.createIntSet(minSize, maxSize));
        f.set("Node.left", nodes);
        f.set("Node.right", nodes);
        return f;
    }
}
