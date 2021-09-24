// Using array is faster than hashmap
// Record the presums
// Time: O(N)
// Space: O(N)
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if(A == null || A.length == 0) return 0;
        int count = 0, presum = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        int[] sums = new int[A.length+1];
        sums[0] = 1;
        // map.put(0, 1);
        for(int i: A) {
            presum += i;
            // if(map.containsKey(presum - S)) {
            //     count += map.get(presum - S);
            // }
            // map.put(presum, map.getOrDefault(presum, 0) + 1);
            if(presum >= S) {
                count += sums[presum - S];
            }
            sums[presum]++;
        }
        return count;
    }
}


// Solution 2: modified silding windows
// Time: O(N)
// Space: O(1)
class Solution {
    // [0, 0, 0, 0, 0] goal = 0
    //  l              r
    // windowSum: 0
    // count: 5
    
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysMaxSum(nums, goal) - numSubarraysMaxSum(nums, goal - 1);
    }
    
    private int numSubarraysMaxSum(int[] nums, int goal) {
        int curSum = 0, l = 0, r = 0, count = 0;
        while(r < nums.length) {
            curSum += nums[r++];
            while(l < r && curSum > goal) {
                curSum -= nums[l++];
            }
            count += (r - l);
        }
        return count;
    }
}
