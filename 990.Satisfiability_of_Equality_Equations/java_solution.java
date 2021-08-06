// Union Find
class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0 ; i < 26; i++) {
            parent[i] = i;
        }
        for (String equation: equations) {
            if (equation.charAt(1) == '!') continue;
            int a = equation.charAt(0) - 'a', b = equation.charAt(3) - 'a';
            int rootA = getRoot(a, parent), rootB = getRoot(b, parent);
            if (rootA != rootB) {
                parent[rootA] = rootB;
            }
        }
        for (String equation: equations) {
            if (equation.charAt(1) == '=') continue;
            int a = equation.charAt(0) - 'a', b = equation.charAt(3) - 'a';
            int rootA = getRoot(a, parent), rootB = getRoot(b, parent);
            if (rootA == rootB) return false;
        }
        return true;
    }

    private int getRoot(int i, int[] parent) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return parent[i];
    }
}
