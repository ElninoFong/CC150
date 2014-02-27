3.3 Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.

public class SetOfStacks {
	int thresholdSize;
	ArrayList<StackWithSize> stackSet;

	void push(int value) {
		StackWithSize lastSWS = stackSet.get(stackSet.size() - 1); // get the last one
		if (lastSWS.size < thresholdSize) {
			lastSWS.stack.push(value);
			lastSWS.size++;
		} else {
			Stack<Integer> st = new Stack<Integer>();
			st.push(value);
			StackWithSize additionSWS = new StackWithSize(st, 1);
			stackSet.add(additionSWS); 
		}
	}

	int pop() throws Exception {
		StackWithSize lastSWS = stackSet.get(stackSet.size() - 1); // get the last one
		if (stackSet.size() == 1 && lastSWS.size == 0)
			throw Exception("Empty");
			
		lastSWS.size--;

		// pop from one stack
		if (lastSWS.size > 0) {
			return lastSWS.stack.pop();
		}

		// last stack is empty
		if (stackSet.size() > 1) {
			int value = lastSWS.stack.pop();
			stackSet.remove(stackSet.size() - 1);
			return value;
		}

		// empty in the whole set
		if (stackSet.size() == 1) {
			return value = lastSWS.stack.pop();
		}
	}

	class StackWithSize {
		Stack<Integer> stack;
		int size;

		public StackWithSize(Stack<Integer> _stack, int _size) {
			stack = _stack;
			size = _size;
		}
	}
}