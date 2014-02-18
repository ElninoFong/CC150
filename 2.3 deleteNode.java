2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
EXAMPLE
Input: the node c from the linked list a->b->c->d>e
Result: nothing is returned, but the new linked list looks like a->b->d->e

// TC: O(1), SC: O(1)
void deleteNode(LinkedListNode node) {
	if (node == null) return;
	// check if it is the last node
	if (node.next == null) {
		node = null;
	}
	// copy
	node.data = node.next.data;
	node.next = node.next.next;
	return;
}