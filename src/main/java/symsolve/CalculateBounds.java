package symsolve;

import symsolve.bounds.Bounds;
import symsolve.explorers.impl.SymmetryBreakStrategy;

public class CalculateBounds {

    public static void main(String[] args) {
        SymSolve symSolve = new SymSolve("examples.symsolve.treemap.TreeMap", "5",
                SymmetryBreakStrategy.SYMMETRY_BREAK_REVERSE);
        
        Bounds bounds = symSolve.calculateBounds();
        System.out.println("Calculated bounds for TreeMap, Scope = 5\n");
        System.out.println(bounds.toString());
    }
}
