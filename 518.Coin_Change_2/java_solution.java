// Solution 1: DP, 7.27%, O(N * amount) space
public static class Solution {
    public int change(int amount, int[] coins) {
        // dp[i][j]: combinations of coins[0, i-1] to amount j
        // dp[0][...] = 0, dp[...][0] = 1
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 0;
        }
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        // dp[i][j] = sum(dp[i-1][j - k * coins[i-1]]) k:[0, ...]
        for (int i = 1; i <= n; i++) {
            int cur = coins[i-1];
            for (int j = 1; j <= amount; j++) {
                for (int k = 0; cur * k <= j; k++) {
                    dp[i][j] += dp[i-1][j - k * cur];
                }
            }
        }
        return dp[n][amount];
    }
}

// Solution 2: 46%
class Solution {
    public int change(int amount, int[] coins) {
        // dp[i][j]: combinations of coins[0, i-1] to amount j
        // dp[0][...] = 0, dp[...][0] = 1
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i-1])
                        dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }
}
