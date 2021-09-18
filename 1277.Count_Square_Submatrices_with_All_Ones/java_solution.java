// In-space dp, time: O(MN), space: O(1)
class Solution {
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

// memo, time: O(MN), space: O(MN)
class Solution {
    int[][] memo;

    public int countSquares(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int res = 0;
        memo = new int[M][N];
        for (int i = 0 ; i < M; i++){
            for (int j = 0; j < N ; j++) {
                res += squares(matrix, i, j);
            }
        }
        return res;
    }

    private int squares(int[][] matrix, int i, int j) {
        if (i > matrix.length - 1 || j > matrix[0].length - 1 ||                    matrix[i][j] == 0) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        memo[i][j] = 1 + Math.min( squares(matrix, i + 1, j + 1),
                Math.min(squares(matrix, i + 1, j), squares(matrix, i, j + 1)));
        return memo[i][j];
    }

}
