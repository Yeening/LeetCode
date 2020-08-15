class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set;
        for(int i = 0; i < 9; i++){
            boolean[] rowHas = new boolean[9];
            boolean[] colHas = new boolean[9];
            boolean[] boxHas = new boolean[9];
            int oriX = i/3, oriY = i%3*3;
            oriX *= 3;
            for(int j = 0; j < 9; j++){
                if(Character.isDigit(board[i][j])){
                    if(rowHas[board[i][j] - '1']) return false;
                    rowHas[board[i][j] - '1'] = true;
                }
                if(Character.isDigit(board[j][i])){
                    if(colHas[board[j][i] - '1']) return false;
                    colHas[board[j][i] - '1'] = true;
                }
                if(Character.isDigit(board[oriX + j/3][oriY + j%3])){
                    if(boxHas[board[oriX + j/3][oriY + j%3] - '1']) return false;
                    boxHas[board[oriX + j/3][oriY + j%3] - '1'] = true;
                }
            }
        }
        return true;
    }
}
