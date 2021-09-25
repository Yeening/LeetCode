class DetectSquares {
    
    /*
    search for the diagnoal points to the query point
    1. go through x, for each x != point.x: 
        1.1 x - point.x = y - point.y
        1.2 x - point.x = point.y - y
    2. sum += pointCount[x][y] * pointcount[x][point.y] * pointCount[point.x][y]
    */
    // how many points are there at each position
    int[][] pointCounts = new int[1001][1001];
    // use these sets to limit the iteration times
    Set<Integer> xCors = new HashSet<>(); 
    Set<Integer> yCors = new HashSet<>();

    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        xCors.add(x);
        yCors.add(y);
        pointCounts[x][y]++;
    }
    
    public int count(int[] point) {
        int count = 0, startX = point[0], startY = point[1];
        for (int x: xCors) {
            if (x == startX) continue;
            int y = startY + x - startX;
            if (yCors.contains(y)) {
                count += pointCounts[x][y] * 
                    pointCounts[x][startY] * pointCounts[startX][y];
            }
            y = startY + startX - x;
            if (yCors.contains(y)) {
                count += pointCounts[x][y] * 
                    pointCounts[x][startY] * pointCounts[startX][y];
            }
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
