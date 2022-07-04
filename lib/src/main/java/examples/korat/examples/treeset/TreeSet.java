package korat.examples.treeset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TreeSet {

  public static final int RED = 0;

  public static final int BLACK = 1;

  public int key;

  public int color;

  public TreeSet left;

  public TreeSet right;

  public TreeSet parent;
  
  private static int LIMIT = 7;

  
  public TreeSet(int key, int color) {
    this.key = key;
    this.color = color;
    left = right = parent = null;
  }

  public int color() {
    if (color == RED) {
      color = RED;
    } else {
      color = BLACK;
    }
    return color;
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
  
  // ------------------------- repOK_Concrete begin -----------------------------------//

  public boolean repOK(TreeSet root) {
    return repOK_Structure(root) && repOK_Colors(root)/* && repOK_KeysAndValues(root) */;
  }

  public boolean repOK_Structure(TreeSet root) {
    Set<TreeSet> visited = new HashSet<TreeSet>();
    List<TreeSet> worklist = new ArrayList<TreeSet>();
    visited.add(root);
    worklist.add(root);
    if (root.parent != null)
      return false;

    while (!worklist.isEmpty()) {
      TreeSet node = worklist.remove(0);
      TreeSet left = node.left;
      if (left != null) {
        if (!visited.add(left)) {
          return false;
        }
        if (left.parent != node) {
          return false;
        }
        worklist.add(left);
      }
      TreeSet right = node.right;
      if (right != null) {
        if (!visited.add(right)) {
          return false;
        }
        if (right.parent != node) {
          return false;
        }
        worklist.add(right);
      }
    }
    return visited.size() <= LIMIT;
  }

  public boolean repOK_Colors(TreeSet root) {
    if (root.color() != BLACK)
      return false;
    List<TreeSet> worklist = new ArrayList<TreeSet>();
    worklist.add(root);
    while (!worklist.isEmpty()) {
      TreeSet current = worklist.remove(0);
      TreeSet cl = current.left;
      TreeSet cr = current.right;
      if (current.color() == RED) {
        if (cl != null && cl.color() == RED) {
          return false;
        }
        if (cr != null && cr.color() == RED) {
          return false;
        }
      }
      if (cl != null) {
        worklist.add(cl);
      }
      if (cr != null) {
        worklist.add(cr);
      }
    }
    int numberOfBlack = -1;
    List<Pair<TreeSet, Integer>> worklist2 = new ArrayList<TreeSet.Pair<TreeSet, Integer>>();
    worklist2.add(new Pair<TreeSet, Integer>(root, 0));
    // root.dumpStructure(root);
    while (!worklist2.isEmpty()) {
      // System.out.println("->0");
      Pair<TreeSet, Integer> p = worklist2.remove(0);
      TreeSet e = p.first();
      int n = p.second();
      if (e != null && e.color() == BLACK) {
        n++;
      }
      if (e == null) {
        if (numberOfBlack == -1) {
          numberOfBlack = n;
        } else if (numberOfBlack != n) {
          return false;
        }
      } else {
        worklist2.add(new Pair<TreeSet, Integer>(e.left, n));
        worklist2.add(new Pair<TreeSet, Integer>(e.right, n));
      }
    }
    return true;
  }

  public boolean repOK_KeysAndValues(TreeSet root) {
    int min = repOK_findMin(root);
    int max = repOK_findMax(root);
    if (!repOK_orderedKeys(root, min - 1, max + 1)) {
      return false;
    }
    List<TreeSet> worklist = new ArrayList<TreeSet>();
    worklist.add(root);
    while (!worklist.isEmpty()) {
      TreeSet current = worklist.remove(0);
      if (current.left != null) {
        worklist.add(current.left);
      }
      if (current.right != null) {
        worklist.add(current.right);
      }
    }
    return true;
  }

  private int repOK_findMin(TreeSet root) {
    TreeSet curr = root;
    while (curr.left != null) {
      curr = curr.left;
    }
    return curr.key;
  }

  private int repOK_findMax(TreeSet root) {
    TreeSet curr = root;
    while (curr.right != null) {
      curr = curr.right;
    }
    return curr.key;
  }

  public boolean repOK_orderedKeys(TreeSet e, int min, int max) {
    if ((e.key <= min) || (e.key >= max)) {
      return false;
    }
    if (e.left != null) {
      if (!repOK_orderedKeys(e.left, min, e.key)) {
        return false;
      }
    }
    if (e.right != null) {
      if (!repOK_orderedKeys(e.right, e.key, max)) {
        return false;
      }
    }
    return true;
  }

  // ------------------------- repOK_Concrete end -----------------------------------//

  // ------------------------- repOK_Concrete-Post begin -----------------------------------//

  public boolean repOK_ConcretePost(TreeSet root) {
    return repOK_StructurePost(root)
        && repOK_ColorsPost(root) /* && repOK_KeysAndValuesPost(root) */;
  }

  public boolean repOK_StructurePost(TreeSet root) {
    Set<TreeSet> visited = new HashSet<TreeSet>();
    List<TreeSet> worklist = new ArrayList<TreeSet>();
    visited.add(root);
    worklist.add(root);
    if (root.parent != null)
      return false;

    while (!worklist.isEmpty()) {
      TreeSet node = worklist.remove(0);
      TreeSet left = node.left;
      if (left != null) {
        if (!visited.add(left)) {

          return false;

        }
        if (left.parent != node) {

          return false;
        }
        worklist.add(left);
      }
      TreeSet right = node.right;
      if (right != null) {
        if (!visited.add(right)) {

          return false;
        }
        if (right.parent != node) {

          return false;
        }
        worklist.add(right);
      }
    }
    return true;
  }

  public boolean repOK_ColorsPost(TreeSet root) {
    if (root.color() != BLACK)
      return false;
    List<TreeSet> worklist = new ArrayList<TreeSet>();
    worklist.add(root);
    while (!worklist.isEmpty()) {
      TreeSet current = worklist.remove(0);
      TreeSet cl = current.left;
      TreeSet cr = current.right;
      if (current.color() == RED) {
        if (cl != null && cl.color() == RED) {
          return false;
        }
        if (cr != null && cr.color() == RED) {
          return false;
        }
      }
      if (cl != null) {
        worklist.add(cl);
      }
      if (cr != null) {
        worklist.add(cr);
      }
    }
    int numberOfBlack = -1;
    List<Pair<TreeSet, Integer>> worklist2 = new ArrayList<TreeSet.Pair<TreeSet, Integer>>();
    worklist2.add(new Pair<TreeSet, Integer>(root, 0));
    while (!worklist2.isEmpty()) {
      Pair<TreeSet, Integer> p = worklist2.remove(0);
      TreeSet e = p.first();
      int n = p.second();
      if (e != null && e.color() == BLACK) {
        n++;
      }
      if (e == null) {
        if (numberOfBlack == -1) {
          numberOfBlack = n;
        } else if (numberOfBlack != n) {
          return false;
        }
      } else {
        worklist2.add(new Pair<TreeSet, Integer>(e.left, n));
        worklist2.add(new Pair<TreeSet, Integer>(e.right, n));
      }
    }
    return true;
  }

  public boolean repOK_KeysAndValuesPost(TreeSet root) {
    int min = repOK_findMin(root);
    int max = repOK_findMax(root);
    if (!repOK_orderedKeys(root, min - 1, max + 1)) {
      return false;
    }
    List<TreeSet> worklist = new ArrayList<TreeSet>();
    worklist.add(root);
    while (!worklist.isEmpty()) {
      TreeSet current = worklist.remove(0);
      if (current.left != null) {
        worklist.add(current.left);
      }
      if (current.right != null) {
        worklist.add(current.right);
      }
    }
    return true;
  }

}
