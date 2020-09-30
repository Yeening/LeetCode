// This is a dutch partitioning problem. We are classifying the array into four groups: red, white, unclassified, and blue. 
// Initially we group all elements into unclassified. We iterate from the beginning as long as the white pointer is less than the blue pointer.
// If the white pointer is red (nums[white] == 0), we swap with the red pointer and move both white and red pointer forward. 
// If the pointer is white (nums[white] == 1), the element is already in correct place, so we don't have to swap, 
// just move the white pointer forward. If the white pointer is blue, we swap with the latest unclassified element.

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
