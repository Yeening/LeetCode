//Recusion dynamic programming
class Solution {
public:
    int uniquePaths(int m, int n) {
        int paths[m+1][n+1];
        for(int i = 0; i < m+1;i++){
            for(int j = 0; j < n+1; j++)
                paths[i][j] = 0;
        }
        //Set final
        paths[1][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i + j == 2) continue;
                paths[i][j] =  paths[i][j-1] + paths[i-1][j];
            }
        }
        return paths[m][n];
    }
};
