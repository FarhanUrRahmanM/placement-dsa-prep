class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                q.offer(new int[]{i, 0});
                grid[i][0] = 0;
            }
            if (grid[i][n - 1] == 1) {
                q.offer(new int[]{i, n - 1});
                grid[i][n - 1] = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                q.offer(new int[]{0, j});
                grid[0][j] = 0;
            }
            if (grid[m - 1][j] == 1) {
                q.offer(new int[]{m - 1, j});
                grid[m - 1][j] = 0;
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];

                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                    grid[r][c] = 0;
                    q.offer(new int[]{r, c});
                }
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}