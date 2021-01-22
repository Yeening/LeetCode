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
