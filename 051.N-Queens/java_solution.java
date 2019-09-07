//Backtracking, Directly check the validity of each position, 3ms, 74%.
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = '.';
            }
        }
        DFS(0, map, n, res);
        return res; 
    }
    private void DFS(int row, char[][] map, int n, List<List<String>> res){
        if(row == n){
            res.add(construct(map));
            return;
        }
        for(int i = 0; i < n; i++){
            if(!val(row, i, map)) continue;
            //try
            map[row][i] = 'Q';
            DFS(row+1, map, n, res);
            //un-do
            map[row][i] = '.';
        }
    }
    private boolean val(int x, int y, char[][] map){
        //Validate whether can put a queen at a position
        for(int i = 0; i < x; i++){
            for(int j = 0; j < map.length; j++){
                if(map[i][j] == 'Q'){
                    if(j==y||(x-i)==Math.abs(y-j)) return false;
                }
            }
        }
        return true;
    }
    private List<String> construct(char[][] map){
        List<String> coned = new ArrayList<>();
        for(char[] row: map){
            coned.add(new String(row));
        }
        return coned;
    }
}
