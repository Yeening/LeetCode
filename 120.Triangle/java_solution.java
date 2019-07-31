class Solution {
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     //using dynamic programming, beat 99% in time and space, O(n) complexity in both time and space
    //     int n = triangle.size();
    //     //sum[i] represents the shortest path sum from top to traingle[current][i];
    //     int[] sum = new int[n];
    //     sum[0] = triangle.get(0).get(0);
    //     int min = sum[0];
    //     for(int i = 1; i < n; i++){
    //         List<Integer> tem = triangle.get(i);
    //         sum[i] = sum[i-1] + tem.get(i);
    //         min = sum[i];
    //         for(int j = i-1; j > 0; j--){
    //             sum[j] = Math.min(sum[j], sum[j-1]) + tem.get(j);
    //             min = Math.min(min, sum[j]);
    //         }
    //         sum[0] = sum[0] + tem.get(0);
    //         min = Math.min(min, sum[0]);
    //     }
    //     return min;
    // }
    
    /*Improved, cleaner code*/
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1]; //dp[i] represents the shortest path sum from traingle[current][i] to bottom
        // + 1 to avoid out of boundary at the bottom row
        for(int i = triangle.size() - 1; i > -1; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }    
}
