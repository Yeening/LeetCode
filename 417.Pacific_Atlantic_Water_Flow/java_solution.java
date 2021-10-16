class Solution {
    Boolean[][] pacific;
    Boolean[][] atlantic;
    int m;
    int n;
    List<List<Integer>> res;
    int[] dirs = new int[] {-1, 0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        res = new ArrayList<>();
        pacific = new Boolean[m][n];
        atlantic = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            reverseFlood(heights, i, 0, pacific);
            reverseFlood(heights, i, n-1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            reverseFlood(heights, 0, j, pacific);
            reverseFlood(heights, m-1, j, atlantic);
        }
        return res;
    }
    
    private void reverseFlood(int[][] heights, int i, int j, 
                              Boolean[][] ocean) {
        if (ocean[i][j] != null) {return;}
        ocean[i][j] = true;
        if (pacific[i][j] != null && atlantic[i][j] != null 
            && pacific[i][j]&& atlantic[i][j]) {
            List<Integer> cor = new ArrayList(2);
            cor.add(i);
            cor.add(j);
            res.add(cor);
        }
        for (int d = 0; d < 4; d++) {
            int nextI = i + dirs[d], nextJ = j + dirs[d+1];
            if (nextI < 0 || nextI > m - 1 || 
                nextJ < 0 || nextJ > n - 1) {continue;}
            if (heights[nextI][nextJ] < heights[i][j]) {continue;}
            if (ocean[nextI][nextJ] != null) {continue;}
            reverseFlood(heights, nextI, nextJ, ocean);
        }
    }
}
