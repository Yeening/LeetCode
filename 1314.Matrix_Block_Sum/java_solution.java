// Solution: https://leetcode.com/problems/matrix-block-sum/discuss/477036/JavaPython-3-PrefixRange-sum-w-analysis-similar-to-LC-30478
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        if(mat== null || mat.length == 0||mat[0].length == 0) return null;
        int M = mat.length, N = mat[0].length;
        int[][] presum = new int[M+1][N+1];
        int[][] res = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++){
                presum[i+1][j+1] = presum[i][j+1] + presum[i+1][j] - 
                        presum[i][j] + mat[i][j];
            }
        }
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++){
                int x1 = Math.max(0, i - K), y1 = Math.max(0, j - K),
                        x2 = Math.min(M, i + K + 1), y2 = Math.min(N, j + K + 1);
                res[i][j] = presum[x2][y2] - presum[x1][y2] - 
                        presum[x2][y1] + presum[x1][y1];
            }
        }
        return res;
    }
}
