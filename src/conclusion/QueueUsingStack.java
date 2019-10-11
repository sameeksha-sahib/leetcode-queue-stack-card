package conclusion;

import java.util.Stack;

public class QueueUsingStack {
	public class usingStackGet {
		Stack<Integer> st;
		int first, size;

		/** Initialize your data structure here. */
		public usingStackGet() {
			st = new Stack<Integer>();
			first = 0;
			size = 0;
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			st.push(x);
			size++;
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			size--;
			int res = st.get(first);
			first++;
			return res;
		}

		/** Get the front element. */
		public int peek() {
			return st.get(first);
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return size == 0;
		}
	}

	public class MyQueue {

		Stack<Integer> s1, s2;
		int first;

		/** Initialize your data structure here. */
		public MyQueue() {
			s1 = new Stack<Integer>();
			s2 = new Stack<Integer>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			if (s1.isEmpty())
				first = x;
			s1.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			if (s2.isEmpty()) {
				while (!s1.isEmpty())
					s2.push(s1.pop());
			}

			return s2.pop();
		}

		/** Get the front element. */
		public int peek() {
			if (s2.isEmpty())
				return first;
			return s2.peek();
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return (s1.isEmpty() && s2.isEmpty());
		}
	}
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
