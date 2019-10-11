package stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
	List<Integer> list;
	
	/** initialize your data structure here. */
	public MinStack() {
		list  = new ArrayList<Integer>();
	}

	public void push(int x) {
		list.add(x);
	}

	public void pop() {
		list.remove(list.size() - 1);
	}

	public int top() {
		return list.get(list.size() - 1);
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min)
				min = list.get(i);
		}

		return min;
	}
}
