4.8 You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.

// 1. In-order traversal(with NULL) + Pre-order traversal(with NULL) + Suffix tree
// 	  It is in linear time, but takes too much memory
// 2. Brute force
//    TC is higher, but takes less memory

// 2
public boolean isSubTree(TreeNode T1, TreeNode T2) {
	if (T2 == null) return true;
	findStartNode(T1, T2);
}

boolean findStartNode(TreeNode T1, TreeNode T2) {
	if (T1 == null) return false;

	if (T1.data == T2.data) return helper(T1, T2);
	return	findStartNode(T1.left, T2) ||  findStartNode(T2.right, T2);
}

// T1 == T2, check if their subtrees are identical
boolean helper(TreeNode T1, TreeNode T2) {
	if (T1 == null && T2 == null) return true;
	if (T1 == null || T2 == null) return false;
	if (T1.data != T2.data) return false;
	return helper(T1.left, T2.left) && helper(T1.right, T2.right);
}