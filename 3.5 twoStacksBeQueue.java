3.5 Implement a MyQueue class which implements a queue using two stacks.

// Two stacks st1 and st2. If st2 is empty, push st1 elements into st2 in reversed order.
public class MyQueue {
	Stack<Integer> st1;
	Stack<Integer> st2;

	public MyQueue() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}

	void push(int value) {
		st1.push(value);
	}

	int pop() {
		if (!st2.empty()) return st2.pop();
		// if empty, push st1 elements into st2 in reversed order
		while (!st1.empty()) {
			st2.push(st1.pop());
		}
		return st2.pop();
	}

	int peek() {
		if (!st2.empty()) return st2.peek();
		// if empty, push st1 elements into st2 in reversed order
		while (!st1.empty()) {
			st2.push(st1.pop());
		}
		return st2.peek();
	}

	boolean empty() {
		return st1.empty() && st2.empty();
	}
}

// Two improvements for the above solution.
// 1. we can use MyQueue<T>
// 2. if st2 is empty, we push st1 --> st2. This is used twice, better have a function.
public class MyQueue<T> {
	Stack<T> st1;
	Stack<T> st2;

	public MyQueue() {
		st1 = new Stack<T>();
		st2 = new Stack<T>();
	}

	void push(T value) {
		st1.push(value);
	}

	private void shift() {
		if (st2.empty()) {
			while (!st1.empty()) {
				st2.push(st1.pop());
			}
		}
	}

	T pop() {
		shift();
		return st2.pop();
	}

	T peek() {
		shift();
		return st2.peek();
	}

	boolean empty() {
		return st1.empty() && st2.empty();
	}
}