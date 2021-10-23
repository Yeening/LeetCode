class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a->a[0] - a[1]));
        int cost = 0, half = costs.length/2;
        for (int i = 0; i < costs.length; i++) {
            if (i < half) {
                cost += costs[i][0];
            } else {
                cost += costs[i][1];
            }
        }
        return cost;
    }
}
