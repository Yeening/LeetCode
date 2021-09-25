class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] neighbors = new int[][] {
                {1, 3}, {0, 2, 4}, {1, 5},
                {0, 4}, {1, 3, 5}, {2, 4}};
        int[] target = new int[]{1, 2, 3, 4, 5, 0};
        Set<String> visited = new HashSet<>();
        int[] flatBoard = new int[6];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                flatBoard[i*3+j] = board[i][j];
            }
        }

        Deque<int[]> deque = new LinkedList<>();
        deque.add(flatBoard);
        int steps = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0 ; i < size; i++) {
                int[] cur = deque.pollFirst();
                String key = Arrays.toString(cur);
                if (visited.contains(key)) continue;
                visited.add(key);
                if (Arrays.equals(cur, target)) return steps;
                int empty = 0;
                for (int j = 0; j < 6; j++) {
                    if (cur[j] == 0) {
                        empty = j;
                        break;
                    }
                }
                for (int j: neighbors[empty]) {
                    swap(cur, empty, j);
                    deque.add(Arrays.copyOf(cur, 6));
                    swap(cur, empty, j);
                }
            }
            steps++;
        }
        return -1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


// Solution 2: a little optimized code

class Solution {
    // state: [1,2,3,4,0,5], blank: 4; points
    // choices: [[1,3], [0,2,4], [1,5], [0,4], [1,3,5], [2,4]]; edges
    /*
    start state -> solved min moves
    BFS
    queue.offer(initial_state)
    visited.add(initial_state)
    
    for each state:
        if state == solved:
            return moves
        for each next_move:
            if (!visited(next_move)):
                queue.offer(next_move)
                
    */
    
    private final int[][] choice = new int[][]{
        {1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}
    };
    public int slidingPuzzle(int[][] board) {
        final String SOLVED = Arrays.toString(new int[]{1,2,3,4,5,0});
        int[] initialState = new int[6];
        System.arraycopy(board[0], 0, initialState, 0, 3);
        System.arraycopy(board[1], 0, initialState, 3, 3);
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int step = 0;
        
        queue.offer(initialState);
        visited.add(Arrays.toString(initialState));
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curState = queue.poll();
                String curKey = Arrays.toString(curState);
                if (curKey.equals(SOLVED)) {return step;}
                for (int[] nextState: neighbor(curState, visited)) {
                    queue.offer(nextState);
                }
            }
            step++;
        }
        
        return -1;
    }
    
    private List<int[]> neighbor(int[] curState, 
                                 Set<String> visited) {
        int empty = 0;
        List<int[]> res = new ArrayList<>(3);
        while(empty < 6) {
            if (curState[empty] == 0) break;
            empty++;
        }
        
        for (int adjacent: choice[empty]) {
            curState[empty] = curState[adjacent];
            curState[adjacent] = 0;
            String nextKey = Arrays.toString(curState);
            if (!visited.contains(nextKey)) {
                visited.add(nextKey);
                res.add(Arrays.copyOf(curState, 6));
            }
            curState[adjacent] = curState[empty];
            curState[empty] = 0;
        }
        
        return res;
    }
}
