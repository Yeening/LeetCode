//Backtracking, using flag array, 96%
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        //row index: y, 45-index: x + y + n, 135-index: x - y + 4*n - 1
        boolean[] flag = new boolean[5*n];
        solveNQueens(0, n, flag);
        return count;
    }
    private void solveNQueens(int x, int n, boolean[] flag){
        if(x == n) count++;
        //put queens on the positions of the row
        for(int y = 0; y < n; y++){
            if(!flag[y]&&!flag[x + y + n]&&!flag[x - y + 4*n - 1]){
                flag[y] = flag[x+y+n] = flag[x-y+4*n-1] = true;
                solveNQueens(x+1, n, flag);
                flag[y] = flag[x+y+n] = flag[x-y+4*n-1] = false;
            }
        }
    }
}
