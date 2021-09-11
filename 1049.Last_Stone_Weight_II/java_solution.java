// https://leetcode.com/problems/last-stone-weight-ii/discuss/294888/JavaC%2B%2BPython-Easy-Knapsacks-DP
class Solution {
    //  [1,1,4,2,3]
    // sum = 11
    // target = 6
    
    public int lastStoneWeightII(int[] stones) {
        int sum = 0, N = stones.length;
        for (int i: stones) {
            sum += i; 
        }
        int target = sum % 2 == 0? sum >> 1: (sum >> 1) + 1;
        // equals to a knap problem, bag space = target, elements = stones
        // dp[i]: value of i is achieveable
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (dp[j] && j + stones[i] <= target) {
                    dp[j + stones[i]] = true;
                }
            }
        }
        int maxValue = dp.length - 1;
        while (maxValue >= 0) {
            if (dp[maxValue]) break;
            maxValue--;
        }
        return Math.abs(sum - maxValue - maxValue);
    }
}
