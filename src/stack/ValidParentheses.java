package stack;

import java.util.Stack;

public class ValidParentheses {

	// runtime 1ms
	public boolean isValidSB(String s) {
		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < sb.length(); ++i) {
			if (i == 0 && (sb.charAt(i) == ')' || sb.charAt(i) == ']' || sb.charAt(i) == '}')) {
				return false;
			}

			if (i > 0 && (sb.charAt(i) == ')' || sb.charAt(i) == ']' || sb.charAt(i) == '}')) {
				switch (sb.charAt(i)) {
				case ')':
					if (sb.charAt(i - 1) == '(') {
						break;
					} else {
						return false;
					}
				case ']':
					if (sb.charAt(i - 1) == '[') {
						break;
					} else {
						return false;
					}
				case '}':
					if (sb.charAt(i - 1) == '{') {
						break;
					} else {
						return false;
					}
				}
				sb.deleteCharAt(i);
				sb.deleteCharAt(i - 1);
				i = i - 2;
			}
		}

		return (sb.length() == 0);
	}

	// runtime 2ms
	public boolean isValidStack(String s) {
		if (s.isEmpty())
			return true;
		if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
			return false;

		Stack<Character> st = new Stack<Character>();
		st.push(s.charAt(0));
		char c, ci = s.charAt(0);

		for (int i = 1; i < s.length(); ++i) {
			ci = s.charAt(i);
			if (st.size() != 0) {
				c = st.peek();
				switch (ci) {
				case ')':
					if (c == '(') {
						st.pop();
						break;
					} else {
						return false;
					}

				case ']':
					if (c == '[') {
						st.pop();
						break;
					} else {
						return false;
					}

				case '}':
					if (c == '{') {
						st.pop();
						break;
					} else {
						return false;
					}

				default:
					st.push(ci);
				}
			} else if (ci == ')' || ci == ']' || ci == '}')
				return false;
			else
				st.push(ci);

		}

		return st.size() == 0;
	}

	// runtime 1ms
	public boolean isValidStack2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
