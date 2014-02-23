2.5 You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
Input: (6 -> 1 -> 7) + (2  -> 9 -> 5). That is, 617 + 295.
Output: 9 -> 1 -> 2. That is, 912.

// TC: O(max(m,n)), SC: O(max(m,n))
// the code is too long
LinkedListNode addReversedLists(LinkedListNode n1, LinkedListNode n2) {
	int carry = 0;
	LinkedListNode head = null;
	LinkedListNode n = null;
	while (n1 != null && n2 != null) {
		int sum = n1.data + n2.data + carry;
		LinkedListNode node = new LinkedListNode(sum%10);
		if (head == null) {
			head = node;
		} else {
			n.next = node;
		}
		n = node;
		if (sum >= 10) {
			carry = 1;
		} else {
			carry = 0;
		}
		n1 = n1.next;
		n2 = n2.next;
	}
	while (n1 != null) {
		int sum = n1.data + carry;
		LinkedListNode node = new LinkedListNode(sum%10);
		if (head == null) {
			head = node;
		} else {
			n.next = node;
		}
		n = node;
		if (sum >= 10) {
			carry = 1;
		} else {
			carry = 0;
		}
		n1 = n1.next;
	}
	while (n2 != null) {
		int sum = (Integer)n2.data + carry;
		LinkedListNode node = new LinkedListNode(sum%10);
		if (head == null) {
			head = node;
		} else {
			n.next = node;
		}
		n = node;
		if (sum >= 10) {
			carry = 1;
		} else {
			carry = 0;
		}
		n2 = n2.next;
	}
	while (carry > 0) {
		LinkedListNode node = new LinkedListNode(carry);
		n.next = node;
		n = node;
		carry = 0;
	}
	return head;
}

// shorter one
LinkedListNode addReversedLists2(LinkedListNode n1, LinkedListNode n2) {
	int carry = 0;
	LinkedListNode head = null;
	while (n1 != null || n2 != null || carry > 0) {
		int sum = carry;
		if (n1 != null) sum += (int)n1.data;
		if (n2 != null) sum += (int)n2.data;
		LinkedListNode node = new LinkedListNode(sum % 10);
		if (head == null) {
			head = node;
		} else {
			head.addLast(node);
		}
		carry = sum / 10;
		if (n1 != null) n1 = n1.next;
		if (n2 != null) n2 = n2.next;
	}
	return head;
}


// =================================================================================
// FOLLOW UP
LinkedListNode addLists(LinkedListNode n1, LinkedListNode n2, IntegerWrapper iw) {
	if (n1 == null && n2 == null && iw.carry == 0) return null;
	LinkedListNode n = addLists(n1 == null ? n1 : n1.next,
							   n2 == null ? n2 : n2.next,
							   iw);
	int sum = (int)iw.carry;
	if (n1 != null) sum += (int)n1.data;
	if (n2 != null) sum += (int)n2.data;
	LinkedListNode res = new LinkedListNode(sum % 10);
	res.next = n;
	iw.carry = sum / 10;
	return res;
}

static class IntegerWrapper {
	int carry = 0;
}

static LinkedListNode addZeros(LinkedListNode n1, int len) {
	while (len-- > 0) {
			LinkedListNode node = new LinkedListNode(0);
			node.next = n1;
			n1 = node;
	} 
	return n1;
}

public static void main(String[] args) {
	IntegerWrapper iw = new IntegerWrapper();
	int len1 = n1.length();
	int len2 = n2.length();
	if (len1 < len2) {
		n1 = cc2_5.addZeros(n1, len2 - len1);
	} else {
		n2 = cc2_5.addZeros(n2, len1 - len2);
	}
	LinkedListNode head3 = cc2_5.addLists(n1, n2, iw);
	if (iw.carry > 0) {
		LinkedListNode newHead = new LinkedListNode(iw.carry);
		newHead.next = head3;
		head3 = newHead;
	}
	LinkedListNode.print(n1);
	LinkedListNode.print(n2);
	LinkedListNode.print(head3);
	System.out.println("Stopped");
}