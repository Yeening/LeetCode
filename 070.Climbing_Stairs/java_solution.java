class Solution {
    public int climbStairs(int n) {
        if(n<3) return n;
        int[] climb = new int[n+1];
        climb[1] = 1;
        climb[2] = 2;
        for(int i = 3; i <= n; i++){
            climb[i] = climb[i-1] + climb[i-2];
        }
        return climb[n];
    }
}
