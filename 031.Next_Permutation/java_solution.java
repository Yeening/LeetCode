// O(n) solution
// https://www.bilibili.com/video/BV1Rz4y1Z7hx?from=search&seid=153202113344042352&spm_id_from=333.337.0.0
class Solution {
    // 1 4 3 2 0
    // time: O(n), space: O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                // found non-desending 1
                for (int j = n - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        // found 2
                        swap(nums, i, j);
                        reverse(nums, i + 1, n - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, n - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        int l = start, r = end;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// O(NlogN) solution
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            int minToReplace = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i] 
                    && (minToReplace == i || nums[j] < nums[minToReplace])) {
                    minToReplace = j;
                }
            }
            if (minToReplace != i) {
                int temp = nums[minToReplace];
                nums[minToReplace] = nums[i];
                nums[i] = temp;
                Arrays.sort(nums, i + 1, n);
                return;
            }
        }
        reverse(nums);
    }
    
    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}
