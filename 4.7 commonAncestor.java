4.7 Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.

// if node p and q are in the left subtree search root.leftsubtree
// if p and q are in the right subtree search root.rightsubtree
// if one in left and one in right, we found the common ancestor

// TC: O(n) = n + n/2 + n/4 + ... + 2 + 1
// SC: O(log(n))
public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if (root  == null) return null;

	boolean isPInLeft = findNode(root.left, p);
	boolean isQInLeft = findNode(root.left, p);
	boolean isPInRight = findNode(root.right, p);
	boolean isQInRight = findNode(root.right, p);

	// check p or q not in this tree
	if (!isPInLeft && !isPInRight) return null;
	if (!isQInLeft && !isQInRight) return null;

	// check root == p or q
	if (root == p || root == q) return root;

	// both in left or right
 	if (isPInLeft && isQInLeft)
		return commonAncestor(root.left, p, q);
	if (isPInRight && !isQInRight)
		return commonAncestor(root.right, p, q);
	
	// one left and one right
	return root;
}

boolean findNode(TreeNode root, TreeNode node) {
	if (root == null) return false;
	if (root == node) return true;
	return findNode(root.left, node) || findNode(root.right, node);
}


// Optimized: Traverses the entire tree and returns values as follows:
// Returns p, if root's subtree includes p (and not q).
// Returns q, if root's subtree includes q (and not p).
// Returns null, if neither p nor q are in root's subtree.
// Else, returns the common ancestor of p and q.

// TC: O(n), SC: O(log(n))
public TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
	if (root == null) return null;
	TreeNode x = commonAncestor2(root.left, p, q);
	TreeNode y = commonAncestor2(root.right, p, q)
	if (root != p && root != q && x == null && y == null)
		return null;
	if (root == p) {
		if (x == q || y == q)
			return root;
		return p; 	// actually, root == p here. Can not distinguish if q is in subtree
	}
	if (root == q) {
		if (x == p || y == p)
			return root;
		return q;
	}
	return x == null ? y : x;
}

// two solution to resolve the above problem
// 1. first search the tree once and see if both p and q are in tree
// 2. return two values(can be a result class) to distinguish if p or q is in subtree.