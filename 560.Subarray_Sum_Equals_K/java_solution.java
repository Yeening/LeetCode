// From solution BF, we know the key to solve this problem is SUM[i, j]. 
// So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. 
// To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap.
class Solution {
    // Time: O(n)
    // Space: O(n)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); 
        int curSum = 0, res = 0;;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            res += preSum.getOrDefault(curSum - k, 0);
            preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}
