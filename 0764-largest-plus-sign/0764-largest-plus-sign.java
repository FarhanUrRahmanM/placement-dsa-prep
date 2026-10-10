class Solution {
	public int orderOfLargestPlusSign(int n, int[][] mines) {
		int[][] grid = new int[n][n];

		for (int i = 0; i < n; i++) {
			java.util.Arrays.fill(grid[i], n);
		}

		for (int[] mine : mines) {
			grid[mine[0]][mine[1]] = 0;
		}

		for (int i = 0; i < n; i++) {
			int count = 0;

			for (int j = 0; j < n; j++) {
				count = grid[i][j] == 0 ? 0 : count + 1;
				grid[i][j] = Math.min(grid[i][j], count);
			}

			count = 0;

			for (int j = n - 1; j >= 0; j--) {
				count = grid[i][j] == 0 ? 0 : count + 1;
				grid[i][j] = Math.min(grid[i][j], count);
			}
		}

		int result = 0;

		for (int j = 0; j < n; j++) {
			int count = 0;

			for (int i = 0; i < n; i++) {
				count = grid[i][j] == 0 ? 0 : count + 1;
				grid[i][j] = Math.min(grid[i][j], count);
			}

			count = 0;

			for (int i = n - 1; i >= 0; i--) {
				count = grid[i][j] == 0 ? 0 : count + 1;
				grid[i][j] = Math.min(grid[i][j], count);
				result = Math.max(result, grid[i][j]);
			}
		}

		return result;
	}
}