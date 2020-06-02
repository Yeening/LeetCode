class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] isPre = new boolean[n][n];
        List<Boolean> res = new LinkedList<>();
        for(int[] p: prerequisites){
            isPre[p[0]][p[1]] = true;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++)
                    isPre[j][k] = isPre[j][k] || isPre[j][i] && isPre[i][k];
            }
        }
        for(int[] q: queries){
            res.add(isPre[q[0]][q[1]]);
        }
        return res;
    }
}
