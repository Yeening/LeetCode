// Explanation: https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
// my binary search
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lengthToTail = new int[nums.length + 1];
        Arrays.fill(lengthToTail, Integer.MAX_VALUE-1);
        lengthToTail[0] = Integer.MIN_VALUE;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = maxLength + 1;
            // search range: [0, i], 
            // invariant: largest x, lengthToTail[x] < nums[i] 
            // in [left, right)
            while (left < right - 1) {
                int mid = left + (right - left >> 1);
                if (lengthToTail[mid] >= nums[i]) {
                    right = mid;
                } else if (lengthToTail[mid] < nums[i]) {
                    left = mid;
                }
            }// terminate: l = r - 1, mid = l, 
            // lengthToTail[l] >= nums[i] or lengthToTail[l] < nums[i]
            // l = r - 2, mid = l + 1
            // lengthToTail[l + 1] < nums[i]
            assert(lengthToTail[left] < nums[i]);
            assert(left == nums.length - 1 || lengthToTail[left + 1] >= nums[i]);
            int preLength = left;
            int curLength = preLength + 1;
            lengthToTail[curLength] = 
                Math.min(lengthToTail[curLength], nums[i]);
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }
}

// Binary Search: O(NlogN)
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

// DP: O(N^2)
public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[] dp = new int[nums.length];
    int res = 1;
    dp[0] = 1;
    for (int i = 1; i < nums.length; i++) {
        dp[i] = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        res = Math.max(res, dp[i]);
    }
    return res;
}
