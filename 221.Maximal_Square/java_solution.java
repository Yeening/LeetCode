class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int M = matrix.length, N = matrix[0].length, max = 0;
        int[][] maxSquare = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '0') continue;
                if (i == 0 || j == 0) maxSquare[i][j] = 1;
                else {
                    maxSquare[i][j] = Math.min(Math.min(maxSquare[i-1][j], maxSquare[i][j-1]), maxSquare[i-1][j-1]) + 1;
                }
                max = Math.max(max, maxSquare[i][j]);
            }
        }
        return max * max;
    }
}
