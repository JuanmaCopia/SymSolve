package korat.examples.binarytree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;


public class BTNode {
	
	int elem;
	BTNode left;
	BTNode right;
	
	public boolean repOK() {
        return isAcyclic(this);
	}
	
    public boolean isAcyclic(BTNode root) {
        Set<BTNode> visited = new HashSet<BTNode>();
        visited.add(root);
        LinkedList<BTNode> workList = new LinkedList<BTNode>();
        workList.add(root);
        while (!workList.isEmpty()) {
            BTNode current = workList.removeFirst();
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
        return true;
    }

    public static IFinitization finBTNode(int size) {
        return finBTNode(size, size, size);
    }

    public static IFinitization finBTNode(int nodesNum, int minSize, int maxSize) {
        IFinitization f = FinitizationFactory.create(BTNode.class);
        IObjSet nodes = f.createObjSet(BTNode.class, nodesNum, true);
        f.set("BTNode.elem", f.createIntSet(minSize, maxSize));
        f.set("BTNode.left", nodes);
        f.set("BTNode.right", nodes);
        return f;
    }
}
