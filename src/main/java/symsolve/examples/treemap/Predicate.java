package symsolve.examples.treemap;

import java.util.*;

public class Predicate {
    public static boolean repOkStructure_M_(TreeMap _this, Map<Class<?>, Set<Object>> mapOfVisited) {
        if ((_this.root != null) && (_this.root.parent != null)) {
            return false;
        }
        Set<Object> visitedObject = mapOfVisited.computeIfAbsent(Object.class, k -> Collections.newSetFromMap(new IdentityHashMap<>()));
        if ((_this.root != null) && (!traverse_0_M_(_this.root, mapOfVisited))) {
            return false;
        }
        if (((((_this.root != null) && (_this.root.left != null)) && (_this.root.left.parent != null)) && (_this.root.left.parent.value != null)) && (!visitedObject.add(_this.root.left.parent.value))) {
            return false;
        }
        if ((((_this.root != null) && (_this.root.left != null)) && (_this.root.left.value != null)) && (!visitedObject.add(_this.root.left.value))) {
            return false;
        }
        if ((((_this.root != null) && (_this.root.parent != null)) && (_this.root.parent.right != null)) && ((visitedObject.size() - 2) != _this.root.parent.right.key)) {
            return false;
        }
        return true;
    }

    public static boolean repOkPrimitive_M_(TreeMap _this, Map<Class<?>, Set<Object>> mapOfVisited) {
        if ((((((_this != null) && (_this.root != null)) && (_this.root.parent != null)) && (_this.root.parent.left != null)) && (_this.root.parent.left.right != null)) && (_this.size != _this.root.parent.left.right.key)) {
            return false;
        }
        if ((((((((_this != null) && (_this.root != null)) && (_this.root.right != null)) && (_this.root.right.parent != null)) && (_this.root.right.parent.left != null)) && (_this.root.left != null)) && (_this.root.left.right != null)) && (_this.root.right.parent.left.color == _this.root.left.right.color)) {
            return false;
        }
        if (((((_this != null) && (_this.root != null)) && (_this.root.right != null)) && (_this.root.right.left != null)) && (!(_this.root.right.left.key <= _this.size))) {
            return false;
        }
        if (((((_this != null) && (_this.root != null)) && (_this.root.parent != null)) && (_this.root.parent.right != null)) && (!(_this.root.parent.key <= _this.root.parent.right.key))) {
            return false;
        }
        if ((((((_this != null) && (_this.root != null)) && (_this.root.parent != null)) && (_this.root.parent.right != null)) && (_this.root.parent.right.left != null)) && (_this.root.parent.right.left.color == _this.root.color)) {
            return false;
        }
        if ((((((_this != null) && (_this.root != null)) && (_this.root.right != null)) && (_this.root.right.parent != null)) && (_this.root.right.parent.left != null)) && (_this.root.right.parent.left.key >= _this.size)) {
            return false;
        }
        if (((((((_this != null) && (_this.root != null)) && (_this.root.right != null)) && (_this.root.right.left != null)) && (_this.root.right.left.parent != null)) && (_this.root.left != null)) && (!(_this.root.right.left.parent.key != _this.root.left.key))) {
            return false;
        }
        if ((((((_this != null) && (_this.root != null)) && (_this.root.left != null)) && (_this.root.left.parent != null)) && (_this.root.parent != null)) && (_this.root.left.parent.color == _this.root.parent.color)) {
            return false;
        }
        if (((((((((_this != null) && (_this.root != null)) && (_this.root.right != null)) && (_this.root.right.left != null)) && (_this.root.right.left.parent != null)) && (_this.root.parent != null)) && (_this.root.parent.right != null)) && (_this.root.parent.right.left != null)) && (_this.root.right.left.parent.key == _this.root.parent.right.left.key)) {
            return false;
        }
        return true;
    }

    public static boolean predicate(TreeMap _this) {
        Map<Class<?>, Set<Object>> mapOfVisited = new IdentityHashMap<>();
        if (!repOkStructure_M_(_this, mapOfVisited)) {
            return false;
        }
        if (!repOkPrimitive_M_(_this, mapOfVisited)) {
            return false;
        }
        return true;
    }

    private static boolean traverse_0_M_(TreeMap.Entry subject, Map<Class<?>, Set<Object>> mapOfVisited) {
        if ((subject.right != null) && (subject.right.parent == null)) {
            return false;
        }
        if (subject == null) {
            return true;
        }
        TreeMap.Entry rootElement = subject;
        Set<Object> visitedEntry = mapOfVisited.computeIfAbsent(rootElement.getClass(), k -> Collections.newSetFromMap(new IdentityHashMap<>()));
        if (!visitedEntry.add(rootElement)) {
            return false;
        }
        LinkedList<TreeMap.Entry> worklist_ = new LinkedList<>();
        worklist_.add(rootElement);
        while (!worklist_.isEmpty()) {
            TreeMap.Entry current_ = worklist_.removeFirst();
            if (((current_ != null) && (current_.left != null)) && (current_.left.parent == null)) {
                return false;
            }
            if (((current_ != null) && (current_.right != null)) && (!visitedEntry.add(current_.right.key))) {
                return false;
            }
            if ((((current_ != null) && (current_.left != null)) && (current_.left.right != null)) && (current_.color != current_.left.right.color)) {
                return false;
            }
            if ((((current_ != null) && (current_.parent != null)) && (current_.parent.right != null)) && (current_.color != current_.parent.right.color)) {
                return false;
            }
            if (((((current_ != null) && (current_.right != null)) && (current_.right.left != null)) && (current_.right.left.parent != null)) && visitedEntry.add(current_.right.left.parent.key)) {
                return false;
            }
            if ((((current_ != null) && (current_.right != null)) && (current_.right.left != null)) && (!(current_.key < current_.right.left.key))) {
                return false;
            }
            if ((((current_ != null) && (current_.right != null)) && (current_.right.parent != null)) && (!(current_.key <= current_.right.parent.key))) {
                return false;
            }
            if (((((current_ != null) && (current_.parent != null)) && (current_.parent.left != null)) && (current_.parent.left.right != null)) && (current_.color == current_.parent.left.right.color)) {
                return false;
            }
            if (((((current_ != null) && (current_.left != null)) && (current_.left.parent != null)) && (current_.left.parent.right != null)) && (!(current_.key != current_.left.parent.right.key))) {
                return false;
            }
            if (((current_ != null) && (current_.right != null)) && (!(current_.key < current_.right.key))) {
                return false;
            }
            if ((((current_ != null) && (current_.left != null)) && (current_.left.right != null)) && (current_.key < current_.left.right.key)) {
                return false;
            }
            if (current_.left != null) {
                if (!visitedEntry.add(current_.left)) {
                    return false;
                }
                worklist_.add(current_.left);
            }
            if (current_.right != null) {
                if (!visitedEntry.add(current_.right)) {
                    return false;
                }
                worklist_.add(current_.right);
            }
        }
        return true;
    }
}