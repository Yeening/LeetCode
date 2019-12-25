/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: in-order recursion
// class Solution {
//     TreeNode preNode = null;
//     TreeNode firstNode = null, secondNode = null; // Two nodes that not in order
//     public void recoverTree(TreeNode root) {
//         if(root==null) return;
//         inorderTraverse(root);
//         firstNode.val ^= secondNode.val;
//         secondNode.val ^= firstNode.val;
//         firstNode.val ^= secondNode.val;
//     }
//     private void inorderTraverse(TreeNode root){
//         if(root == null) return;
//         inorderTraverse(root.left);
//         if(preNode!=null){
//             if(firstNode==null&&preNode.val >= root.val){
//                 firstNode = preNode;
//             }
//             if(firstNode!=null&&preNode.val >= root.val){
//                 secondNode = root;
//             }
//         }
//         preNode = root;
//         inorderTraverse(root.right);
//     }
// }

//Solution2: Morris recursion, O(1) space
class Solution {
    TreeNode preNode = null;
    TreeNode firstNode = null, secondNode = null; // Two nodes that not in order
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        morrisTraverse(root);
        firstNode.val ^= secondNode.val;
        secondNode.val ^= firstNode.val;
        firstNode.val ^= secondNode.val;
    }
    private void morrisTraverse(TreeNode root){
        TreeNode morrisPre;
        TreeNode current = root;
        while(current != null){
            if(current.left==null){
                visit(current);
                current = current.right;
            }
            else{
                morrisPre = current.left;
                while(morrisPre.right!=null&&morrisPre.right!=current) 
                    morrisPre = morrisPre.right;
                if(morrisPre.right==null){
                    morrisPre.right = current;
                    current = current.left;
                }
                else if(morrisPre.right==current){
                    morrisPre.right = null;
                    visit(current);
                    current = current.right;
                }
            }
        }
        
    }
    private void visit(TreeNode root){
        if(preNode != null){
            if(firstNode==null&&preNode.val >= root.val){
                firstNode = preNode;
            }
            if(firstNode!=null&&preNode.val >= root.val){
                secondNode = root;
            }
        }
        preNode = root;
    }
}
