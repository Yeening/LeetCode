class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(i%2 == 0){
                if(nums[i-1] < nums[i]) swap(nums, i);
            } 
            else if(nums[i-1] > nums[i]) swap(nums, i);
        }
    }
    private void swap(int[] nums, int i){
        int m = nums[i];
        nums[i] = nums[i-1];
        nums[i-1] = m;
    }
}
