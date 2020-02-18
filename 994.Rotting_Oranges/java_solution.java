//BFS, 37%
class Solution {
    
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        
        int fresh = 0, time = 0;
        int m = grid.length, n = grid[0].length;
        Deque<int[]> rotten_pos = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //count fresh and save rotten positions
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) rotten_pos.add(new int[]{i, j});
            }
        }               
        if(fresh==0) return 0; //no fresh orange at initial
        
        //BFS
        int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        while(!rotten_pos.isEmpty()){
            int size = rotten_pos.size();
            for(int a = 0; a < size; a++){
                int[] pos = rotten_pos.pollFirst();
                for(int[] mov: directions){
                    int i = pos[0] + mov[0], j = pos[1] + mov[1];
                    //if next pos is illegal or already rotten or empty, do nothing
                    if(i<0||i>=m||j<0||j>=n||grid[i][j]==0||grid[i][j]==2) continue;
                    
                    //rot next pos
                    grid[i][j] = 2;
                    rotten_pos.add(new int[]{i, j});
                    fresh--;
                }
            }
            time++;
        }
        
        if(fresh>0) return -1; //exist unrotten orange
        return time-1;
    }
}
