//0ms, 100%
class Solution {
    int first = -1, last = -1;
    public int[] searchRange(int[] nums, int target) {
        first = nums.length;
        search(nums, target, 0, nums.length-1);
        if(first==nums.length) first = -1;
        return new int[]{first, last};
    }
    private void search(int[] nums, int target, int lo, int hi){
        if(lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[mid]==target){
                if(mid<first) first = mid;
                if(mid>last) last = mid;
                search(nums, target, lo, mid-1);
                search(nums, target, mid+1, hi);
            }
            else if(nums[mid] < target){
                search(nums, target, mid+1, hi);
            }
            else if(nums[mid] > target){
                search(nums, target, lo, mid-1);
            }
        }
    }
}
