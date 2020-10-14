class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null ||nums.length < k) return -1;
        int N = nums.length, lo = 0, hi = nums.length-1, mid = helper(nums, lo, hi);
        while(mid != N - k){
            if(mid > N - k){
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
            mid = helper(nums, lo, hi);
        }
        return nums[mid];
    }

    private int helper(int[] nums, int lo, int hi){
        if(lo == hi) return lo;
        int pivot = nums[lo], l = lo+1, r = hi;
        while(l <= r){
            while(l <= r && nums[l] < pivot){
                l++;
            }
            while(r >= l && nums[r] >= pivot){
                r--;
            }
            if(l < r){
                swap(nums, l++, r--);
            }
        }
        swap(nums, lo, r);
        return r;
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
