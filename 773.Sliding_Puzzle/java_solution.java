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
