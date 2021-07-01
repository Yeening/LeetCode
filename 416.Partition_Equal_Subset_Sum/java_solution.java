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

// Solution 2: memo
class Solution {
    // 0: not-visit, 1 can fill; 2: cannot fill
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int n = nums.length;
        memo = new int[n][target + 1];
        return canFill(nums, n - 1, target);
    }

    // Can fill w with nums[0, n]
    private boolean canFill(int[] nums, int n, int w) {
        if (n < 0 || w < 0) return false;
        if (memo[n][w] != 0) return memo[n][w] == 1;
        if (w == 0){
            memo[n][w] = 1;
            return true;
        }
        if (nums[n] > w) return canFill(nums, n-1, w);
        if (canFill(nums, n-1, w - nums[n]) || 
                canFill(nums, n-1, w)) {
            memo[n][w] = 1;
        } else {
            memo[n][w] = 2;
        }
        return memo[n][w] == 1;
    }
}
