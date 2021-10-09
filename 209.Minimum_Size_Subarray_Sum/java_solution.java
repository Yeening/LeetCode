class Solution {
    // window: [l,r)
    // windowsum: 3
    // sliding window: time: O(N), space: O(1)
    // 2,3,1,2,4,3
    //       l
    //             r
    // BF: time: O(N^2), space: O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length + 1, left = 0, right = 0, windowSum = 0;
        // loop invariant: [left, right) contains the minSubArray
        // that ends at right - 1
        while (right < nums.length) {
            windowSum += nums[right++];
            while (windowSum - nums[left] >= target) {
                windowSum -= nums[left++];
            }
            if (windowSum >= target) {
                minLen = Math.min(right - left, minLen);
            }
        }
        return minLen % (nums.length + 1);
    }
}
