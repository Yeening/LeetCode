class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2) return nums.length;
        int index = 1, j = 1;
        while(j<nums.length){
            if(nums[j]!=nums[index-1]){
                swap(nums,index,j);
                index++;
            } 
            j++;
        }
        return index;
    }
    private void swap(int[] nums, int i, int j){
        if(i==j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
