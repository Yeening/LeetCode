class Solution {
    // time: O(N^2), sapce: O(N^2)
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] pair = new int[n];
        int unhappy = 0;
        for (int[] p: pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }
        int[][] preferenceOrder = new int[n][n];
        for(int i = 0; i < n; i++) {
            int order = 0;
            for (int j: preferences[i]) {
                preferenceOrder[i][j] = order++;
            }
        }
        for (int x = 0; x < n; x++) {
            int y = pair[x];
            for (int u: preferences[x]) {
                if (u == y) {break;}
                // x prefer u over y
                if (preferenceOrder[u][x] < preferenceOrder[u][pair[u]]) {
                    unhappy++;
                    break;
                }
            }
        }
        return unhappy;
    }
}
