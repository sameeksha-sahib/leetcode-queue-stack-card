package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class OpenLock {

	public int openLockBFS(String[] deadends, String target) {
		HashSet<String> dead = new HashSet<String>(Arrays.asList(deadends));
		HashSet<String> vis = new HashSet<String>();
		int level = 0, size;
		Queue<String> q = new LinkedList<String>();

		q.add("0000");
		vis.add("0000");
		StringBuilder sb;
		char c;

		while (!q.isEmpty()) {
			size = q.size();
			for (int i = 0; i < size; ++i) {
				String s = q.poll();
				if (target.equals(s))
					return level;
				if (dead.contains(s))
					continue;

				sb = new StringBuilder(s);
				for (int j = 0; j < 4; ++j) {
					c = sb.charAt(j);
					String s1 = sb.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(j + 1);
					String s2 = sb.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(j + 1);
					if (!vis.contains(s1) && !dead.contains(s1)) {
						q.add(s1);
						vis.add(s1);
					}
					if (!vis.contains(s2) && !dead.contains(s2)) {
						q.add(s2);
						vis.add(s2);
					}
				}
			}
			level++;
		}
		return -1;
	}
}
