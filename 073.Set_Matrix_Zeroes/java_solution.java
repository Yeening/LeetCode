class Solution {
    public void setZeroes(int[][] matrix) {
        // Use the first element of a row or a col to record the status of a row/column
        // Exception: since (0, 0) can both represent the first row and the first column,
        // we artifically define that (0, 0) represents the first row, and define a sepreate value
        // col0 to be the symbol of the first column
        if(matrix == null || matrix.length == 0 || matrix[0].length==0) return;
        int col0 = 1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j == 0){
                        col0 = 0;
                        continue;
                    }
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                Arrays.fill(matrix[i], 0);
            }
        }
        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            Arrays.fill(matrix[0], 0);
               
        }
        if(col0 == 0){
            for(int i = 0; i < matrix.length; i++){
            matrix[i][0] = 0;
            }
        }
    }
}
