class Solution {
    //Solution 1
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     int[][] dp = new int[m+1][n+1];
    //     dp[0][1] = 1;
    //     for(int i = 1; i <= m; i++){
    //         for(int j = 1; j <=n; j++){
    //             if(obstacleGrid[i-1][j-1] ==1){
    //                 dp[i][j] = 0;
    //                 continue;
    //             }
    //             dp[i][j] = dp[i-1][j] + dp[i][j-1];
    //         }
    //     }
    //     return dp[m][n];
    // }
    //Solution2 store in a n-size array
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] ==1){
                    dp[j] = 0;
                    continue;
                }
                if(j > 0) dp[j] += dp[j-1];                
            }
        }
        return dp[n-1];
    }
}
