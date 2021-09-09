class Solution {
    // Time: O(n)
    // Space: O(n)
    public int subarraySum(int[] nums, int k) {
        // ends with i, sum to j
        HashMap<Integer, Integer> preSum = new HashMap<>(); // [{},{},{}]
        preSum.put(0, 1); // [{1:1},{},{}]
        int curSum = 0, res = 0;;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            res += preSum.getOrDefault(curSum - k, 0);
            preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}
