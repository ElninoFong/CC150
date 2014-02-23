4.1 Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.

// call getHeight to all one node's subtree.
// TC: O(n^2), SC: O(H)
int getHeight(TreeNode node) {
	if (node == null) return 0;
	return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
}

boolean isBalanced(TreeNode root) {
	if (root == null) return true;
	int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
	if (diff > 1) return false;
	return isBalanced(root.left) && isBalanced(root.right);
}