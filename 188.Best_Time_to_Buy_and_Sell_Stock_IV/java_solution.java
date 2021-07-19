class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) return 0;
        int[][][] dp = new int[prices.length][2][k+1];
        for(int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i][0], -10000000);
            Arrays.fill(dp[i][1], -10000000);
        }
        dp[0][1][1] = -prices[0];
        dp[0][0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0] + prices[i]);
            dp[i][1][0] = Integer.MIN_VALUE >> 1;
            for (int j = 1; j <= k; j++) {
                dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j] + prices[i]);
                dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][0][j-1] - prices[i]);
            }
        }
        int res = 0;
        for (int pro: dp[prices.length-1][0]) {
            res = Math.max(pro, res);
        }
        return res;
    }
}
