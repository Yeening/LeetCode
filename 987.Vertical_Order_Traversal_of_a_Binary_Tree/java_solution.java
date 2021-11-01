/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<TreeNode>> cols = new HashMap<>();
        Map<TreeNode, Integer> nodeCol = new HashMap<>();
        Map<TreeNode, Integer> nodeRow = new HashMap<>();
        nodeCol.put(root, 0);
        nodeRow.put(root, 0);
        visit(root, nodeCol, nodeRow, cols);
        int minCol = Integer.MAX_VALUE, maxCol = Integer.MIN_VALUE;
        for (int col: cols.keySet()) {
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
        }
        for (int col = minCol; col <= maxCol; col++) {
            List<TreeNode> nodes = cols.get(col);
            res.add(nodes.stream()
                .sorted((a,b)->compare(a,b,nodeCol,nodeRow))
                .mapToInt(a->a.val)
                .boxed()
                .collect(Collectors.toList()));
        }
        return res;
    }
    
    private void visit(TreeNode root, 
            Map<TreeNode, Integer> nodeCol, Map<TreeNode, Integer> nodeRow, 
                      Map<Integer, List<TreeNode>> cols) {
        if (root == null) {return;}
        int col = nodeCol.get(root), row = nodeRow.get(root);
        cols.putIfAbsent(col, new ArrayList<>());
        cols.get(col).add(root);
        if (root.left != null) {
            nodeCol.put(root.left, col - 1);
            nodeRow.put(root.left, row + 1);
            visit(root.left, nodeCol, nodeRow, cols);
        }
        
        if (root.right != null) {
            nodeCol.put(root.right, col + 1);
            nodeRow.put(root.right, row + 1);
            visit(root.right, nodeCol, nodeRow, cols);
        }
    }
    
    private int compare(TreeNode a, TreeNode b, 
            Map<TreeNode, Integer> nodeCol, Map<TreeNode, Integer> nodeRow) {
        int colA = nodeCol.get(a), colB = nodeCol.get(b);
        if (colA != colB) {return colA - colB;}
        int rowA = nodeRow.get(a), rowB = nodeRow.get(b);
        if (rowA != rowB) {return rowA - rowB;}
        return a.val - b.val;
    }
}
