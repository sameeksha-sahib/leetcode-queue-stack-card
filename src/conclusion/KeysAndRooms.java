package conclusion;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		if (n <= 1)
			return true;
		HashSet<Integer> set = new HashSet<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		set.add(0);
		while (!st.isEmpty()) {
			for (int key : rooms.get(st.pop())) {
				if (!set.contains(key)) {
					set.add(key);
					st.push(key);
				}
			}
		}

		return set.size() == n;
	}
}
