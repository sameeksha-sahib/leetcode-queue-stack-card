package conclusion;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	Queue<Integer> q1;
	int size;

	/** Initialize your data structure here. */
	public StackUsingQueues() {
		q1 = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		q1.add(x);
        size = q1.size();
        while(size-- > 1) {
            q1.add(q1.poll());
        }
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return q1.poll();
	}

	/** Get the top element. */
	public int top() {
		return q1.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return (q1.isEmpty());
	}
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
