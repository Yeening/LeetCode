class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j]: minDistance to make word1[0, i - 1] tha same as word2[0, j - 1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // skip
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            Math.min(
                                dp[i - 1][j - 1], //replace
                                dp[i - 1][j] // delete word1[i-1]
                            ),
                            dp[i][j - 1] // insert word2[j-1] to word1
                    );
                }
            }
        }
        return dp[m][n];
    }
}
