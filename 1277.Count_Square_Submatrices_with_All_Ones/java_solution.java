class Solution {
    /*
    [
    [0,1,1,1],
    [1,1,1,1],
    [0,1,1,1]]
    
    */
    
    /*
    [
    [0,0,0,0],
    [0,0,0,0],
    [0,0,0,1]]
    
    */
    public int countSquares(int[][] matrix) {
        int res = 0;
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length ; j++) {
                if (i > 0 && j > 0 && matrix[i][j] == 1) {
                    matrix[i][j] = 1 + Math.min(matrix[i-1][j-1],
                                    Math.min(matrix[i-1][j], 
                                            matrix[i][j-1]));
                }
                res += matrix[i][j];
            }
        }
        return res;
    }

}
