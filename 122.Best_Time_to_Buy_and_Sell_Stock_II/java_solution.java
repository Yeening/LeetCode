// Solution 1: 2d dp
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        // dp[i][0]: profit at day i, not holding stock, dp[i][1]: profit at day i, holding stock,
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}

// Solution 2: dp with compression
public int maxProfit(int[] prices) {
    if (prices.length < 2) return 0;
    int nonHold = 0;
    int hold = -prices[0];
    for (int i = 1; i < prices.length; i++) {
        int nextNonHold = Math.max(nonHold, hold + prices[i]);
        int nextHold = Math.max(hold, nonHold - prices[i]);
        hold = nextHold;
        nonHold = nextNonHold;
    }
    return nonHold;
}
