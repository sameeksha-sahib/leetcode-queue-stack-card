package conclusion;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resStack = new Stack<>();
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = 10 * count + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(count);
			} else if (s.charAt(idx) == '[') {
				resStack.push(res.toString());
				res.delete(0, res.length());
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder temp = new StringBuilder(resStack.pop());
				int repeatTimes = countStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res.delete(0, res.length());
				res.append(temp);
				idx++;
			} else {
				res.append(s.charAt(idx++));
			}
		}
		return res.toString();
	}
}
