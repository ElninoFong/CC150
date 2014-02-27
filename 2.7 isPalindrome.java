2.7 Implement a function to check if a linked list is a palindrome.

// Reverse the linked list and check
// Only need to check half part of them
// TC: O(n), SC: O(n)
// 1. recursion
LinkedListNode reverseHelper(LinkedListNode prev, LinkedListNode head) {
	if (head == null) return prev;
	LinkedListNode res = reverseHelper(head, head.next);
	head.next = prev;
	return res;
}

LinkedListNode reverse(LinkedListNode head) {
	return reverseHelper(null, head);
}

// 2. non-recursion
LinkedListNode reverse(LinkedListNode head) {
	LinkedListNode prev = null;
	LinkedListNode tmp;
	while (head != null) {
		tmp = head.next;
		head.next = prev;
		prev = head;
		head = tmp;
	}
	return prev;
}

///////////////////////////////////////////////////////////////////////////////
// use stack to store the first half part, then check with the second half part
// TC: O(n), SC: O(n)
boolean isPalindrome1(LinkedListNode head) {
	int len = LinkedListNode.length(head);
	if (len < 2) return true;
	Stack st = new Stack();
	for (int i = 1; i <= len / 2; i++) {
		st.push(head.data);
		head = head.next;
	}
	// if len is odd
	if (len % 2 != 0) {
		head = head.next;
	} 
	while (head != null) {
		if (head.data != st.pop())
			return false;
		head = head.next;
	}
	return true;
}

// same as previous except using slow and fast runner
// TC: O(n), SC: O(n)
boolean isPalindrome2(LinkedListNode head) {
	Stack st = new Stack();
	LinkedListNode slow = head;
	LinkedListNode fast = head;
	while (fast != null && fast.next != null) {
		st.push(slow.data);
		slow = slow.next;
		fast = fast.next.next;
	}
	// if length is odd
	if (fast != null)	// cannot use if (fast.next == null) here.
		slow = slow.next;

	while (slow != null) {
		if (slow.data != st.pop())
			return false;
		slow = slow.next;
	}
	return true;
}

///////////////////////////////////////////////////////////////////////////////
// check recursively
// TC: O(n), SC: O(n)
class Result {
	LinkedListNode n;
	boolean b;
	public Result(LinkedListNode n, boolean b) {
		this.n = n;
		this.b = b;
	}
}

Result helper(LinkedListNode node, int len) {
	if (len == 0) {
		return new Result(node, true);
	}
	if (len == 1) {
		return new Result(node.next, true);
	}
	Result res = helper(node.next, len - 2);
	return new Result(res.n.next, (res.b && (node.data == res.n.data)));
}

boolean isPalindrome3(LinkedListNode head) {
	int len = length(head);
	Result res = helper(head, len);
	return res.b;
}