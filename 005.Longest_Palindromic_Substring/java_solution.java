/*non-dynamic programming solution, but well-preformanced(beat 96.57%)
*/
class Solution {
    int start, maxLen = 0;
    public String longestPalindrome(String s) {
        int s_len = s.length();
        if(s_len < 2) return s;
        for(int i = 0; i < s_len - 1; i++){
            append(s, i, i); //try to append an odd palindrome
            append(s, i, i+1); //try to append an even palindrome
        }
        return s.substring(start, start + maxLen);
    }
    public int append(String s, int lo, int hi){
        while(lo>=0&&hi<s.length()&&s.charAt(lo)==s.charAt(hi)){
            lo--;
            hi++;
        }
        if(hi - lo - 1 > maxLen){
            maxLen = hi - lo - 1;
            start = lo + 1;
        }
        return maxLen;
    }
}

//Dynamic Programming solution, beat 33%, not as fast as the previous solution
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        String res = "";
        if(len < 2) return s;
        boolean[][] isPal = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                isPal[i][j] = s.charAt(i)==s.charAt(j) && (j - i < 2||isPal[i+1][j-1]);
                if(isPal[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
}
