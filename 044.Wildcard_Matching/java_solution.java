class Solution {
    private int[][] memo;
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // memo[i][j]: s[i,...] matches p[j,...]
        // 1 match, 2 not match
        memo = new int[m][n];
        return match(s, 0, p, 0);
    }

    private boolean match(String s, int i, String p, int j) {
        if (i == s.length()) {
            while (j < p.length()) {
                if (p.charAt(j) != '*') return false;
                j++;
            }
            return true;
        } else if (j == p.length()) {
            return false;
        }
        if (memo[i][j] != 0) {
            return memo[i][j] == 1;
        }
        
        if (p.charAt(j) == '?') {
            memo[i][j] = match(s, i+1, p, j+1)? 1: 2;
        } else if (p.charAt(j) == '*') {
            memo[i][j] = (match(s, i, p, j+1) || match(s, i+1, p, j))? 1: 2;
        } else {
            memo[i][j] = (s.charAt(i) == p.charAt(j) && match(s, i+1, p, j+1))? 1: 2;
        }
        return memo[i][j] == 1;
        
    }
}
