// explanation: https://labuladong.gitbook.io/algo/mu-lu-ye-2/mu-lu-ye-3/tiao-yue-you-xi

// solution 1: dp, O(N^2)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for (int i = n-2; i>= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j<= nums[i]; j++) {
                dp[i] = Math.min(dp[i], dp[i+j] + 1);
            }
        }
        return dp[0];
    }
}

// Solution 2: greedy, O(N)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, end = 0, farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
