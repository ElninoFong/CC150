3.2 How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? Push, pop and min should all operate in O(1) time.

// when the min is poped, how to find the next min?

public class Stack {
	LinkedListNode st;
	LinkedListNode min;

	void push(int value) {
		LinkedListNode n = new LinkedListNode(value);
		if (st == null) {
			st = n;
		} else {
			n.next = st;
			st = n;
		}
		// record the min
		if (min == null) {
			LinkedListNode min = new LinkedListNode(value);
		} else if (min.data >= value) {
			LinkedListNode m = mew LinkedListNode(value);
			m.next = min;
			min = m;
		}
	}

	int pop() throws Exception{
		if (st == null) 
			throw Exception("Empty");
		int value = st.data;
		st = st.next;
		// check min
		if (value == min.data)
			min = min.next;
		return value;
	}

	int min() throws Exception{
		if (min == null) 
			throw Exception("Empty");
		return min.data;
	}
}

// Or our new StackWithMin class should extends Stack, and use to stacks in it.
// Will have better pattern design