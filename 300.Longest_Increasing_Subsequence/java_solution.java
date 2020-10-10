// Explanation: https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int length = 0;
        int[] tails = new int[nums.length];
        for(int num: nums){
            int l = 0, r = length-1, mid  =0 ;
            while(l <= r){
                mid = (l + r) / 2;
                if(tails[mid] == num){
                    break;
                }
                if(num > tails[mid]){
                    l = mid + 1;
                } else{
                    r = mid - 1;
                }
            }
            if(tails[mid] != num){
                tails[l] = num;
            }
            if(l == length){
                length++;
            }
        }
        return length;
    }
}
