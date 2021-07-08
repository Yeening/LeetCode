// a test case: [1,1,1,1,1,1,2,1,1,1,1,1]
// Solution 1
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] == target) return true;
            else if (isValid(nums, mid, right, nums[mid], nums[right])) {
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (isValid(nums, left, mid, nums[left], nums[mid])) {
                if (nums[mid] >= target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                return false;
            }
        }
        return false;
    }
    
    // similiar to check valid BST
    private boolean isValid(int[] nums, int l, int r, int minVal, int maxVal) {
        if (l > r) return true;
        int mid = l + (r - l >> 1);
        if (nums[mid] < minVal || nums[mid] > maxVal) return false;
        return isValid(nums, l, mid - 1, minVal, nums[mid]) && 
                isValid(nums, mid + 1, r, nums[mid], maxVal);
    }
}

// Solution 2: only check if nums[mid] == nums[left] == nums[right]
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            else if (nums[right] >= nums[mid]) {
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[left] <= nums[mid]) {
                if (nums[mid] >= target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
