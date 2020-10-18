class Solution {
    public int titleToNumber(String s) {
        if(s == null||s.length() == 0) return 0;
        char[] cA = s.toCharArray();
        int res = 0;
        for(char c: cA){
            res *= 26;
            res += (c - 'A') + 1;
        }
        return res;
    }
}
