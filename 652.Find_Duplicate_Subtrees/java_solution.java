// Solution: post-order
// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-1/er-cha-shu-xi-lie-3

// time: O(Nodes^2)
// space: O(Nodes)
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

// Solution 2: using hashcode
// time: O(Nodes)
// space: O(Nodes)
class Solution {
    private Map<Integer, Integer> occurs; // {“null,4,null,”: 3, “null,4,null,2,null,”: 2, “null,4,null,2,null,3,null,4,null,”: 1, “null,4,null,2,null,1,null,4,null,2,null,3,null,4,null,”: 1}
    private List<TreeNode> duplicates; // [4, 2]
    private String SP = ",";

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        occurs = new HashMap<>();
        duplicates = new ArrayList<>();
        visit(root);
        return duplicates;
    }

    private int visit(TreeNode root) {
        if (root == null) return ("null" + SP).hashCode();
        StringBuilder sb = new StringBuilder();
        sb.append(visit(root.left));
        sb.append(root.val);
        sb.append(SP);
        sb.append(visit(root.right));
        sb.append(SP);
        int id = sb.toString().hashCode();
        if (occurs.containsKey(id) && occurs.get(id) == 1){
            duplicates.add(root);
        }
        occurs.put(id, occurs.getOrDefault(id, 0) + 1);
        return id;
    }

}
