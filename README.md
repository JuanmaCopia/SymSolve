# `SymSolve`


`SymSolve` is an efficient bounded exhaustive solver for symbolic structures with
complex representation invariants. `SymSolve` was built to decide the
satisfiability of structural constraints of partially symbolic heaps that arise
during symbolic execution using lazy initialization.

## Getting Started
To use the `SymSolve` please use Java 8.

Clone the repository:
```
git clone https://github.com/JuanmaCopia/`SymSolve`
```

Move to the folder:
```
cd `SymSolve`
```

Build:
```
./gradlew build
```

## How it works

To decide whether a symbolic instance is satisfiable, `SymSolve` requires an
imperative specification of the constraints that must be satisfied, also known
as ´repOK´ methods. A ´repOK´ is a boolean routine that returns true if the instance
satisfies the desired constraints, and false otherwise. Some ´repOK´ examples are
in the folder ´src/main/symsolve/examples/´