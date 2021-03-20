// Detail: https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
// Solution 1: DFS
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

// Solution 2: indegree table, BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null
                || prerequisites.length == 0 || prerequisites[0].length != 2)
            return true;
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> subCourses = new HashMap<>();
        for (int[] pre: prerequisites) {
            int a = pre[0], b = pre[1];
            indegrees[b]++;
            if (!subCourses.containsKey(a)) {
                subCourses.put(a, new ArrayList<>());
            }
            subCourses.get(a).add(b);
        }
        Queue<Integer> zeroIndegrees = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                zeroIndegrees.add(i);
                numCourses--;
            }
        }
        while (numCourses > 0 && !zeroIndegrees.isEmpty()) {
            int cur = zeroIndegrees.poll();
            if (subCourses.containsKey(cur)) {
                for (int i: subCourses.get(cur)) {
                    indegrees[i]--;
                    if (indegrees[i] == 0) {
                        zeroIndegrees.add(i);
                        numCourses--;
                    }
                }
            }
        }
        return numCourses == 0;
    }
}
