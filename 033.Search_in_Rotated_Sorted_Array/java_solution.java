class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) return mid;
            //Need to accept nums[lo] == nums[mid], for the size = 2 situation
            if(nums[lo] <= nums[mid]){
                //Left side is in order, search the left side
                if(target >= nums[lo] && target < nums[mid]){
                    hi = mid - 1;
                }
                else{
                    lo = mid + 1;
                }
            }
            else{
                //Right side is in order, search the right side
                if(target > nums[mid] && target <= nums[hi]){
                    lo = mid + 1;
                }
                else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
