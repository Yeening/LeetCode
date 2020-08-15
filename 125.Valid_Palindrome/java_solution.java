class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length()-1;
        char[] ca = s.toCharArray();
        while(l < r){
            while(l < r && !Character.isAlphabetic(ca[l]) && !Character.isDigit(ca[l])) l++;
            while(l < r && !Character.isAlphabetic(ca[r]) && !Character.isDigit(ca[r])) r--;
            if(ca[l++] != ca[r--]) return false;
        }
        return true;
    }
}
