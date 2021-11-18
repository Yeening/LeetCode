// DFS + serialize
// time: O(mn), space: O(mn)
class Solution {
    int[] dirs = new int[]{-1, 0, 1, 0, -1};
    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    visit(grid, i, j, 0, 0, sb);
                    String shape = sb.toString();
                    islands.add(shape);
                }
            }
        }
        return islands.size();
    }

    private void visit(int[][] grid, int i, int j, int x, int y, StringBuilder sb) {
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int nextI = i + dirs[k], nextJ = j + dirs[k+1], nextX = x + dirs[k], nextY = y + dirs[k+1];
            if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length) {continue;}
            if (grid[nextI][nextJ] != 1) {continue;}
            sb.append("#");
            sb.append(nextX);
            sb.append(",");
            sb.append(nextY);
            visit(grid, nextI, nextJ, nextX, nextY, sb);
        }
    }
}
