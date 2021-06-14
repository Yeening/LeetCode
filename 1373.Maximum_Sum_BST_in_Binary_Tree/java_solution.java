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

// Post-order traverse
// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-1/hou-xu-bian-li
class Solution {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        sumBST(root);
        return maxSum;
    }

    private int[] sumBST(TreeNode root) {
        // minVal, maxVal, sum
        // null: not BST
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = sumBST(root.left);
        int[] right = sumBST(root.right);
        if (left == null ||
                right == null ||
                left[1] >= root.val ||
                right[0] <= root.val) {
            return null;
        }
        int sum = left[2] + right[2] + root.val;
        maxSum = Math.max(maxSum, sum);
        int min = root.left == null ? root.val : left[0];
        int max = root.right == null ? root.val : right[1];
        return new int[]{min, max, sum};
    }
}
