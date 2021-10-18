class Solution {
    // distFromStart, remainingK
    // if grid[i][j] == 1, remainingK[i][j] == 0, invalid
    // we only re-visit a point if we can make it with less block-elimination
    // time: O(mnk), space: O(mnk)
    static final int[] dirs = new int[] {-1, 0, 1, 0, -1};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] remainingK = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(remainingK[i], -1);
        }
        // [i,j,remainingK]
        Queue<int[]> queue = new ArrayDeque<>();
        if (grid[0][0] == 1) {k--;}
        if (k < 0) {return -1;}
        queue.offer(new int[]{0,0,k});
        remainingK[0][0] = k;
        int curDis = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1], curK = cur[2];
                if (i == m - 1 && j == n - 1) {return curDis;}
                for (int d = 0; d < 4; d++) {
                    int nextI = i + dirs[d], nextJ = j + dirs[d+1];
                    if (nextI < 0 || nextI > m - 1 || 
                       nextJ < 0 || nextJ > n - 1) {continue;}
                    int nextK = curK - grid[nextI][nextJ];
                    if (nextK < 0) {continue;}
                    if (nextK > remainingK[nextI][nextJ]) {
                        queue.offer(new int[]{nextI, nextJ, nextK});
                        remainingK[nextI][nextJ] = nextK;
                    }
                }
            }
            curDis++;
        }
        
        return -1;
    }
}
