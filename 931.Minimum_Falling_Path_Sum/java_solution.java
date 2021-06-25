class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int[][] dp = new int[n][n+2];
        for (int i = 0; i < n; i++) {
            dp[0][i+1] = matrix[0][i];
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][n+1] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n + 1; j++) {
                int minSum = Math.min(
                        Math.min(dp[i-1][j-1], dp[i-1][j+1]), 
                        dp[i-1][j]);
                dp[i][j] = minSum + matrix[i][j-1];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            res = Math.min(res, dp[n-1][i]);
        }
        return res;
    }
}
