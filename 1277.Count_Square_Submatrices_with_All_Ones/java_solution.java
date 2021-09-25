// In-space dp, time: O(MN), space: O(1)
class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length ; j++) {
                if (i > 0 && j > 0 && matrix[i][j] == 1) {
                    matrix[i][j] = 1 + Math.min(matrix[i-1][j-1],
                                    Math.min(matrix[i-1][j], 
                                            matrix[i][j-1]));
                }
                res += matrix[i][j];
            }
        }
        return res;
    }

}

// memo, time: O(MN), space: O(MN)
class Solution {
    int[][] memo;

    public int countSquares(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int res = 0;
        memo = new int[M][N];
        for (int i = 0 ; i < M; i++){
            for (int j = 0; j < N ; j++) {
                res += squares(matrix, i, j);
            }
        }
        return res;
    }

    private int squares(int[][] matrix, int i, int j) {
        if (i > matrix.length - 1 || j > matrix[0].length - 1 ||                    matrix[i][j] == 0) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        memo[i][j] = 1 + Math.min( squares(matrix, i + 1, j + 1),
                Math.min(squares(matrix, i + 1, j), squares(matrix, i, j + 1)));
        return memo[i][j];
    }

}

// space-compressed dp, time: O(MN), space: O(N)
class Solution {
    /*
    M: num of rows, N: num of cols
    BF: time O(M^2N^2) space: O(1)
    
    DP: 
    squares[i][j]: count of squares using (i, j) as the bottom right corner
    for (i,j: matrix):
        squares[i][j] = min(squares[i-1][j], squares[i-1][j-1], sqaures[i][j-1]) + 1
    
    return sum(squares)
    
    DP:
    squares[j]: count of squares using (i, j) as the bottom right corner
    leftSquares = 0
    for (i,j: matrix):
        nextLeftSquares = min(squares[j], squares[j-1],                       leftSquares)
        if j > 0:
            square[j-1] = leftSquares
        leftSquares = nextLeftSquares
    square[N-1] = leftSquares
    
    
    [
    [1,0,1], 
    [1,1,0], i
     j
    [1,1,0]
    ]
    
    squares: 
    [0,0,1,1]
    
    countSquares: 3
    */
    public int countSquares(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        // squares[0,N-1]: square count to row number
        // sqaures[N]: square count of the left position to cur
        int[] squares = new int[N];
        int countSquares = 0, prevCount = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    if (j > 0) {
                        int leftUpperSquares = Math.min(squares[j], 
                                                    squares[j-1]);
                        leftUpperSquares = Math.min(leftUpperSquares, 
                                                    prevCount);
                        squares[j - 1] = prevCount;
                        prevCount = 1 + leftUpperSquares;
                    } else {
                        prevCount = 1;
                    }
                    countSquares += prevCount;
                } else {
                    if (j > 0) {
                        squares[j - 1] = prevCount;
                    }
                    prevCount = 0;
                }
            }
            squares[N-1] = prevCount;
        }
        
        return countSquares;
    }
}
