// back-tracking + memo, 1ms, 100%
class Solution {
    Boolean[][] isWord;
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() == 0) return res;
        isWord = new Boolean[s.length()][s.length()];
        subWordBreak(s, 0, new HashSet<>(wordDict), new LinkedList<>(), res);
        return res;
    }

    private void subWordBreak(String s, int start, Set<String> wordSet,
                              LinkedList<String> cur, List<String> res) {
        if (start >= s.length() && cur.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for(String word: cur) {
                sb.append(word);
                sb.append(' ');
            }
            res.add(sb.toString().trim());
            return;
        }
        for(int i = start; i < s.length(); i++) {
            if (isWord[start][i] == null) {
                isWord[start][i] = wordSet.contains(s.substring(start, i+1));
            }
            if (isWord[start][i]) {
                cur.addLast(s.substring(start, i+1));
                subWordBreak(s, i+1, wordSet, cur, res);
                cur.removeLast();
            }
        }
    }
}
