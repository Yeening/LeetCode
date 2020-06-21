//Solution 1: two poineters, 52%, O(L*N)

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

//Soluiton 2: Rolling hash, 34%, O(L)
class Solution {
    
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        int L = needle.length();
        long modular = (long) Math.pow(2, 31);
        long target_hash = 0, current_hash = 0;
        
        for(int i = 0; i < needle.length(); i++){
            target_hash = (target_hash * 26 + (needle.charAt(i) - 'a')) % modular;
            current_hash = (current_hash * 26 + (haystack.charAt(i) - 'a')) % modular;
        }
        if(current_hash == target_hash) return 0;
        
        long aL = 1;
        for(int i = 0; i < L; i++){
            aL = (aL * 26) % modular;
        }
        for(int i = 1; i < haystack.length() - needle.length() + 1; i++){
            current_hash = (current_hash *26 - (haystack.charAt(i-1) - 'a') * aL) + (long)(haystack.charAt(i+L-1) - 'a');
            current_hash %= modular;
            if(current_hash == target_hash){
                return i;
            }
        }
        
        return -1;
    }
}
