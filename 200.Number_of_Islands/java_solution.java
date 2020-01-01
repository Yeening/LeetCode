class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        if(m==0) return 0;
        n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]=='1'){
                    DFSMark(grid, i, j); //DFS will mark visited island to sea
                    count++;
                }
            }
        }
        return count;
    }
    
    
    private void DFSMark(char[][] grid, int i, int j){
        if(i<0||j<0||i>=m||j>=n||grid[i][j]!='1') return;
        grid[i][j] = '0';
        DFSMark(grid, i-1, j); //up
        DFSMark(grid, i+1, j); //down
        DFSMark(grid, i, j-1); //left
        DFSMark(grid, i, j+1); //right
    }
}
