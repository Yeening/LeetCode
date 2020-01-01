class Solution {
    // Using Trie to store words, quick to check whether a word exist, quick to early stop from invalid current status
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word = null;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        TrieNode p;
        for(String word:words){
            p = root;
            for(char c: word.toCharArray()){
                if(p.next[c - 'a']==null) p.next[c - 'a'] = new TrieNode();
                p = p.next[c - 'a'];
            }
            //Set the leaf node's word to current word, replacing StringBuilder
            p.word = word;
        }
        return root;
    }
    
    private void dfsSearch(char[][] board, int i, int j, 
                           TrieNode p, List<String> res){
        if(i<0||j<0||i>=board.length||j>=board[0].length) return;
        char c = board[i][j];
        if(c=='#'||p.next[c-'a']==null) return;
        
        p = p.next[c - 'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word = null; //avoid duplicate
        }
        
        board[i][j] = '#'; //visit
        //p's pointing address will not change in other calls
        dfsSearch(board, i-1, j, p, res);
        dfsSearch(board, i+1, j, p, res);
        dfsSearch(board, i, j-1, p, res);
        dfsSearch(board, i, j+1, p, res);
        board[i][j] = c; //back-tracking, recover the board
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board.length==0||board[0].length==0) return res;
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfsSearch(board, i, j, root, res);
            }
        }
        return res;
    }
}
