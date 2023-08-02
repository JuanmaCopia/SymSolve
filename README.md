# `SymSolve`


`SymSolve` is an efficient bounded exhaustive solver for symbolic structures with
complex representation invariants. `SymSolve` was built to decide the
satisfiability of structural constraints of partially symbolic heaps that arise
during symbolic execution using lazy initialization.
`SymSolve` is based on the bounded exhaustive test generation tool `Korat`.

## Getting Started
To use the `SymSolve` please use Java 8.

Clone the repository:
```
git clone https://github.com/JuanmaCopia/symsolve
```

Move to the folder:
```
cd symsolve
```

Build:
```
./gradlew build
```

Generate Jar File:
```
./gradlew jar
```

The generated jar can be found in `build/libs/symsolve.jar`.

## How it works

To decide whether a symbolic instance is satisfiable, `SymSolve` requires an
imperative specification of the constraints that must be satisfied, also known
as `repOK` methods. A `repOK` is a boolean routine that returns true if the instance
satisfies the desired constraints, and false otherwise.
As any bounded analysis, `SymSolve` requires the bounds for the amount of
objects that can be employed during the analysis. The bounds in `SymSolve` (as
in `Korat`) are defined thorough `finitization` methods. Examples of both `repOK`
and `finitization` methods can be found in the folder
`src/main/java/symsolve/examples/`.

`SymSolve` takes as input a partially symbolic structure encoded as a vector.
These vectors have the same format as `Korat` vectors and are determined by how
the bounds are defined in the `finitization` method and the scope of the
analysis provided as argument for the `finitization` method.

## How to use it

`SymSolve` can be used through its API, by importing the generated Jar File. See
the example below:

```
Example here!
```

You can find the API implementation in `src/main/java/symsolve/SymSolve.java`.