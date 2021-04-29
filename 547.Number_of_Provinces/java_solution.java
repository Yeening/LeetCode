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
