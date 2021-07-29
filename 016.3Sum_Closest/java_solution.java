public int threeSumClosest(int[] nums, int target) {
    int res = nums[0] + nums[1] + nums[2];
    Arrays.sort(nums);
    for (int i = 0 ; i < nums.length; i++) {
        int first = nums[i];
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int lVal = nums[l], rVal = nums[r];
            int sum = first + lVal + rVal;
            if (Math.abs(sum - target) < Math.abs(res - target)) {
                res = sum;
            }
            if (sum < target) {
                while (l < r && nums[l] == lVal) l++;
            } else if (sum > target) {
                while (l < r && nums[r] == rVal) r--;
            } else if (sum == target) {
                return target;
            }
        }
    }
    return res;
}
