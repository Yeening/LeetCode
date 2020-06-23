//Rotating four rectangles, beating 82.73%, O(N^2)
class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        // int[] tmp = new int[4];
        int last = 0, current = 0;
        int[][] corners = {{0,0}, {0, N-1}, {N-1, N-1}, {N-1,0}};
        int[][] directions = {{1, 0, 0, 1}, {0, 1, -1, 0},
                              {-1, 0, 0, -1}, {0, -1, 1, 0}};
        for(int i = 0; i < N - N/2; i++){
            for(int j = 0; j < N/2; j++){
                for(int x = 0; x < 4; x++){
                    int xi = corners[x][0] + directions[x][0] * i + directions[x][1] * j;
                    int xj = corners[x][1] + directions[x][2] * i + directions[x][3] * j;
                    current = matrix[xi][xj];
                    matrix[xi][xj] = last;
                    last = current;
                }
                int xi = corners[0][0] + directions[0][0] * i + directions[0][1] * j;
                int xj = corners[0][1] + directions[0][2] * i + directions[0][3] * j;
                matrix[xi][xj] = last;
            }
        }
    }
}
