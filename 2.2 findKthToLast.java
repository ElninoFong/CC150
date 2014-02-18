2.2 Implement an algorithm to find the kth to last element of a singly linked list.

// use "Runner" technique
// assume 0th to last means the last element
// TC: O(n), SC: O(1)
LinkedListNode findKthToLast(LinkedListNode head, int k) {
	LinkedListNode runner = head;
	LinkedListNode node = head;
	// Linked list less than k elements
	while(k-- > 0) {
		if (runner == null || runner.next == null)
			return null;
		runner = runner.next;
	}

	while(runner.next != null) {
		node = node.next;
		runner = runner.next;
	}
	return node;
}

// Recursive 1
// assume 0th to last means the last element
// TC: O(n), SC: O(n)
int findKthToLast2(LinkedListNode head, int k) {
	if (head == null) // throw execption
	if (head.next == null) {
		if (k == 0) 
			System.out.println(head.data);
		return 0;
	}
	int level = findKthToLast2(head.next, k) + 1;
	if (k == level)
		System.out.println(head.data);
	return level;
}

// Recursive 2
// use IntWrapper
public class IntWrapper {
		public int value = -1;
	}
LinkedListNode findKthToLast3(LinkedListNode head, int k, IntWrapper i) {
	if (head == null) return null;
	LinkedListNode node = findKthToLast3(head.next, k, i);
	i.value = i.value + 1;
	if (i.value == k)
		return head;
	return node;
}
