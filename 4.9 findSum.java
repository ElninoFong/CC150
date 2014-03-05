4.9 You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to a given value. The path does not need to start or end at the root or a leaf.

// TC: O(n*log(n)), SC: O(log(n))
public void findSum(TreeNode n, int sum) {
	ArrayList<Integer> path = new ArrayList<Integer>();
	findSum(n, sum, path);
}

void findSum(TreeNode n, int sum, ArrayList<Integer> path) {
	if (n == null) return;
	path.add(n.data);
	int sumTemp = 0;
	for (int i = path.size() - 1; i >= 0; i--) {
		sumTemp += path[i];
		if (sumTemp == sum) {
			print(path, i);
		}
	}
	findSum(n.left, sum, path);
	findSum(n.right, sum, path);
}

void print(ArrayList<Integer> path, int start) {
	for (int i = start; i < path.size(); i++) {
		System.out.print(path[i] + " ");
	}
	System.out.println();
}