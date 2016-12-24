# Water-Jug-Problem
State space search algorithm to formulate and solve water jugs problem

## Problem Description
We are given 2 water jugs with capacity m, n liters (m, n are positive integer numbers and m ≥ n).
We have to use these two jugs to measure d liters (d is a positive integer number) where d ≤ m. The
operations one can perform are:
• Empty a jug
• Fill a jug
• Pour water from one jug to the other until one of the jugs is either empty or full

## Format
• Input: 3 positive integers m, n, d where m ≥ n, d (see examples below for input format)

• Output: Algorithm should be run in the order of BFS, DFS. Print the algorithm used (typical search algorithms BFS, DFS). 

Each search algorithm should then output an iteration part and a result part.
- Iteration part: print “Iteration :” in the first line. Then print 3 lines for every iteration as follows.
- Iteration number (starts from 0).The states in the CLOSED structure (in any order).The successors in the order you put into the OPEN data structure in this iteration. 
- When expanding a node, make sure multiple successors are placed in the OPEN data structure in this order: (1 first) m fill > (2) n fill > (3) m empty > (4) n empty > (5) m pour > (6 last) n pour. If there are no successors to add to OPEN in an iteration, print an empty line.
-  Result part: print 'Result :' in the first line. Then print the solution path found. In the case the problem is unsolvable, print only 'Unsolvable' instead.

Each state of two jugs is represented as a pair (x, y) where x is the amount of water in the m-liter
jug, and y is that of the n-liter one. The solution path is a sequence of states (x, y) separated by one
space. The initial state is (0, 0), and the goal state is defined to be (d, 0).

## Sample Output
```java
$ java Search 3 2 2
BF S
Iteration :
0
(0, 0)
(3, 0) (0, 2)
1
(0, 0) (3, 0)
(3, 2) (1, 2)
2
(0, 0) (3, 0) (0, 2)
(2, 0)
Result :
(0, 0) (0, 2) (2, 0)
DF S
Iteration :
...
Result :
...
```

