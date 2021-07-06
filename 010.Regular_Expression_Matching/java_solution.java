// recursive solution:
class Solution {
    public boolean isMatch(String s, String p) {
        return match(s, s.length()-1, p, p.length() - 1);
    }

    private boolean match(String s, int i, String p, int j) {
        if (j == -1) {
            return i == -1;
        }
        if (p.charAt(j) == '.') {
            return match(s, i-1, p, j-1);
        } else if (p.charAt(j) == '*') {
            if (j == 0) return false;
            if (!s.isEmpty() && i >= 0 &&
                    (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.')) {
                return match(s, i-1, p, j) || match(s, i, p, j-2);
            } else {
                return match(s, i, p, j-2);
            }
        } else {
            if (!s.isEmpty() && i >= 0 && 
                    s.charAt(i) == p.charAt(j)) {
                return match(s, i - 1, p, j - 1);
            } else {
                return false;
            }
        }
    }
}

// recursive solution with memo
class Solution {
    int memo[][];
    public boolean isMatch(String s, String p) {
        memo = new int[s.length()][p.length()];
        return match(s, s.length()-1, p, p.length() - 1);
    }

    private boolean match(String s, int i, String p, int j) {
        if (j == -1) {
            return i == -1;
        }
        if (i >= 0 && j >= 0 && memo[i][j] > 0) {
            return memo[i][j] == 1;
        }
        boolean res = false;
        if (p.charAt(j) == '.') {
            res =  match(s, i-1, p, j-1);
        } else if (p.charAt(j) == '*') {
            if (j == 0) return false;
            if (!s.isEmpty() && i >= 0 &&
                    (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.')) {
                res =  match(s, i-1, p, j) || match(s, i, p, j-2);
            } else {
                res =  match(s, i, p, j-2);
            }
        } else {
            if (!s.isEmpty() && i >= 0 &&
                    s.charAt(i) == p.charAt(j)) {
                res =  match(s, i - 1, p, j - 1);
            } else {
                res =  false;
            }
        }
        if (i >= 0) {
            memo[i][j] = res? 1: 2;
        }
        return res;
    }
}
