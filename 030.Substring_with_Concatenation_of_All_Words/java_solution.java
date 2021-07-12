// sliding window
// compare Integer object greater than 127 use equals: https://www.huaweicloud.com/articles/2b9bf676fa57d014c79e086705a1ff82.html
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int K = words[0].length();
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> need = new HashMap<>();
        for (String word: words) {
            need.put(word, need.getOrDefault(word, 0) + 1);
        }
        for (int start = 0; start < K; start++) {
            int left = start, right = start, valid = 0;
            Map<String, Integer> window = new HashMap<>();
            while (right + K <= s.length()) {
                String w = s.substring(right, right + K);
                right += K;
                if (need.containsKey(w)) {
                    window.put(w, window.getOrDefault(w, 0) + 1);
                    if (window.get(w).equals(need.get(w))) valid++;
                }
                while (valid == need.size()) {
                    if (right - left == words.length * K) {
                        res.add(left);
                    }
                    w = s.substring(left, left + K);
                    left += K;
                    if (need.containsKey(w)) {
                        if (window.get(w).equals(need.get(w))) {
                            valid--;
                        }
                        window.put(w, window.get(w) - 1);
                    }
                }
            }
        }
        return res;
    }
}
