public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        while (true) {
            boolean crush = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int type = Math.abs(board[i][j]);
                    if (type != 0) {
                        if (j < n - 2 && Math.abs(board[i][j+1]) == type
                                && Math.abs(board[i][j+2]) == type) {
                            for (int k = j; k < n && Math.abs(board[i][k]) == type; k++) {
                                board[i][k] = -type;
                            }
                        }
                        if (i < m - 2 && Math.abs(board[i+1][j]) == type
                                && Math.abs(board[i+2][j]) == type) {
                            for (int k = i; k < m && Math.abs(board[k][j]) == type; k++) {
                                board[k][j] = -type;
                            }
                        }
                    }
                }
            }
            // make all negative values zero
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] < 0) {
                        board[i][j] = 0;
                        crush = true;
                    }
                }
            }
            if (!crush) {break;}
            // drop
            for (int j = 0; j < n; j++) {
                int iIndex = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {board[iIndex--][j] = board[i][j];}
                }
                while (iIndex >= 0) {board[iIndex--][j] = 0;}
            }
        }
        return board;
    }
