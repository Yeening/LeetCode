// dp with state compression
class Solution {
    //  isPalindromic[i][j] == s[i] == s[j] && 
    //                (j<i+2 || isPalindromic[i+1][j-1])
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[] isPalindromic = new boolean[n];
        int palindromicCount = 0;
        boolean lastJMinus1 = false;
        for (int i = n; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                boolean nextJMinus1 = isPalindromic[j];
                isPalindromic[j] = (s.charAt(i) == s.charAt(j) && 
                                        (j < i + 2 || 
                                         lastJMinus1));
                lastJMinus1 = nextJMinus1;
                if (isPalindromic[j]) {palindromicCount++;}
            }
        }
        return palindromicCount;
    }
}
