// Solution 1: DFS

class Solution {
    private boolean[] visited;
    private int N;
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return 0;
        N = isConnected.length;
        visited = new boolean[N];
        int province = 0;
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                DFS(i, isConnected);
                province++;
            }
        }
        return province;
    }

    private void DFS(int i, int[][] isConnected) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < N; j++) {
            if (isConnected[i][j] == 1) {
                DFS(j, isConnected);
            }
        }
    }
}

// Solution 2: Union find with path compress

class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return 0;
        int N = isConnected.length;
        int[] root = new int[N];
        int province = N;
        for (int i = 0 ; i < N; i++) {
            root[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isConnected[i][j] == 1) {
                    int rootI = find(i, root);
                    int rootJ = find(j, root);
                    if (rootI != rootJ) {
                        root[rootI] = root[rootJ];
                        province--;
                    }
                }
            }
        }
        return province;
    }

    private int find(int i, int[] root) {
        while(root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}
