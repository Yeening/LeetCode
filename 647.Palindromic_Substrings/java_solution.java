// dp with state compression
// time: O(N^2)
// space: O(N)
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

// grow palindromic
// time: O(N^2) but better than DP because it will not check every substring
// space: O(1)
class Solution {
    //  isPalindromic[i][j] == s[i] == s[j] && 
    //                (j<i+2 || isPalindromic[i+1][j-1])
    int palindromicCount;
    public int countSubstrings(String s) {
        int n = s.length();
        palindromicCount = 0;
        for (int i = 0; i < n; i++) {
            growSubstring(s, i, i);
            growSubstring(s, i, i+1);
        }
        return palindromicCount;
    }
    
    private void growSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && 
               s.charAt(left) == s.charAt(right)) {
            palindromicCount++;
            left--;
            right++;
        }
    }
}
