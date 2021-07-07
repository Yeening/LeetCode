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

// Explaination: https://labuladong.gitbook.io/algo/mu-lu-ye/er-fen-cha-zhao-xiang-jie

// Solution 2: iterative
public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[]{-1, -1};
    int left = 0, right = nums.length - 1;
    int leftBound = -1, rightBound = -1;
    while (left <= right) {
        int mid = left + (right - left >> 1);
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] == target) {
            right = mid - 1;
        }
    }
    if (left >= nums.length || nums[left] != target) {
        return new int[]{-1, -1};
    }
    leftBound = left;
    left = leftBound;
    right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left >> 1);
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] == target) {
            left = mid + 1;
        }
    }
    if (right < 0 || nums[right] != target) {
        return new int[]{-1, -1};
    }
    rightBound = right;
    return new int[]{leftBound, rightBound};
}
