class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        //Insert non-zero items as forward as possibile
        int insertPos = 0;
        for(int num: nums){
            if(num != 0) nums[insertPos++] = num;
        }
        //Fill the rest position with 0a
        while(insertPos < nums.length){
            nums[insertPos++] = 0;
        }
    }
}
