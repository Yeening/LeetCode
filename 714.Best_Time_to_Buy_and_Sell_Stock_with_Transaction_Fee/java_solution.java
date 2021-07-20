class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;
        int nonHold = 0, hold = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            int nextHold = Math.max(hold, nonHold-prices[i]-fee);
            int nextNonHold = Math.max(nonHold, hold + prices[i]);
            hold = nextHold;
            nonHold = nextNonHold;
        }
        return nonHold;
    }
}
