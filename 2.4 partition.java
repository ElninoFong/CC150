2.4 Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.

// use four pointers to mark the start and end of two parts(greater and less)
// TC: O(n), SC: O(n)
LinkedListNode partition(LinkedListNode head, int x) {
	if (head == null) return null;
	LinkedListNode frontStart = null;
	LinkedListNode frontEnd = null;
	LinkedListNode behindStart = null;
	LinkedListNode behindEnd = null;
	while (head != null) {
		if (head.data < x) {
			if (frontStart == null) {
				frontStart = head;
				frontEnd = head;
			} else {
				frontEnd.next = head;
				frontEnd = head;
			}
		} else {
			if (behindStart == null) {
				behindStart = head;
				behindEnd = head;
			} else {
				behindEnd.next = head;
				behindEnd = head;
			}
		}
		head = head.next;
	}
	// connect two parts
	if (frontEnd == null) {
		return behindStart;
	}
	frontEnd.next = behindStart;
	if (behindEnd != null) {
		behindEnd.next = null;
	}

	return frontStart;
}