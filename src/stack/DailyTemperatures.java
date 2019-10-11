package stack;

import java.util.Stack;

public class DailyTemperatures {
	
	// runtime 40ms
	public int[] dailyTemperaturesStack(int[] T) {
		int n = T.length;
		if (n <= 1)
			return new int[] { 0 };
		Stack<Integer> st = new Stack<Integer>();
		int[] res = new int[n];
		int index = 0;
		for (int i = 0; i < n; ++i) {
			while (!st.isEmpty() && T[i] > T[st.peek()]) {
				index = st.pop();
				res[index] = i - index;
			}
			st.push(i);
		}
		return res;
	}

	// runtime 221ms
	public int[] dailyTemperatures(int[] T) {
		int n = T.length;
		if (n <= 1)
			return new int[] { 0 };
		boolean isFound = false;
		int[] res = new int[n];
		for (int i = 0; i < n; ++i) {
			int j = i + 1;
			for (; j < n; ++j) {
				if (T[j] > T[i]) {
					isFound = true;
					break;
				}
			}
			if (isFound) {
				res[i] = j - i;
				isFound = false;
			} else
				res[i] = 0;
		}
		return res;
	}
}
