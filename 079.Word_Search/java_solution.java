class Solution {
    boolean[][] visited;
    int M, N;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0) return false;
        M = board.length;
        N = board[0].length;
        char[] wordArr = word.toCharArray();
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(search(board, wordArr, 0, i, j, word.length()))
                    return true;
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, char[] wordArr
                           , int index, int i, int j, int targetLen){
        if(index == targetLen) return true;
        if(i<0||i>=M||j<0||j>=N) return false;
        if(board[i][j]!=wordArr[index]) return false;
        board[i][j] = '*'; //set visited
        if(search(board, wordArr, index+1, i-1, j, targetLen)
              ||search(board, wordArr, index+1, i+1, j, targetLen)
              ||search(board, wordArr, index+1, i, j-1, targetLen)
              ||search(board, wordArr, index+1, i, j+1, targetLen)){
            return true;
        }
        else{
            board[i][j] = wordArr[index];
            return false;
        }
    }
}
