class Solution {
    // if i - x > 2b continue
    // [0, a+b+max(x, maxForbidden)] // this is the tricky part
    // prove: https://leetcode.com/problems/minimum-jumps-to-reach-home/discuss/978357/C%2B%2B-bidirectional-BFS-solution-with-proof-for-search-upper-bound
    // BFS, time: O(a+b+max(x, maxForbidden)), space:  O(a+b+max(x, maxForbidden))
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Map<Integer, Integer> visited = new HashMap<>();
        int maxForbidden = forbidden[0];
        for (int num: forbidden) {
            visited.put(num, 1);
            maxForbidden = Math.max(maxForbidden, num);
        }
        int upRange = a + b + Math.max(maxForbidden, x);
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(0, 0);
        int step = 0;
        while (!map1.isEmpty()) {
            Map<Integer, Integer> nextMap = new HashMap<>();
            for (int cur: map1.keySet()) {
                if (cur == x) {return step;}
                visited.putIfAbsent(cur, map1.get(cur));
                int next = cur + a;
                if (next <= upRange) {
                    if (cur == x) {return step + 1;}
                    if (!visited.containsKey(next) || 
                            visited.get(next) == 0) {
                        nextMap.put(next, 1);
                        visited.put(next, 1);
                    }
                }
                next = cur - b;
                if (next >= 0 && map1.get(cur) > 0) {
                    if (cur == x) {return step + 1;}
                    if (!visited.containsKey(next)) {
                        nextMap.put(next, map1.get(cur) - 1);
                        visited.put(next, 0);
                    }
                }
            }
            map1 = nextMap;
            step++;
        }
        return -1;
    }
}
