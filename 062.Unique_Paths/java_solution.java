class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m+1][n+1];
        paths[0][1] = 1; //set a virtul start point
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m][n];
    }
}
