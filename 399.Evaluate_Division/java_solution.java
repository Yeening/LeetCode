// DFS, 1ms
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build transfer map
        Map<String, Map<String, Double>> transfers = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double ratio = values[i];
            transfers.putIfAbsent(equation.get(0), new HashMap<>());
            transfers.get(equation.get(0)).put(equation.get(1), ratio);
            transfers.putIfAbsent(equation.get(1), new HashMap<>());
            transfers.get(equation.get(1)).put(equation.get(0), 1d/ratio);
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            List<String> query = queries.get(i);
            res[i] = calc(query.get(0), query.get(1), new HashSet<>(), transfers);
        }
        
        return res;
    }
    
    private double calc(String from, String to, Set<String> visited,
                        Map<String, Map<String, Double>> transfers) {
        if (!transfers.containsKey(from) 
            || !transfers.containsKey(to)) {return -1d;}
        if (from.equals(to)) {return 1d;}
        visited.add(from);
        Double ratio = transfers.get(from).get(to);
        if (ratio != null) {return ratio;}
        
        for (Map.Entry<String, Double> next: transfers.get(from).entrySet()) {
            if (visited.contains(next.getKey())) {continue;}
            double nextRatio = calc(next.getKey(), to, visited, transfers);
            if (nextRatio >= 0) {
                transfers.get(from).put(to, next.getValue() * nextRatio);
                return next.getValue() * nextRatio;
            }
        }
        
        return -1d;
    }
}
// BFS, 2ms
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build adjacent map
        Map<String, Map<String, Double>> adjacent = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String first = equation.get(0), second = equation.get(1);
            adjacent.putIfAbsent(first, new HashMap<>());
            adjacent.putIfAbsent(second, new HashMap<>());
            adjacent.get(first).put(second, values[i]);
            adjacent.get(first).put(first, 1d);
            adjacent.get(second).put(first, 1d / values[i]);
            adjacent.get(second).put(second, 1d);
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> equation = queries.get(i);
            String first = equation.get(0), second = equation.get(1);
            if (!adjacent.containsKey(first) || !adjacent.containsKey(second)) {
                res[i] = -1d;
                continue;
            }
            res[i] = search(adjacent, first, second);
        }
        return res;
    }
    
    // pre: adjacent.contiansKey(start) && adjacent.contiansKey(end)
    private double search(Map<String, Map<String, Double>> adjacent, 
                          String start, String end) {
        assert(adjacent.containsKey(start) && adjacent.containsKey(end));
        Deque<Pair<String, Double>> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair<>(start, 1d));
        visited.add(start);
        while (!queue.isEmpty()) {
            Pair<String, Double> cur = queue.poll();
            String curVar = cur.getKey();
            double curPoss = cur.getValue();
            if (curVar.equals(end)) {return curPoss;}
            for (Map.Entry<String, Double> next: 
                 adjacent.get(curVar).entrySet()) {
                if (visited.contains(next.getKey())) {continue;}
                visited.add(next.getKey());
                double nextPoss = next.getValue() * curPoss;
                adjacent.get(start)
                    .put(next.getKey(), nextPoss);
                queue.offer(new Pair<>(next.getKey(), nextPoss));
            }
        }
        Double poss = adjacent.get(start).get(end);
        return poss == null? -1: poss;
    }
}
