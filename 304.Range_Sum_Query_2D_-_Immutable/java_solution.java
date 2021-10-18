class NumMatrix {
    int[][] preSum;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        preSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    preSum[i][j] += preSum[i-1][j];
                }
                if (j > 0) {
                    preSum[i][j] += preSum[i][j-1];
                }
                if (j > 0 && i > 0) {
                    preSum[i][j] -= preSum[i-1][j-1];
                }
                preSum[i][j] += matrix[i][j];
            }
        }
    }
    
    private int getPreSum(int i, int j) {
        if (i < 0 || j < 0) {return 0;}
        return preSum[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = getPreSum(row2, col2) - getPreSum(row1 - 1, col2) 
            -getPreSum(row2, col1 - 1) + getPreSum(row1-1, col1-1);
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
