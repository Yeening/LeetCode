// best solution: two pointer + greedy
class Solution {
    // time: O(N^2), space: O(1)
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[right] + nums[left] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}

// binary search
class Solution {
    // time: O(N^2), space: O(1)
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, n = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int curSum = nums[i] + nums[j];
                if (nums[j + 1] >= curSum) {continue;}
                if (nums[n - 1] < curSum) {
                    count += n - 1 - j;
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                // [left, right], nums[left] < curSum, nums[right] >= curSum
                while (left < right) {
                    int mid = left + (right - left + 1 >> 1);
                    if (nums[mid] >= curSum) {
                        right = mid - 1;
                    } else if (nums[mid] < curSum) {
                        left = mid;
                    }
                }
                count += left - j;
            }
        }
        return count;
    }
}
