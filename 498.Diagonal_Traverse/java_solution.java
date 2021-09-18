class Solution {
    int M;
    int N;
    public int[] findDiagonalOrder(int[][] mat) {
        M = mat.length;
        N = mat[0].length;
        int[] res = new int[M*N];
        int index = 0; // 6
        boolean reverse = false;
        for (int i = 0; i < M; i++) { // i = 2
            int diagLen = Math.min(i+1, N);
            if (reverse) {
                diag(mat, i, 0, res, index + diagLen - 1, -1);
            } else {
                diag(mat, i, 0, res, index, 1); 
            }
            reverse = !reverse;
            index += (diagLen);
        }
        
        for (int j = 1; j < N; j++) { // 1
            int diagLen = Math.min(M, N-j); // 2
            if (reverse) {
                diag(mat, M-1, j, res, index + diagLen - 1, -1);
            } else {
                diag(mat, M-1, j, res, index, 1);
            }
            reverse = !reverse;
            index += (diagLen);
        }
        
        return res;
    }
    
    private void diag(int[][] mat, int i, int j, int[] res, 
                      int index, int dir) {
        while (i >= 0 && j < N) { // 2, 1, index: 7
            res[index] = mat[i--][j++];
            index += dir;
        }
    }
}
