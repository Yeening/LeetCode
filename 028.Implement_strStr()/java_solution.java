//Solution 1: two poineters, 52%

class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length()-needle.length() + 1; i++){
            int j = 0;
            for(j = 0; j < needle.length(); j++){
                if(needle.charAt(j) != haystack.charAt(j+i)){
                    break;
                }
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }
}
