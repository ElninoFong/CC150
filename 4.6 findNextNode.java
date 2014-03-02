4.6 Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary seach tree. You may assume that each node has a link to its parent.

// pseudocode
if (n has right subtree) {
	return rightSubtree.leftMost();
} else {
	if (n is the left child of n.parent) {
		return n.parent;
	} else (n is the right child) {
		find n's first ascendor m, which is the left child
		return m.parent;
	}
}

// Java code
TreeNode findNextNode(TreeNode n) {
	if (n == null) return null;

	// n.parent == null will also work on below codes
	if (n.right != null) {
		return leftMost(n.right);
	} else {
		// find the first left child
		while (n.parent != null and n == n.parent.right) {
			n = n.parent;
		}
		return n.parent;
	}
}

TreeNode leftMost(TreeNode n) {
	if (n == null) return null;
	while (n.left != null) {
		n = n.left;
	}
	return n;
}