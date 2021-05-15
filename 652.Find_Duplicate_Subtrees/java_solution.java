// Solution: post-order
// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-1/er-cha-shu-xi-lie-3
class Solution {
    private Map<String, Integer> subtree = new HashMap<>();
    private List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        visit(root);
        return res;
    }
    
    private String visit(TreeNode root) {
        if (root == null) return "#";
        String cur = visit(root.left) + "," + visit(root.right) + "," + root.val;
        subtree.put(cur, subtree.getOrDefault(cur, 0) + 1);
        if (subtree.get(cur) == 2) {
            res.add(root);
        }
        return cur;
    }
}
