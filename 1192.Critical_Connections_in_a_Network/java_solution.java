class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        if(n==0||connections.isEmpty()) return res;
        List<Integer>[] graph = new ArrayList[n]; //store connections of each point
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        int[] ranks = new int[n];
        Arrays.fill(ranks, -1);
        
        //build graph
        for(int i = 0; i < connections.size(); i++){
            int from = connections.get(i).get(0), to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
        
        ranks[0] = 0;
        DFS(graph, -1, 0, ranks, res);
        return res;
    }
    
    
    private int DFS(List<Integer>[] graph, int parent, int currentPoint, int[] ranks, List<List<Integer>> res){
        List<Integer> currentConnections = graph[currentPoint];
        //visit current point
        int currentRank = ranks[currentPoint];
        int minRank = currentRank;
        
        for(int i = 0; i < currentConnections.size(); i++){
            int nextPoint = currentConnections.get(i);
            if(nextPoint == parent) continue; //not visit parent again
            if(ranks[nextPoint] < 0){
                ranks[nextPoint] = currentRank + 1;
                int nextMinRank = DFS(graph, currentPoint, nextPoint, ranks, res);
                minRank = Math.min(minRank, nextMinRank); //update minRank if next point finds a smaller minRank
                if(nextMinRank > currentRank){
                    res.add(Arrays.asList(currentPoint, nextPoint));
                }
            }
            //update if finds a smaller rank
            minRank = Math.min(minRank, ranks[nextPoint]);
        }
        return minRank;
    }
}
