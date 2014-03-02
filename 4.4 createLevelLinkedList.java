4.4 Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

public ArrayList<LinkedList<TreeNode> > createLevelLinkedList(TreeNode root) {
	ArrayList<LinkedList<TreeNode> > result = new ArrayList<LinkedList<TreeNode> >();
	LinkedList<TreeNode> next = new LinkedList<TreeNode>();
	if (root != null) {
		next.add(root);
	}
	while (next.size() > 0) {
		result.add(next);
		LinkedList<TreeNode> current = next;
		next = new LinkedList<TreeNode>();
		for (TreeNode node : current) {
			if (node.left != null) next.add(node.left);
			if (node.right != null) next.add(node.right);
		}
	}
	return result;
}