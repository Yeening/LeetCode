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

