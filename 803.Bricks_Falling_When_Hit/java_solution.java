class Solution {
    int N;
    int M;
    int[][] dirs = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    /**
    States: 
    -1: hit
    1: brick started, but will fall
    2: stable
     */
    public int[] hitBricks(int[][] grid, int[][] hits) {
        N = grid.length;
        if (N == 0) {
            return new int[hits.length];
        }
        M = grid[0].length;

        // mark all bricks that will be hit as -1
        for (int[] hit: hits) {
            int i = hit[0], j = hit[1];
            if (grid[i][j] == 1) {
                grid[i][j] = -1;
            }
        }

        // mark all bricks that's stable as 2 using BFS
        Queue<int[]> q = new LinkedList<>();
        for (int j = 0; j < M; j++) {
            if (grid[0][j] == 1) {
                q.offer(new int[]{0, j});
                grid[0][j] = 2;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir: dirs) {
                int i = cur[0] + dir[0], j = cur[1] + dir[1];
                if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] != 1) continue;
                grid[i][j] = 2;
                q.offer(new int[]{i, j});
            }
        }

        // all bricks that will fall are now marked as 1

        // reverse restore bricks using DFS
        int[] res = new int[hits.length];
        for (int k = hits.length - 1; k >= 0; k--) {
            int i = hits[k][0], j = hits[k][1];
            if (grid[i][j] != -1) continue;

            // a brick will become connected if it's either on the top or has a stable neighbor
            if (i != 0 && !hasStableNeighbor(grid, i, j)) {
                // (i, j) will not become connected after restoration, thus no neighbors will become connected
                grid[i][j] = 1;
                continue;
            }

            grid[i][j] = 2;
            res[k] = dfs(grid, i, j);
        }

        return res;
    }

    private boolean hasStableNeighbor(int[][] grid, int i, int j) {
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= N || y < 0 || y >= M || grid[x][y] != 2) continue;
            return true;
        }
        return false;
    }

    private int dfs(int[][] grid, int i, int j) {
        int restore = 0;
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= N || y < 0 || y >= M || grid[x][y] != 1) continue;
            grid[x][y] = 2;
            restore++;
            restore += dfs(grid, x, y);
        }

        return restore;
    }
}
