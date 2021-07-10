// sliding window, explaination: https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-3/hua-dong-chuang-kou-ji-qiao-jin-jie#yi-zui-xiao-fu-gai-zi-chuan
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[128], window = new int[128];
        int valid = 0, needCount = 0, left = 0, right = 0;
        for (char c: s1.toCharArray()) {
            if (need[c] == 0) needCount++;
            need[c]++;
        }

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }

            while (valid == needCount) {
                if (right - left == s1.length()) return true;
                c = s2.charAt(left);
                left++;
                if (need[c] > 0) {
                    if (window[c] == need[c]) {
                        valid--;
                    }
                    window[c]--;
                }
            }
        }
        return false;
    }
}
