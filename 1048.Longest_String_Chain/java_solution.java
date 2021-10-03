class Solution {
    // DP, time: O(N*wordLen^2)
    public int longestStrChain(String[] words) {
        Map<String, Integer> wordChainLen = new HashMap<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int maxLen = 1;
        for (String cur: words) {
            wordChainLen.put(cur, 1);
            for (int i = 0; i < cur.length(); i++) {
                String predecessor = cur.substring(0, i) + cur.substring(i + 1);
                if (wordChainLen.containsKey(predecessor)) {
                    wordChainLen.put(cur, Math.max(
                        wordChainLen.get(cur), 
                        wordChainLen.get(predecessor) + 1));
                    maxLen = Math.max(maxLen, wordChainLen.get(cur));
                }
            }
        }
        return maxLen;
    }
}
