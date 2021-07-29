// Solution 1: using used array
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        boolean[] used = new boolean[n+1];
        List<List<Integer>> res = new LinkedList<>();
        backTrack(used, k, new LinkedList<>(), res);
        return res;
    }
    
    private void backTrack(boolean[] used, int k, LinkedList<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new LinkedList<>(cur));
            return;
        }
        int i = 1;
        if (!cur.isEmpty()) {
            i = cur.getLast() + 1;
        }
        for (; i < used.length; i++) {
            if (!used[i]) {
                cur.add(i);
                used[i] = true;
                backTrack(used, k, cur, res);
                cur.removeLast();
                used[i] = false;
            }
        }
    }
}

// Soluiton 2:

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backTrack(1, n, k, new LinkedList<>(), res);
        return res;
    }

    private void backTrack(int start, int n, int k, LinkedList<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new LinkedList<>(cur));
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            backTrack(i+1, n, k, cur, res);
            cur.removeLast();
        }
    }
}
