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
