private int M;
private int N;

int[] dir = new int[]{-1, 0, 1, 0, -1};

public int shortestDistanceFromAllBuildings(int[][] matrix) {
    M = matrix.length;
    N = matrix[0].length;
    int houseCount = 0;
    int[][] reachable = new int[M][N];
    int[][] totalDistance = new int[M][N];
    for (int i = 0; i < M ; i++) {
        for (int j = 0; j < N; j++) {
            if (matrix[i][j] == 1) {
                houseCount++;
                if (!BFS(matrix, i, j, reachable, totalDistance)) return -1;
            }
        }
    }
    int minDis = Integer.MAX_VALUE;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            if (matrix[i][j] == 0 && reachable[i][j] == houseCount) {
                minDis = Math.min(minDis, totalDistance[i][j]);
            }
        }
    }
    return minDis == Integer.MAX_VALUE? -1: minDis;
}


private boolean BFS(int[][] matrix, int i, int j, int[][] reachable, int[][] totalDistance) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    queue.add(i*N+j);
    visited.add(i*N+j);
    int distance = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        distance++;
        while (size-- > 0) {
            int cur = queue.poll();
            int x = cur / N, y = cur % N;
            for (int k = 0; k < 4; k++) {
                int nextX = x + dir[k], nextY = y + dir[k+1];
                if (isValid(matrix, nextX, nextY, visited) && matrix[nextX][nextY] == 0){
                    reachable[nextX][nextY]++;
                    totalDistance[nextX][nextY] += distance;
                    queue.add(nextX*N+nextY);
                }
            }
        }
    }

    for (int x = 0; x < M; x++) {
        for (int y = 0; y < N; y++) {
            if (matrix[x][y] == 1 && !visited.contains(x*N+y)) return false;
        }
    }

    return true;
}

private boolean isValid(int[][] matrix, int x, int y, Set<Integer> visited) {
    if (x < 0 || x > M - 1 || y < 0 || y > N -1 || matrix[x][y] == 2 || visited.contains(x*N+y)) {
        return false;
    }
    visited.add(x*N + y);
    return true;
}
