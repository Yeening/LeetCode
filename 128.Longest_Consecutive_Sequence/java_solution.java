// Union Find
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> parent = new HashMap<>();
        int res = 0;
        for (int i: nums) {
            parent.putIfAbsent(i, i);
        }
        for (int i: parent.keySet()) {
            if (parent.containsKey(i + 1)) {
                int root1 = getRoot(i, parent), root2 = getRoot(i + 1, parent);
                if (root1 != root2) {
                    if (root1 > root2) {
                        int temp = root1;
                        root1 = root2;
                        root2 = temp;
                    }
                    parent.put(root2, root1);
                }
            }
        }
        for (int i: parent.keySet()) {
            int root = getRoot(i, parent);
            res = Math.max(res, i - root + 1);
        }
        return res;
    }

    private int getRoot(int i, Map<Integer, Integer> parent) {
        while (parent.get(i) != i) {
            parent.put(i, parent.get(parent.get(i)));
            i = parent.get(i);
        }
        return i;
    }
}
