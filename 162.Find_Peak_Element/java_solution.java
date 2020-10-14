class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int lastDerivative = 1;
        for(int i = 0; i < nums.length; i++){
            int nextDerivative = i == nums.length - 1 ? -1: nums[i+1] - nums[i];
            if(lastDerivative > 0 && nextDerivative < 0){
                return i;
            }
            lastDerivative = nextDerivative;
        }
        return nums.length-1;
    }
}
