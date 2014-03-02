4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

// discuss trade off between DFS and BFS to interviewer.

// DFS to find node
// TC: O(n), SC: O(n)
public boolean isConnected(Node n1, Node n2) {
	if (n1 == null || n2 == null) return false;
	BooleanWrapper bw = new BooleanWrapper();
	// n1 -> n2
	dfs(n1, n2, bw);
	// n2 -> n1
	if (!bw.bool) {
		dfs(n2, n1, bw);
	}
	return bw.bool;
}

void dfs(Node n1, Node n2, BooleanWrapper bw) {
	n1.isVisited = true;
	foreach (Node n : n1.adjancent()) {
		if (n == n2) {
			bw.bool = true;
			return;
		} 
		if (!n.isVisited) {
			dfs(n, n2, bw);
		}
	}	
}

public class BooleanWrapper {
	boolean bool;
	public BooleanWrapper() {
		bool = false;
	}
}


// can we not use the wrapper?
// DFS
public boolean isConnected(Node n1, Node n2) {
	if (n1 == null || n2 == null) return false;
	// n1 -> n2
	boolean bool = dfs(n1, n2);
	// n2 -> n1
	if (!bool) {
		bool = dfs(n2, n1);
	}
	return bool;
}

boolean dfs(Node n1, Node n2) {
	boolean res = false;
	n1.isVisited = true;
	foreach (Node n : n1.adjancent()) {
		if (n == n2) return true;
		if (!n.isVisited) {
			res = res || dfs(n, n2);
		}
	}
	return res;
}

// BFS
public boolean isConnected(Graph g, Node start, Node end) {
	LinkedList<Node> q = new LinkedList<Node>();
	q.add(start);
	while (!q.isEmpty()) {
		Node n = q.removeFirst();
		n.isVisited = true;
		if (n != null) {
			foreach(Node v : n.getAdjancent()) {
				if (v == end) return true;
				if (!v.isVisited) {
					q.add(v);
				}
			}
		}
	}
	return false;
}
