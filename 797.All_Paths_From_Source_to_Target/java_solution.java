class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        visit(graph, 0, new ArrayList<>(Arrays.asList(0)), res);
        return res;
    }
    
    private void visit(int[][] graph, int i, 
                       ArrayList<Integer> path, List<List<Integer>> res) {
        if (i == graph.length - 1) {
            res.add(new LinkedList(path));
            return;
        }
        for(int j: graph[i]) {
            path.add(j);
            visit(graph, j, path, res);
            path.remove(path.size()-1);
        }
    }
}
