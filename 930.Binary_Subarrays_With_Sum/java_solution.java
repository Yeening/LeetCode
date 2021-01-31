// Using array is faster than hashmap
// Record the presums
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
