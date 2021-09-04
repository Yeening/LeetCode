class Solution {
    int[][] LIP;
    int M;
    int N;
    public int longestIncreasingPath(int[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;
        LIP = new int[M][N];
        int max = 0;
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (LIP[i][j] == 0) {
                    max = Math.max(max, DFS(matrix, i, j));
                }
            }
        }
        return max;
    }
    
    private int DFS(int[][] matrix, int i, int j) {
        if (i < 0 || i >= M || j < 0 || j >= N) return 0;
        if (LIP[i][j] > 0) return LIP[i][j];
        LIP[i][j] = 1;
        int maxPath = 0;
        if (i > 0 && matrix[i-1][j] > matrix[i][j]) {
            maxPath = Math.max(maxPath, DFS(matrix, i-1, j));
        }
        if (i < M - 1 && matrix[i+1][j] > matrix[i][j]) {
            maxPath = Math.max(maxPath, DFS(matrix, i+1, j));
        }
        if (j > 0 && matrix[i][j-1] > matrix[i][j]) {
            maxPath = Math.max(maxPath, DFS(matrix, i, j-1));
        }
        if (j < N - 1 && matrix[i][j+1] > matrix[i][j]) {
            maxPath = Math.max(maxPath, DFS(matrix, i, j+1));
        }
        LIP[i][j] = 1 + maxPath;
        return LIP[i][j];
    }
}
