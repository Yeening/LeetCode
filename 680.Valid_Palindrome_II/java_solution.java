class Solution {
    public boolean validPalindrome(String s) {
        int N = s.length();
        int l = 0, r = N - 1;
        char[] ca = s.toCharArray();
        while (l < r) {
            if (ca[l] != ca[r]) {
                return isValid(ca, l + 1, r) || isValid(ca, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(char[] ca, int l, int r) {
        while (l < r) {
            if (ca[l++] != ca[r--]) return false;
        }
        return true;
    }
}
