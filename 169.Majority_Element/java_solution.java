class Solution {
    //Solution1: sorting
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    //Solution2: Moore voting
    // public int majorityElement(int[] nums) {
    //     int candidate = nums[0], count = 0;
    //     for(int num: nums){
    //         if(count==0) candidate = num;
    //         if(num == candidate) count++;
    //         else count--;
    //     }
    //     return candidate;
    // }    
}
