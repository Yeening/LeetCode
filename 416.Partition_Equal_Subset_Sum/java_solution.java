// Solution 1: DP
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        return canFill(nums, nums.length - 1, target);
    }

    private boolean canFill(int[] nums, int n, int w) {
        // dp[i][j] can find a subset in nums[0, i - 1] that sums to j
        // dp[i][j] = dp[i-1][j] || dp[i][j - nums[i]]
        boolean[][] dp = new boolean[n + 1][w+1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= w; j++) {
                if (nums[i-1] > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = dp[i-1][j] || dp[i - 1][j - nums[i-1]];
                }
            }
        }
        return dp[n][w];
    }
}
