class Trie {
    
    Node head;

    private class Node{
        Node[] children = new Node[26];
        boolean isWord = false;
        Node(){}
        Node(boolean isWord) {
            this.isWord = isWord;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        head = new Node(false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p = head;
        for(char c: word.toCharArray()) {
            if(p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new Node();
            }
            p = p.children[c - 'a'];
        }
        p.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p = head;
        for(char c: word.toCharArray()) {
            if(p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return p.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p = head;
        for(char c: prefix.toCharArray()) {
            if(p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
