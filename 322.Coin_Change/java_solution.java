class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i < dp.length; i++){
            for(int coin: coins){
                if(coin > i){
                    break;
                }
                if(dp[i-coin] < Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coin]+1, dp[i]);
                }
            }
        }
        return dp[amount] < Integer.MAX_VALUE? dp[amount]: -1;
    }
}
