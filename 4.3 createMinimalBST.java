4.3 Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.

// use the mid point to be the root, use the mid point of the left half array as left child, use the mid point of the right half array as right child. recurse.
pulbic TreeNode createMinimalBST(int[] arr) {
	if (arr == null) return null;
	TreeNode root = helper(arr, 0, arr.length - 1));
	return root;
}

TreeNode helper(int[] arr, int left, int right) {
	if (left < right) return null;
	int mid = ((left + right) / 2) + 1;
	TreeNode node = new TreeNode(arr[mid]);
	node.left = helper(arr, left, mid - 1);
	node.right = helper(arr, mid + 1, right);
	return node;
}
