class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[128],
                window = new int[128];
        int left = 0, right = 0, valid = 0, needcount = 0;
        List<Integer> res = new ArrayList<>();
        for (char c: p.toCharArray()) {
            if (need[c] == 0) needcount++;
            need[c]++;
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }

            while (valid == needcount) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                c = s.charAt(left);
                left++;
                if (need[c] > 0) {
                    if (window[c] == need[c]) {
                        valid--;
                    }
                    window[c]--;
                }
            }
        }
        return res;
    }
}
