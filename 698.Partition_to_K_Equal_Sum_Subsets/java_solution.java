// solution 1: back-tracking with linked list, 674ms
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        List<Integer> numList = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            numList.add(nums[i]);
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        if (numList.get(0) > target) return false;
        return backTrack(numList, new int[k], 0, target);
    }

    private boolean backTrack(List<Integer> numList, int[] buckets, int j, int target) {
        if (j == buckets.length) {
            return true;
        }
        if (buckets[j] == target) {
            return backTrack(numList, buckets, j+1, target);
        }
        for (int i = 0; i < numList.size(); i++) {
            int cur = numList.get(i);
            if (buckets[j] <= target - cur) {
                buckets[j] += cur;
                numList.remove(i);
                if (backTrack(numList, buckets, j, target)) return true;
                numList.add(cur);
                buckets[j] -= cur;
            }
        }
        return false;
    }
}

// solution 2: back-tracking with swap, 1ms
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length-i-1);
        }
        int target = sum / k;
        if (nums[0] > target) return false;
        return backTrack(nums, 0, new int[k], 0, target);
    }

    private boolean backTrack(int[] nums, int numsStart, int[] buckets, int bucketsStart, int target) {
        if (bucketsStart == buckets.length) {
            return true;
        }
        if (buckets[bucketsStart] == target) {
            return backTrack(nums, numsStart, buckets, bucketsStart+1, target);
        }
        for (int i = numsStart; i < nums.length; i++) {
            int cur = nums[i];
            if (buckets[bucketsStart] <= target - cur) {
                buckets[bucketsStart] += cur;
                swap(nums, i, numsStart);
                if (backTrack(nums, numsStart + 1, buckets, bucketsStart, target)){
                    return true;
                }
                swap(nums, i, numsStart);
                buckets[bucketsStart] -= cur;
            }
        }
        return false;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
