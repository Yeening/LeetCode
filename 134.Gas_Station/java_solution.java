// Start from a random station, if the current l->r sum < 0, then move the start back, otherwise, there is enough gas, then move the end forward.
public static class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 1) return gas[0] >= cost[0]? 0: -1;
        int l = 0, r = 1, tank = gas[0] - cost[0];
        while(l != r) {
            if (tank < 0) {
                l = (n + l - 1) % n;
                tank += (gas[l] - cost[l]);
            } else {
                tank += (gas[r] - cost[r]);
                r = (r + 1) % n;
            }
        }
        return tank < 0? -1: l;
    }
}
