class Solution {
    int M;
    int[] status; //0: not visit; 1: visiting; 2: visited
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        M = numCourses;
        if(M == 0) return true;

        status = new int[M];
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for(int[] pre: prerequisites){
            if(!preMap.containsKey(pre[0])){
                preMap.put(pre[0], new ArrayList<>());
            }
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < M; i++){
            if(!DFS(preMap, i)) return false;
        }

        return true;
    }
    private boolean DFS(Map<Integer, List<Integer>> preMap, int i){
        if(status[i] == 1) return false;
        if(status[i] == 2) return true;
        if(!preMap.containsKey(i)) return true;
        status[i] = 1; //visiting
        for(int j: preMap.get(i)){
            if(DFS(preMap, j) == false) return false;
        }
        status[i] = 2;
        return true;
    }
}
