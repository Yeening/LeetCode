// Solution 1: basic BFS
class Solution {
    private class WordNode {
        String word;
        WordNode parent;
        public WordNode(String word, WordNode parent) {
            this.word = word;
            this.parent = parent;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Set<WordNode> q = new HashSet<>();
        q.add(new WordNode(beginWord, null));
        List<List<String>> res = new LinkedList<>();
        boolean foundLadder = false;
        while (!q.isEmpty() && !foundLadder) {
            Set<WordNode> nextQ = new HashSet<>();
            for (WordNode cur: q) {
                visited.add(cur.word);
                if (cur.word.equals(endWord)) {
                    foundLadder = true;
                    List<String> ladder = new ArrayList<>();
                    while (cur != null) {
                        ladder.add(cur.word);
                        cur = cur.parent;
                    }
                    Collections.reverse(ladder);
                    res.add(ladder);
                    continue;
                }
                for (String adj: adjacent(cur.word, wordSet)) {
                    if (!visited.contains(adj)) {
                        nextQ.add(new WordNode(adj, cur));
                    }
                }
            }
            q = nextQ;
        }
        return res;
    }

    private List<String> adjacent(String cur, Set<String> wordSet) {
        char[] ca = cur.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0 ; i < ca.length; i++){
            char former = ca[i];
            for (char j = 'a'; j <= 'z'; j++) {
                ca[i] = j;
                String newWord = new String(ca);
                if (wordSet.contains(newWord)) {
                    res.add(newWord);
                }
            }
            ca[i] = former;
        }
        return res;
    }
}
