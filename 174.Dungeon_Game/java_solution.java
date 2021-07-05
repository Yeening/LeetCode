class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        // dp[i][j]: least hp need from (i,j) to (m-1,n-1)
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = substract(1, dungeon[m - 1][n - 1]);
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = substract(dp[m - 1][j + 1], dungeon[m - 1][j]);
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = substract(dp[i + 1][n - 1], dungeon[i][n - 1]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = substract(
                        Math.min(dp[i + 1][j], dp[i][j + 1]),
                        dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    private int substract(int a, int b) {
        int sub = a - b;
        return sub <= 0 ? 1 : a - b;
    }
}
