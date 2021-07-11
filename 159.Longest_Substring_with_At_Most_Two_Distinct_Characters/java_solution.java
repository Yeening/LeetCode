class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0, distinct = 0, len = 0;
        int[] window = new int[128];
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (window[c] == 0) {
                distinct++;
            }
            window[c]++;
            while (distinct > 2) {
                char d = s.charAt(left);
                left++;
                if (window[d] == 1) {
                    distinct--;
                }
                window[d]--;
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
