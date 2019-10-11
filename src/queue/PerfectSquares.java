package queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
	public int numSquaresBFS(int n) {
		if (n == 0 || n == 1)
			return n;

		int tmp = (int) Math.sqrt(n);
		if (tmp * tmp == n)
			return 1;

		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] vis = new boolean[n];
		int size = 0, res = 0, sum;

		q.add(0);
		vis[0] = true;
		while (!q.isEmpty()) {
			size = q.size();
			res++;
			for (int i = 0; i < size; ++i) {
				tmp = q.poll();
				for (int j = 1; j * j <= n; j++) {
					sum = tmp + j * j;
					if (sum == n)
						return res;
					if (sum > n)
						break;
					if (!vis[sum]) {
						q.add(sum);
						vis[sum] = true;
					}
				}
			}
		}

		return res;
	}

	/*
	 * Based on Lagrange's Four Square theorem, any natural number can be
	 * represented as sum of 4 perfect squares. e.g 1 = 0*0 + 0*0 + 0*0 + 1*1 2 =
	 * 0*0 + 0*0 + 1*1 + 1*1 Therefore, there are only 4 possible results: 1, 2, 3,
	 * 4. Also, based on Legendre's three-square theorem, any natural number can be
	 * represented as sum of 3 perfect squares, except if number can be written as a
	 * form of 4*a (8*b + 7) where a,b are non negative integers, then it requires
	 * sum of 4 perfect squares
	 */
	public int numSquaresMaths(int n) {
		if (n == 0 || n == 1)
			return n;

		// If n is a perfect square, return 1.
		if (is_square(n))
			return 1;

		// The result is 4 if and only if n can be written in the
		// form of 4^a*(8*b + 7).
		while ((n & 3) == 0) // n%4 == 0, i.e number be written as multiple of 4 for part 4a
			n >>= 2;
		if ((n & 7) == 7) // n%8 == 7, i.e remaining n can be written as 8b + 7
			return 4;

		// Check whether 2 is the result. (I don't understand this logic, please explain
		// in comments if someone gets it.
		int sqrt_n = (int) (Math.sqrt(n));
		for (int i = 1; i <= sqrt_n; i++) {
			if (is_square(n - i * i))
				return 2;
		}

		return 3;

	}

	private boolean is_square(int n) {
		int sqrt_n = (int) (Math.sqrt(n));
		return (sqrt_n * sqrt_n == n);
	}

}
