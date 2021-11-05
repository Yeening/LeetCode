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

// back-tracking and trie
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    TrieNode root;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        for (String word: wordDict) {
            addWord(word, root);
        }
        List<String> res = new ArrayList<>();
        wordBreak(s, 0, root, new ArrayList<>(), res);
        return res;
    }
    
    private void wordBreak(String s, int start, TrieNode node,
                           List<String> sb, List<String> res) {
        if (start == s.length()) {
            if (node == root) {
                res.add(sb.stream().collect(Collectors.joining(" ")));
            }
            return;
        }
        char cur = s.charAt(start);
        if (node.children[cur - 'a'] == null) {
            return;
        }
        wordBreak(s, start + 1, node.children[cur - 'a'], sb, res);
        if (node.children[cur - 'a'].word != null) {
            sb.add(node.children[cur - 'a'].word);
            wordBreak(s, start + 1, root, sb, res);
            sb.remove(sb.size() - 1);
        }
    }
    
    private void addWord(String word, TrieNode root) {
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (root.children[cur - 'a'] == null) {
                root.children[cur - 'a'] = new TrieNode();
            }
            root = root.children[cur - 'a'];
        }
        root.word = word;
    }
}
