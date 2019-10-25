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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode root1, TreeNode root2){
        if(root1==null||root2==null) return root1==root2;
        return(root1.val==root2.val&&isMirror(root1.left,root2.right)
               &&isMirror(root1.right,root2.left));
    }
}
// //Solution2
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root==null) return true;
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root.left);
//         stack.push(root.right);
//         while(!stack.isEmpty()){
//             TreeNode n1 = stack.pop(), n2 = stack.pop();
//             if(n1==null&&n2==null) continue;
//             if(n1==null||n2==null||n1.val!=n2.val) return false;
//             stack.push(n1.left);
//             stack.push(n2.right);
//             stack.push(n1.right);
//             stack.push(n2.left);
//         }
//         return true;
//     }
// }
