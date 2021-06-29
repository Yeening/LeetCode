// Solution 1: memo, top to down, recursive
class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(text1, 0, text2, 0);
    }

    // LCS length of text1[i, ...] and text2[j, ...]
    private int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            res =  1 + dp(text1, i + 1, text2, j + 1);
        } else {
            res =  Math.max(dp(text1, i+1, text2, j),
                    dp(text1, i, text2, j+1));
        }
        memo[i][j] = res;
        return res;
    }
}
