/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution 1
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new LinkedList<>();
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode cur = root;
//         while(!stack.isEmpty()||cur!=null){
//             cur = stack.pop();
//             res.add(cur.val);
//             if(cur.right!=null) stack.push(cur.right);
//             if(cur.left!=null) stack.push(cur.left);
//         }
//         return res;
//     }
// }
//Solution2, similiar to in-order traversal
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}
