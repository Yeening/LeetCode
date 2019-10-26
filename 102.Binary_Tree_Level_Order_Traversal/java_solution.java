/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        ArrayList<TreeNode> current_level = new ArrayList<>();
        current_level.add(root);
        while(!current_level.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            ArrayList<TreeNode> next_level = new ArrayList<>();
            for(TreeNode node: current_level){
                if(node.left!=null) next_level.add(node.left);
                if(node.right!=null) next_level.add(node.right);
                cur.add(node.val);
            }
            res.add(cur);
            current_level = next_level;
        }
        return res;
    }
}
