class Solution {
    int[][] dirs = new int[][]{
        {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,-1},{-1,0}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {return -1;}
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cur = queue.poll();
                if (cur == n*n - 1) {return step;}
                int i = cur / n, j = cur % n;
                for (int[] dir: dirs) {
                    int nextI = i + dir[0], nextJ = j + dir[1];
                    if (isValid(grid, nextI, nextJ, visited)) {
                        if (nextI == n-1 && nextJ == n - 1) {return step + 1;}
                        queue.offer(nextI * n + nextJ);
                    }
                }
            }
            step++;
        }
        return visited.contains(n * n - 1)? step: -1;
    }
    
    private boolean isValid(int[][] grid, 
                            int nextI, int nextJ, Set<Integer> visited) {
        int n = grid.length;
        if (nextI < 0 || nextI > n - 1 
            || nextJ < 0 || nextJ > n - 1 ) {return false;}
        if (grid[nextI][nextJ] == 1 || visited.contains(nextI * n + nextJ)) {
            return false;
        }
        visited.add(nextI * n + nextJ);
        return true;
    }
}
