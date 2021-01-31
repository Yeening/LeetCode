// prefix sum
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int presum = 0;
        for(int i = 0; i < nums.length; i++) {
            presum += nums[i];
            int remainder = k == 0? presum: presum % k;
            if(remainderMap.containsKey(remainder)) {
                int preIndex = remainderMap.get(remainder);
                if(i - preIndex > 1) return true;
            } else {
                remainderMap.put(remainder, i);
            }
        }
        return false;
    }
}
