package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		if (tokens.length == 0)
			return 0;
		if (tokens.length == 1)
			return Integer.parseInt(tokens[0]);

		Stack<Integer> st = new Stack<Integer>();
		int n1, n2;

		for (int i = 0; i < tokens.length; ++i) {
			switch (tokens[i]) {
			case "+":
				st.push(st.pop() + st.pop());
				break;
			case "-":
				st.push(-st.pop() + st.pop());
				break;
			case "/":
				n2 = st.pop();
				n1 = st.pop();
				st.push(n1 / n2);
				break;
			case "*":
				st.push(st.pop() * st.pop());
				break;
			default:
				st.push(Integer.parseInt(tokens[i]));
			}
		}

		return st.peek() > Integer.MAX_VALUE ? Integer.MAX_VALUE : st.pop();
	}
}
