// first solution: BFS

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        if (numCourses == 0) return order;
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new LinkedList<>());
        }
        int[] indegrees = new int[numCourses];
        Queue<Integer> zeroIndegrees = new LinkedList<>();
        for (int[] pre: prerequisites) {
            int a = pre[0], b = pre[1];
            adjacency.get(b).add(a);
            indegrees[a]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                zeroIndegrees.add(i);
        }
        int index = 0;
        while (!zeroIndegrees.isEmpty()) {
            int cur = zeroIndegrees.poll();
            order[index++] = cur;
            for (int subCourse: adjacency.get(cur)) {
                if (--indegrees[subCourse] == 0) {
                    zeroIndegrees.add(subCourse);
                }
            }
        }
        if (index != numCourses) return new int[0];
        return order;
    }
}

// second solution: DFS, post-order traverse
class Solution {
    int[] order;
    int orderIndex;
    boolean[] visited;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new int[numCourses];
        orderIndex = 0;
        List<Integer>[] parents = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            parents[i] = new ArrayList<>(numCourses);
        }
        for (int[] pair: prerequisites) {
            parents[pair[0]].add(pair[1]);
        }
        visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (orderIndex == numCourses) break;
            if (!DFS(parents, i, new boolean[numCourses])) {
                // exist cycle
                return new int[]{};
            }
        }
        
        return order;
    }
    
    private boolean DFS(List<Integer>[] parents, int root, 
                        boolean[] inPath) {
        if (inPath[root]) return false;
        if (visited[root]) return true;
        inPath[root] = true;
        visited[root] = true;
        
        for (int parent: parents[root]) {
            if (!DFS(parents, parent, inPath)) {
                return false;
            }
        }
        
        inPath[root] = false;
        order[orderIndex++] = root;
        return true;
    }
}
