// https://labuladong.gitbook.io/algo/mu-lu-ye/tuan-mie-gu-piao-wen-ti
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        // dp[i][j][k]:
        // i: day
        // j: max trading times
        // k = 0: non-hold, i= 1: hold stock
        int[][][] dp = new int[prices.length][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 2; j >= 1; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[prices.length-1][2][0];
    }
}
