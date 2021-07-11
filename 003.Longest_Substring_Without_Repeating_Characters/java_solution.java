class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for(int i=0,j=0; j<s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, (map.get(s.charAt(j))+1));
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j),j);
        }
        return maxLength;
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> alphaMap = new HashMap<>();
        int res = 0;
        for(int i = 0, j = -1; i < s.length(); i++){
            char c = s.charAt(i);
            j = Math.max(j, alphaMap.getOrDefault(c, -1));
            res = Math.max(res, i - j);
            alphaMap.put(c, i);
        }
        return res;
    }
}

// Solution 2: sliding window
// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-3/hua-dong-chuang-kou-ji-qiao-jin-jie#yi-zui-xiao-fu-gai-zi-chuan
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, len = 0;
        int[] window = new int[128];
        while (right < s.length()) {
           char c = s.charAt(right);
           right++;
           window[c]++;
           while (window[c] > 1) {
               char d = s.charAt(left);
               left++;
               window[d]--;
           }
           len = Math.max(len, right - left);
        }
        return len;
    }
}
