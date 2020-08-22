class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int num: nums){
            sum = Math.max(0, sum);
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
