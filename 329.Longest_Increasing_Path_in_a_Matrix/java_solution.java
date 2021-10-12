// DFS + memo, O(mn) time, O(mn) space
class Solution {
    int[] dirs = new int[]{-1, 0, 1, 0, -1};
    int M;
    int N;
    public int longestIncreasingPath(int[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;
        int[][] memo = new int[M][N];
        int longestPath = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int length = longestStartPath(matrix, i, j, memo);
                longestPath = Math.max(length, longestPath);
            }
        }
        return longestPath;
    }
    // pre-condition: 
    private int longestStartPath(int[][] matrix, int i, int j, 
                                int[][] memo) {
        if (memo[i][j] != 0) {return memo[i][j];}
        int length = 1;
        for (int k = 0; k < 4; k++) {
            int nextI = i + dirs[k], nextJ = j + dirs[k+1];
            if (nextI < 0 || nextI > M - 1 || 
                nextJ < 0 || nextJ > N - 1 || 
                matrix[i][j] >= matrix[nextI][nextJ]) {continue;}
            length = Math.max(length, 
                        longestStartPath(matrix, nextI, nextJ, memo) + 1);
        }
        memo[i][j] = length;
        return length;
    }
}
