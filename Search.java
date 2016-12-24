import java.util.*;

class Tuple {
	public int left;
	public int right;
	public Tuple parent;

	public Tuple(int l, int r, Tuple t) {
		left = l;
		right = r;
		parent = t;
	}
}

public class Search {

public static boolean checkTuple (Tuple t, LinkedList<Tuple> q) {
	for (int i=0; i <q.size(); i++) {
		Tuple curr = q.get(i);
		if (curr.left == t.left && curr.right == t.right)
			return true;
	}
	return false;	
}
public static void main (String[] args) {
	
	if (args.length != 3) {
		System.out.println("Incorrect number of arguments. Please enter correctly");
		return;
	}
	
	int m = Integer.parseInt(args[0]);
	int n = Integer.parseInt(args[1]);
	int d = Integer.parseInt(args[2]);
	
	if (m < n) {
		System.out.println("m should be greater than or equal to n");
		return;
	}

	// BFS Implementation
	LinkedList<Tuple> closed = new LinkedList<Tuple>();

	LinkedList<Tuple> open = new LinkedList<Tuple>();
	Tuple init = new Tuple(0,0, null);
	open.add(init);
	System.out.println("BFS");

	int it = 0;
	System.out.println("Iteration :");
	boolean BFS_solved = false;
	Tuple s = null;
	while (!open.isEmpty()) {

		s = open.remove(); //state will be expanded in this iteration
		if (checkTuple(s, closed) == true)
			continue;

		if (s.left == d && s.right == 0) 
			BFS_solved = true;
		if (BFS_solved)
			break;

		System.out.println(it);
		closed.add(s);
		String visited = "";
		for(int i=0; i<closed.size(); i++) {
			if (i == 0)
				visited += "("+closed.get(i).left + ", "+ closed.get(i).right + ")";
			else
				visited += " ("+closed.get(i).left + ", "+ closed.get(i).right + ")";
		}
		System.out.println(visited);
		boolean flag = false;
		if (!(s.left == d && s.right == 0))
		 {
			
			int x = s.left;
			int y = s.right;
			//Fill
			if (x<m) {
				Tuple t = new Tuple(m, y, s);
				open.add(t);
				if (!flag) {
					System.out.print("("+t.left+", " + t.right +")");
					flag = true;
				}
				else
					System.out.print(" ("+t.left+", " + t.right +")");
			}
			if (y<n) {
				Tuple t = new Tuple(x, n, s);
				open.add(t);
				if (!flag) {
					System.out.print("("+t.left+", " + t.right +")");
					flag = true;
				}
				else
					System.out.print(" ("+t.left+", " + t.right +")");
			}
			
			//Empty
			if (x!=0) {
				Tuple t = new Tuple(0, y, s);
				open.add(t);
				if (!flag) {
					System.out.print("("+t.left+", " + t.right +")");
					flag = true;
				}
				else
					System.out.print(" ("+t.left+", " + t.right +")");
			}
			if (y!=0) {
				Tuple t = new Tuple(x, 0, s);
				open.add(t);
				if (!flag) {
					System.out.print("("+t.left+", " + t.right +")");
					flag = true;
				}
				else
					System.out.print(" ("+t.left+", " + t.right +")");
			}

			//Pour
			if (x!=0 && y < n) {
				int diff = n-y;
				Tuple t = (x > diff) ? new Tuple(x-diff, n, s) : new Tuple(0, y+x, s);
				
				if (!(x == t.left && y == t.right)) {
					open.add(t);
					if (!flag) {
						System.out.print("("+t.left+", " + t.right +")");
						flag = true;
					}
					else
						System.out.print(" ("+t.left+", " + t.right +")");
				}
			}
			if (y!=0 && x < m) {
				int diff = m-x;
				Tuple t = (y > diff) ? new Tuple(m, y-diff, s) : new Tuple(x+y, 0, s);
				
				if (!(x == t.left && y == t.right)) {
					open.add(t);
					if (!flag) {
						System.out.print("("+t.left+", " + t.right +")");
						flag = true;
					}
					else
						System.out.print(" ("+t.left+", " + t.right +")");
				}
			}
			System.out.print("\n");	
		}
		it++;
		
	}
	System.out.println("Result:");
	String result = "";
	if (!BFS_solved)
		System.out.println("Unsolvable");
	else {
		while (!(s.right == 0 && s.left == 0)) {
			result = " (" + s.left +", " + s.right + ")" + result;
			s = s.parent;
		}
		System.out.println("(0, 0)" +result);
	}
	
	
	//DFS implementation (same as BFS except that the data structure used is stack which means LIFO)
	closed = new LinkedList<Tuple>();

	open = new LinkedList<Tuple>();
	init = new Tuple(0,0, null);
	open.add(init);
	System.out.println("DFS");

	it = 0;
	System.out.println("Iteration :");
	boolean DFS_solved = false;
	s = null;
	while (!open.isEmpty()) {

		s = open.removeLast(); //state will be expanded in this iteration
		if (checkTuple(s, closed) == true)
			continue;

		if (s.left == d && s.right == 0) 
			DFS_solved = true;
		if (DFS_solved)
			break;

		System.out.println(it);
		closed.add(s);
		String visited = "";
		for(int i=0; i<closed.size(); i++) {
			if (i == 0)
				visited += "("+closed.get(i).left + ", "+ closed.get(i).right + ")";
			else
				visited += " ("+closed.get(i).left + ", "+ closed.get(i).right + ")";
		}
		System.out.println(visited);
		boolean flag = false;
		if (!(s.left == d && s.right == 0))
		 {
			
			int x = s.left;
			int y = s.right;
			//Fill
			if (x<m) {
				Tuple t = new Tuple(m, y, s);
				open.add(t);
				if (!flag) {
					System.out.print("("+t.left+", " + t.right +")");
					flag = true;
				}
				else
					System.out.print(" ("+t.left+", " + t.right +")");
			}
			if (y<n) {
				Tuple t = new Tuple(x, n, s);
				open.add(t);
				if (!flag) {
					System.out.print("("+t.left+", " + t.right +")");
					flag = true;
				}
				else
					System.out.print(" ("+t.left+", " + t.right +")");
			}
			
			//Empty
			if (x!=0) {
				Tuple t = new Tuple(0, y, s);
				open.add(t);
				if (!flag) {
					System.out.print("("+t.left+", " + t.right +")");
					flag = true;
				}
				else
					System.out.print(" ("+t.left+", " + t.right +")");
			}
			if (y!=0) {
				Tuple t = new Tuple(x, 0, s);
				open.add(t);
				if (!flag) {
					System.out.print("("+t.left+", " + t.right +")");
					flag = true;
				}
				else
					System.out.print(" ("+t.left+", " + t.right +")");	
			}

			//Pour
			if (x!=0 && y < n) {
				int diff = n-y;
				Tuple t = (x > diff) ? new Tuple(x-diff, n, s) : new Tuple(0, y+x, s);
				if (!(x == t.left && y == t.right)) {
					open.add(t);
					if (!flag) {
						System.out.print("("+t.left+", " + t.right +")");
						flag = true;
					}
					else
						System.out.print(" ("+t.left+", " + t.right +")");
				}
			}
			if (y!=0 && x < m) {
				int diff = m-x;
				Tuple t = (y > diff) ? new Tuple(m, y-diff, s) : new Tuple(x+y, 0, s);
				if (!(x == t.left && y == t.right)) {
					open.add(t);
					if (!flag) {
						System.out.print("("+t.left+", " + t.right +")");
						flag = true;
					}
					else
						System.out.print(" ("+t.left+", " + t.right +")");
				}
			}
			System.out.print("\n");	
		}
		it++;
		
	}
	System.out.println("Result:");
	result = "";
	if (!DFS_solved)
		System.out.println("Unsolvable");
	else {
		while (!(s.right == 0 && s.left == 0)) {
			result = " (" + s.left +", " + s.right + ")" + result;
			s = s.parent;
		}
		System.out.println("(0, 0)" +result);
	}
	
 }
}
