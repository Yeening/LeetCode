class Solution {
    // Time: O(number of elements), space: O(number of elements)
    // Bucket Sort using the sum of row + col
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int M = nums.size(), N = 0;
        int count = 0, index = 0;
        for (List<Integer> row: nums) {
            N = Math.max(N, row.size());
            count += row.size();
        }
        
        List<Integer>[] sums = new List[M + N - 1];
        for (int i = 0; i < sums.length; i++) sums[i] = new ArrayList<>();
        for (int i = M - 1; i > -1; i--) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                sums[i+j].add(row.get(j));
            }
        }
        
        int[] res = new int[count];
        for (int i = 0; i < M + N - 1; i++) {
            if (sums[i] != null) {
                for (int j: sums[i]) {
                    res[index++] = j;
                }
            }
        }
        return res;
    }

}
