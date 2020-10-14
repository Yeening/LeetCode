class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        for(int i = 0; i < nums.length - 1; i++){
            if(!canReach[i]){
                continue;
            }
            for(int j = 1; j <= nums[i] && i+j < canReach.length; j++){
                canReach[i+j] = true;
            }
        }
        return canReach[canReach.length-1];
    }
}
