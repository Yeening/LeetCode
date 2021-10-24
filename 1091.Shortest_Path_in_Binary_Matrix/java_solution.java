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

// A*

/*
[1,2,*,0,0,0,0],
[2,*,3,0,5,6,1],
[9,3,*,4,*,6,7],
[8,7,4,*,*,*,7],
[*,6,5,*,*,8,0],
[*,*,*,*,*,9,*],
[0,0,*,0,0,0,10]]

*/

class Solution {
    int[][] dirs = new int[][]{
        {1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,-1},{-1,0}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {return -1;}
        // i, j, point
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        Map<Integer, Integer> pathFromStart = new HashMap<>();
        pq.offer(new int[]{0,0,heuristic(0,0,n) + 1});
        pathFromStart.put(0, 1);
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1], 
                fromStart = pathFromStart.get(i*n + j);
            if (i == n - 1 && j == n - 1) {
                return pathFromStart.get(n * n - 1);
            }
            for (int[] dir: dirs) {
                int nextI = i + dir[0], nextJ = j + dir[1];
                if (isValid(grid, nextI, nextJ, pathFromStart, fromStart)) {
                    pq.offer(new int[]{nextI, nextJ, fromStart + 1});
                }
            }
        }
        return pathFromStart.getOrDefault(n * n - 1, -1);
    }
    
    private boolean isValid(int[][] grid, 
                            int nextI, int nextJ, 
                            Map<Integer, Integer> pathFromStart,
                           int curStep) {
        int n = grid.length;
        if (nextI < 0 || nextI > n - 1 
            || nextJ < 0 || nextJ > n - 1 ) {return false;}
        if (grid[nextI][nextJ] == 1) {
            return false;
        }
        int key = nextI*n+nextJ;
        if (pathFromStart.getOrDefault(key,n*n+1) <= curStep + 1) {
            return false;
        }
        pathFromStart.put(key, curStep + 1);
        return true;
    }
    
    private int heuristic(int i, int j, int n) {
        return n - i + n - j;
    }
}
