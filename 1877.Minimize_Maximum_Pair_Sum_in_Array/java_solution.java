class Solution {
    
    // even: [10199] [0-n/2), [n/2-n]
    
    // [a, b, c, d]: a <= b <= c <= d
    // max (a+d, b+c)
    // max (a+c, b+d)
    // 1: (b+c) >= (a+d)
    // a + d >= a+c, b+c <= b+d
    // (b+c) - (a+d) <= (b+d) - (a+c)
    
    // 2: (b+c) < (a+d)
    // a + d <= b + d, b + c >= a+c
    // (a+d) - (b+c) <= (b+d) - (a+c)
    
    
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, max = 0;
        while (left < right) {
            max = Math.max(nums[left++] + nums[right--], max);
        }
        return max;
    }
}
