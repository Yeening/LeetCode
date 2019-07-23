class Solution {
    //Time complexity: O(n^2)
    //Space complexity: O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0, len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        //save the values of sum of C and D
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int sum2 = C[i] + D[j];
                map.put(sum2, map.getOrDefault(sum2, 0) + 1);
            }
        }
        //search for the saved sums
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int sum1 = A[i] + B[j];
                count += map.getOrDefault(-sum1,0);
            }
        }
        return count;
    }
    
}
