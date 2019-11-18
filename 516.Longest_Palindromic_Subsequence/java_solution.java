//Solution1 23ms, using 2d DP
// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         char[] cs = s.toCharArray();
//         int n = cs.length;
//         int[][] dp = new int[n][n];
//         int max = 0;
//         for(int i = n-1; i >=0; i--){
//             for(int j = i; j<n; j++){
//                 if(i==j) dp[i][j] = 1;
//                 else if(cs[i]==cs[j]) dp[i][j] = dp[i+1][j-1] + 2;
//                 else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
//                 max = Math.max(max, dp[i][j]);
//             }
//         }
//         return max;
//     }
// }

//Solution2, 7ms, space optimized 1d DP
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] dp = new int[n]; //dp[i] stores max length ends with i
        int max = 0;
        for(int i = 0; i < n; i++) dp[i] = 1;
        for(int i = n-1; i >=0; i--){
            int len = 0; //len is the max valid subsequence length from i+1 to j-1 
            for(int j = i+1; j<n; j++){
                int t = dp[j];
                if(cs[i]==cs[j]){
                    //equals to dp[i][j] = d][i+1][j-1] + 2
                    dp[j] = len + 2;
                }
                len = Math.max(len, t);
            }
        }
        for(int i: dp) max = Math.max(i, max);
        return max;
    }
}
