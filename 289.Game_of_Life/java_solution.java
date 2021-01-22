class Solution{
    int M;
    int N;
    private final int LIVE = 3;
    private final int DIE = 4;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length ==0) return;
        M = board.length;
        N = board[0].length;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int cur = board[i][j];
                int nei = count(board, i, j);
                boolean liveNext = (cur == 1 && nei == 2) || nei == 3;
                if(cur == 0 && liveNext) board[i][j] = LIVE;
                else if(cur == 1 && !liveNext) board[i][j] = DIE;
            }
        }
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int cur = board[i][j];
                if(cur == LIVE) board[i][j] = 1;
                else if(cur == DIE) board[i][j] = 0;
            }
        }
    }
    private int count(int[][] board, int i, int j) {
        int res = 0;
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for(int[] mov: dirs){
            int x = i + mov[0], y = j + mov[1];
            if(x >= 0 && x < M && y >= 0 && y < N){
                if(board[x][y] == 1 || board[x][y] == DIE) res++;
            }
        }
        return res;
    }
}
