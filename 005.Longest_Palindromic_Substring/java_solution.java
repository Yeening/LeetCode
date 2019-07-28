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
