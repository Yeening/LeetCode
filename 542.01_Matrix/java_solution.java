class Solution {
    int[] dirs = new int[]{-1, 0, 1, 0, -1};
    int m;
    int n;
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(i*n + j);
                    res[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / n, j = cur % n;
            for (int k = 0; k < 4; k++) {
                int nextI = i + dirs[k], nextJ = j + dirs[k+1];
                if (isValid(nextI, nextJ, res)) {
                    res[nextI][nextJ] = res[i][j] + 1;
                    queue.offer(nextI * n + nextJ);
                }
            }
        }
        
        return res;
    }
    
    private boolean isValid(int i, int j, int[][] res) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {return false;}
        if (res[i][j] > -1) {return false;}
        return true;
    }
}
