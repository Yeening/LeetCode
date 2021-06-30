class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int MSCS = maxSumCommonSubsequence(s1, s2);
        int sum = 0;
        for (char c : s1.toCharArray()) {
            sum += c;
        }
        for (char c : s2.toCharArray()) {
            sum += c;
        }
        return sum - MSCS * 2;
    }

    public int maxSumCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        //dp[i][j]: LCs of  t1[0, i-1], t2[0, j-1]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + text1.charAt(i - 1);
                }
                dp[i][j] = Math.max(dp[i][j],
                        Math.max(dp[i - 1][j], dp[i][j - 1]));

            }
        }
        return dp[m][n];
    }
}
