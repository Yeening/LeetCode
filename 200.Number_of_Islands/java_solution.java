// Recursive DFS
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

// Non-recursive DFS, 5ms
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void DFS(char[][] grid, int i, int j) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(i, j));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> point = stack.pop();
            int x = point.getKey(), y = point.getValue();
            if (grid[x][y] == '0') continue;
            grid[x][y] = '0';
            if (x > 0) stack.push(new Pair<>(x-1, y));
            if (x < grid.length - 1) stack.push(new Pair<>(x+1, y));
            if (y > 0) stack.push(new Pair<>(x, y-1));
            if (y < grid[0].length - 1) stack.push(new Pair<>(x, y+1));
        }
    }
}
