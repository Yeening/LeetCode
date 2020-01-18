//Solution1: DFS, 35%, 7ms
// class Solution {
//     public int countComponents(int n, int[][] edges) {
//         int res = 0;
//         if(n==0) return 0;
//         boolean[] visited = new boolean[n];
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         for(int i = 0; i < n; i++){
//             map.put(i, new ArrayList<>());
//         }
//         for(int[] edge: edges){
//             map.get(edge[0]).add(edge[1]);
//             map.get(edge[1]).add(edge[0]);
//         }
//         for(int i = 0; i < n; i++){
//             if(!visited[i]){
//                 DFS(map, visited, i);
//                 res++;
//             }
//         }
//         return res;
//     }
    
//     private void DFS(Map<Integer, List<Integer>> map, boolean[] visited, int i){
//         visited[i] = true;
//         List<Integer> nextPoints = map.get(i);
//         if(nextPoints==null) return;
//         for(int j = 0; j < nextPoints.size(); j++){
//             int next = nextPoints.get(j);
//             if(!visited[next]) DFS(map, visited, next);
//         }
//     }
// }

//Solution2: 1ms, 100%
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        int res = n;
        for(int i = 0; i < n; i++){
            roots[i] = i;
        }
        for(int[] edge: edges){
            int root1 = getRoot(roots, edge[0]);
            int root2 = getRoot(roots, edge[1]);
            if(root1!=root2){
                roots[root1] = root2;
                res--;
            }
        }
        return res;
    }
    
    private int getRoot(int[] roots, int current){
        while(roots[current]!=current){
            roots[current] = roots[roots[current]];
            current = roots[current];
        }
        return current;
    }
}
