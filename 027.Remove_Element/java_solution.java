class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length-1;
        while(j>=0&&nums[j]==val) j--;
        while(i<j){
            if(i<nums.length&&nums[i]!=val){
                i++;
                continue;
            } 
            swap(nums,i,j);
            i++;
            j--;
            while(j>=0&&nums[j]==val) j--;
        }
        return j+1;
    }
    private void swap(int[] nums, int i, int j){
        if(i==j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
