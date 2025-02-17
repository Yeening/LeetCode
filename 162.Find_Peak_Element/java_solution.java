class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int lastDerivative = 1;
        for(int i = 0; i < nums.length; i++){
            int nextDerivative = i == nums.length - 1 ? -1: nums[i+1] - nums[i];
            if(lastDerivative > 0 && nextDerivative < 0){
                return i;
            }
            lastDerivative = nextDerivative;
        }
        return nums.length-1;
    }
}


// Solution 2: O(logn)
class Solution {
    public int findPeakElement(int[] nums) {
        int N = nums.length;
        if (N == 1) return 0;
        int l = 0, r = N - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            boolean greaterThanLeft = mid == 0 || nums[mid] > nums[mid-1];
            boolean greaterThanRight = mid == N - 1 || nums[mid] > nums[mid + 1];
            if (greaterThanLeft && greaterThanRight) {
                return mid;
            } else if (greaterThanLeft) {
                l = mid + 1;
            } else if (greaterThanRight) {
                r = mid - 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
