4.5 Implement a function to check if a binary tree is a binary search tree.

// 1. all left subtree nodes <= node < all right subtree nodes (MIN MAX solution)
// 2. use in-order traverse (can not handle node <= all right subtree nodes)

// 1
// TC: O(n), SC: O(log(n))
public boolean isBST(TreeNode root) {
	return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
}

boolean isBST(TreeNode node, int min, int max) {
	if (node == null) return true;
	if (node.data > max || node.data <= min) return false;
	return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
}


//2
// TC: O(n), SC:O (n)
public boolean isBST2(TreeNode node) {
	ArrayList<Integer> arr = new ArrayList<Integer>();
	helper(node, arr);
	if (arr.size() < 2) return true;
	for (int i = 1; i < arr.size(); i++) {
		if (arr[i] < arr[i - 1])
			return false;
	}
	return true;
}

void helper(TreeNode node, ArrayList<Integer> arr) {
	if (node == null) return;
	helper(node.left, arr);
	arr.add(node.data);
	helper(node.right, arr);
}

// 2
// not use additional ArrayList, only use a static int
// TC: O(n), SC: O(log(n))
public static int last_printed = Integer.MIN_VALUE;
public boolean isBST3(TreeNode node) {
	if (node == null) return true;
	if (!isBST3(node.left)) return false;
	if (node.data < last_printed) return false;
	last_printed = node.data;
	if (!isBST3(node.right)) return false;
	return true;
}