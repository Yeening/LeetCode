class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        // The key is to break the circle, whether not rob the first house or not to rob the last house
        // You can rob neigher of the two, of course, which is included in the two circumstances mentioned before
        return Math.max(robRow(nums, 0, nums.length-2), robRow(nums, 1, nums.length-1));
    }
    
    private int robRow(int[] nums, int start, int end){
        int robGain = 0, nonRobGain = 0;
        for(int i = start; i <= end; i++){
            int nextRobGain = nonRobGain + nums[i];
            nonRobGain = Math.max(robGain, nonRobGain);
            robGain = nextRobGain;
        }
        return Math.max(robGain, nonRobGain);
    }
}
