// solution 1: top-down memo recursion
// time: O(MN)
// space: O(MN)
// leetcode run time: 0ms
class Solution {
    int[][] memo; // 1: true 2: false
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {return false;}
        if (s1.isEmpty()) {return s2.equals(s3);}
        if (s2.isEmpty()) {return s1.equals(s3);}
        memo = new int[s1.length()][s2.length()];
        return isInterleave(s1, 0, s2, 0, s3);
    }
    
    private boolean isInterleave(String s1, int i, 
                                 String s2, int j, String s3) {
        if (s1.length() == i) {
            return s2.substring(j).equals(s3.substring(i+j));
        }
        if (s2.length() == j) {
            return s1.substring(i).equals(s3.substring(i+j));
        }
        if (s3.length() == i+j) {return true;}
        if (memo[i][j] != 0) {
            return memo[i][j] == 1;
        }
        char curChar = s3.charAt(i+j);
        if ((s1.charAt(i) == curChar && isInterleave(s1, i+1,s2,j,s3)) ||
            (s2.charAt(j) == curChar && 
                isInterleave(s1, i,s2,j+1,s3))){
            memo[i][j] = 1;
        } else {
            memo[i][j] = 2;
        }
        return memo[i][j] == 1;
    }
}

// Solution 2: down-up dp solution
// time: O(MN)
// space: O(MN)
// leetcode run time: 4ms
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {return false;}
        if (s1.isEmpty()) {return s2.equals(s3);}
        if (s2.isEmpty()) {return s1.equals(s3);}
        // 1: true 2: false
        // dp[i][j] = dp[i+1][j] == 1 || dp[i][j+1]
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m+1][n+1];
        for (int j = 0; j < n; j++) {
            dp[m][j] = s2.substring(j).equals(s3.substring(m+j));
        }
        for (int i = 0; i < m; i++) {
            dp[i][n] = s1.substring(i).equals(s3.substring(i+n));
        }
        dp[m][n] = true;
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                char curChar = s3.charAt(i+j);
                dp[i][j] = (curChar == s1.charAt(i) && dp[i+1][j]) ||
                    (curChar == s2.charAt(j) && dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}

// solution 3: dp with spcae compression
// time: O(MN)
// space: O(N)
// leetcode run time: 4ms
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {return false;}
        if (s1.isEmpty()) {return s2.equals(s3);}
        if (s2.isEmpty()) {return s1.equals(s3);}
        // 1: true 2: false
        // dp[i][j] = dp[i+1][j] == 1 || dp[i][j+1]
        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[n+1];
        for (int j = 0; j < n; j++) {
            dp[j] = s2.substring(j).equals(s3.substring(m+j));
        }
        dp[n] = true;
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                char curChar = s3.charAt(i+j);
                dp[j] = (curChar == s1.charAt(i) && dp[j]) ||
                    (curChar == s2.charAt(j) && dp[j+1]);
            }
        }
        return dp[0];
    }
}
