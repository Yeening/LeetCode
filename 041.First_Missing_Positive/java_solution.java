// N: length of nums
// number of positive items: m
// we only care about items in: [1, m]
// m <= n, therefore we only care items in: [1, n]
// keep putting items in [1, n] to its corresponding position: value - 1
// [3, 2, 4, 1, 5] -> [1, 2, 3, 4, 5]
// [3, 2, 4, -1, 5] -> [3, 2, 3, 4, 5]
// [1, 2, 0] -> [1, 2, 0]
// the first mismatching position is what we are looking for

class Solution{
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            deal(nums, nums[i]);
        }
        int res = 1;
        while(nums[res-1] == res) {
            res++;
        }
        return res;
    }
    private void deal(int[] nums, int n){
        while(n > 0 && n <= nums.length && nums[n-1] != n) {
            int next = nums[n-1];
            nums[n-1] = n;
            n = next;
        }
    }
}

class Solution {
    // max positive <= 0: return 1
    // min positive > 1: return 1
    // number of positive items: m
    // min positive = 1, max positive = m: return m + 1
    // min positive = 1, 1 < res <= m + 1
    // only care items in [1, m], m <= n
    // 
    
    
    // Time: O(N)
    // Space: O(1)
    public int firstMissingPositive(int[] nums) {
        int N = nums.length; // 3
        for (int i = 0; i < N; i++) {
            int j = nums[i]; // 1
            while (j > 0 && j - 1 < N && 
                   nums[j - 1] != j) {
                int nextJ = nums[j - 1]; // -1
                nums[j - 1] = j; // [1, 2, 0]
                j = nextJ; // -1
            }
        }
        for (int i = 0; i < N; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return N + 1;
    }
}
