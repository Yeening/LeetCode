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
    //Soluiton 2: using three flag arrays
    // public List<List<String>> solveNQueens(int n) {
    //     char[][] map = new char[n][n];
    //     boolean[] flag = new boolean[n]; //flag for columns
    //     boolean[] flag_45 = new boolean[n*2 - 1];  //flag for 45 degree slashes, index = x + y
    //     boolean[] flag_135 = new boolean[n*2 - 1]; //index = n + x - y - 1
    //     List<List<String>> res = new ArrayList<>();
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < n; j++){
    //             map[i][j] = '.';
    //         }
    //     }
    //     DFS(0, map, n, flag, flag_45, flag_135, res);
    //     return res; 
    // }
    // private void DFS(int row, char[][] map, int n,boolean[] flag,boolean[] flag_45, boolean[] flag_135, List<List<String>> res){
    //     if(row == n){
    //         res.add(construct(map));
    //         return;
    //     }
    //     for(int i = 0; i < n; i++){
    //         if(flag[i]||flag_45[row+i]||flag_135[n + row - i - 1]) continue;
    //         map[row][i] = 'Q';
    //         flag[i] = true;
    //         flag_45[i + row] = true;
    //         flag_135[n + row - i - 1] = true;
    //         DFS(row+1, map, n, flag, flag_45, flag_135, res);
    //         map[row][i] = '.';
    //         flag[i] = false;
    //         flag_45[i + row] = false;
    //         flag_135[n + row - i - 1] = false;
    //     }
    // }
    // private List<String> construct(char[][] map){
    //     List<String> coned = new ArrayList<>();
    //     for(char[] row: map){
    //         coned.add(new String(row));
    //     }
    //     return coned;
    // }
    
    //Solution3: using 1 flag array, 100%
    public List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        //45 degree slashes index =n + x + y; 135 degree index = 4*n + x - y - 1
        boolean[] flag = new boolean[n*5]; //flag for columns
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = '.';
            }
        }
        DFS(0, map, n, flag, res);
        return res; 
    }
    private void DFS(int row, char[][] map, int n,boolean[] flag, List<List<String>> res){
        if(row == n){
            res.add(construct(map));
            return;
        }
        for(int i = 0; i < n; i++){
            if(flag[i]||flag[row+i+n]||flag[n*4 + row - i - 1]) continue;
            map[row][i] = 'Q';
            flag[i] = flag[i + row + n] = flag[n*4 + row - i - 1] = true;
            DFS(row+1, map, n, flag, res);
            map[row][i] = '.';
            flag[i] = flag[i + row + n] = flag[n*4 + row - i - 1] = false;
        }
    }
    private List<String> construct(char[][] map){
        List<String> coned = new ArrayList<>();
        for(char[] row: map){
            coned.add(new String(row));
        }
        return coned;
    }
}
