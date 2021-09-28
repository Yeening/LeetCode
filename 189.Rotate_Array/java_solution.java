// solution: In-place and O(N)
class Solution {
    // [7,6,5,4,3,2,1]
    // [4,5,6,7,1,2,3]
    
    // [1,2,3,4,4]
    //          l r
    //  5
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int l, int r) {
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}

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
