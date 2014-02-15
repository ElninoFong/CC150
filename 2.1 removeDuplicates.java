2.1 Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?

// hashset
// TC: O(n), SC: O(n)
LinkedListNode removeDuplicates(LinkedListNode head) {
	if (head == null) return null;
	HashSet hs = new HashSet();
	LinkedListNode cur = head;
	LinkedListNode n = head;
	while(n != null) {
		if (hs.contains(n.data)) {
			cur.next = n.next;
		} else {
			hs.append(n.data);
			cur = n;
		}
		n = n.next;
	}
	return head;
}

// no temporary buffer
// TC: O(n^2), SC: O(1)
LinkedListNode removeDuplicates2(LinkedListNode head) {
	if (head == null) return null;
	LinkedListNode p1 = head;
	while (p1 != null) {
		LinkedListNode p2 = p1;
		while (p2.next != null) {
			if (p1.data == p2.next.data) {
				p2.next = p2.next.next;
			} else {
				p2 = p2.next;
			}
		}
		p1 = p1.next;
	}
	return head;
}

// no temporary buffer
// use prev node
// TC: O(n^2), SC: O(1)
LinkedListNode removeDuplicates2(LinkedListNode head) {
	if (head == null) return null;
	LinkedListNode p1 = head;
	while (p1 != null) {
		LinkedListNode prev = p1;
		LinkedListNode p2 = p1.next;
		while (p2 != null) {
			if (p1.data == p2.data) {
				prev.next = p2.next;
			} else {
				prev = p2;
			}
			p2 = p2.next;
		}
		p1 = p1.next;
	}
	return head;
}