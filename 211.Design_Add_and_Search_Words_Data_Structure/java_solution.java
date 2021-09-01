class WordDictionary {

    class TrieNode{
        TrieNode(String word) {
            this.isWord = false;
            children = new TrieNode[26];
            childrenCount = 0;
        }
        TrieNode() {
            this.isWord = false;
            children = new TrieNode[26];
            childrenCount = 0;
        }
        int childrenCount;
        boolean isWord;
        TrieNode[] children;
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
                cur.childrenCount++;
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return searchTrie(word, 0, root);
    }

    private boolean searchTrie(String word, int wordStart, TrieNode root) {
        if (wordStart == word.length()) return root != null && root.isWord;
        if (root.childrenCount == 0) return false;
        char curChar = word.charAt(wordStart);
        if (curChar != '.') {
            return root.children[curChar - 'a'] != null &&
                    searchTrie(word, wordStart + 1, root.children[curChar - 'a']);
        } else {
            for (TrieNode next: root.children) {
                if (next != null && searchTrie(word, wordStart + 1, next)) {
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
