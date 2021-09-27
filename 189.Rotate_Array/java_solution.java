// solution 1: using system api
class Solution {
    // [5,6,7,1,2,3,1/4] n: 7, k = 3
    // temp: [5,6,7]
    // 
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % nums.length;
        int[] temp = Arrays.copyOfRange(nums, n - k, n);
        System.arraycopy(nums, 0, nums, k, n - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }
}

// solution 2: copy from right to left
class Solution {
    // [5,6,7,1,2,3,1/4] n: 7, k = 3
    // temp: [5,6,7]
    // 
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % nums.length;
        int[] temp = Arrays.copyOfRange(nums, n - k, n);
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i+k] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, k);
    }
}
