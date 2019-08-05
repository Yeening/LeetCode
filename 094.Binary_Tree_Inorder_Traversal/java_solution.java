/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursive solution
// class Solution {
//     List<Integer> res = new LinkedList<>();
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root!=null) inorder(root);
//         return res;
//     }
//     private void inorder(TreeNode node){
//         if(node.left != null) inorder(node.left);
//         res.add(node.val);
//         if(node.right != null) inorder(node.right);
//     }
// }

//Iteractive solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
