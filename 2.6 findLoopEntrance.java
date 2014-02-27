2.6 Given a circular linked list, implement an algorithm which returns the node at he beginning of the loop.
EXAMPLE
Input: A -> B -> C -> D -> E -> C
Output: C

// two pointers: slowRunner one step each time, fastRunner two steps each time
// when slowRunner move k steps to the loop entrance, the fastRunner has run k steps in the loop.
// so fastRunner is mod(k - LOOP_SIZE) = K steps ahead of slowRunner, it will catch up slowRunner in LOOP_SIZE - K steps.
// make they both run one step each time. and make slowRunner to the head, they will meet again in the loop entrance.

LinkedListNode findLoopEntrance(LinkedListNode head) {
	LinkedListNode slowRunner = head;
	LinkedListNode fastRunner = head;
	while (slowRunner != fastRunner) {
		if (fastRunner == null || fastRunner.next == null) {
			return null;	// no collision
		}
		slowRunner = slowRunner.next;
		fastRunner = fastRunner.next.next;
	}
	slowRunner = head;
	while (slowRunner != fastRunner) {
		slowRunner = slowRunner.next;
		fastRunner = fastRunner.next;
	}
	return slowRunner;
}