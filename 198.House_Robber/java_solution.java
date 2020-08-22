// O(n) space, O(n) time
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] robGains = new int[nums.length]; // max gain that robbed ith house and before
        int[] nonRobGains = new int[nums.length]; // max gain that rob houses before i but not rob i
        robGains[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            robGains[i] = nonRobGains[i-1] + nums[i];
            nonRobGains[i] = Math.max(robGains[i-1], nonRobGains[i-1]);
        }
        return Math.max(robGains[nums.length-1], nonRobGains[nums.length-1]);
    }
}

// O(1) space, O(n) time
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int robGain = nums[0]; // max gain that robbed ith house and before
        int nonRobGain = 0; // max gain that rob houses before i but not rob i
        for(int i = 1; i < nums.length; i++){
            int nextRobGain = nonRobGain + nums[i];
            nonRobGain = Math.max(robGain, nonRobGain);
            robGain = nextRobGain;
        }
        return Math.max(robGain, nonRobGain);
    }
}
