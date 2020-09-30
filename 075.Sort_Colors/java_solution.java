class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length < 2) return;
        int low = 0, mid = 0, hi = nums.length-1;
        while(mid <= hi){
            if(nums[mid] == 0){
                swap(nums, low++, mid++);
            } else if(nums[mid] == 1){
                mid++;
            } else if(nums[mid] == 2){
                swap(nums, mid, hi--);
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        if(a == b) return;
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }
}
