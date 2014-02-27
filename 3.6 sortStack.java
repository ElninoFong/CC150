3.6 Write a program to sort a stack in ascending order (with biggest items on top). You may use at most one additional stack to hold items, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.

// TC: O(n^2), SC: O(n)
void sortStack(Stack<Integer> st) {
	if (st == null) return;
	Stack<Integer> buffer = new Stack<Integer>();
	int tmp;

	while (!st.empty()) {
		tmp = st.pop();
		if (buffer.empty() || tmp <= buffer.peek()) {
			// push to buffer
			buffer.push(tmp);
		} else {
			// push back to st
			while (!buffer.empty() && tmp > buffer.peek()) {
				st.push(buffer.pop());
			}
			// push tmp to buffer
			buffer.push(tmp);
		}
	}

	// push all back to st
	while (!buffer.empty()) {
		st.push(buffer.pop());
	}
}

// It would be better if we put the sorted elements in buffer and return buffer.