package queue;

public class NumberOfIslands {
	int n = 0, m = 0;

	public int numIslands(char[][] grid) {
		n = grid.length;
		if (n == 0)
			return 0;
		m = grid[0].length;
		int c = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (grid[i][j] == '1') {
					explore(grid, i, j);
					c++;
				}
			}
		}

		return c;
	}

	public void explore(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
			return;
		grid[i][j] = 0;
		explore(grid, i + 1, j);
		explore(grid, i - 1, j);
		explore(grid, i, j + 1);
		explore(grid, i, j - 1);
	}

}
