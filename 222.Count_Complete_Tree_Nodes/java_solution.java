// Explaination: https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-1/wan-quan-er-cha-shu-jie-dian-shu
// Time complexity: O(logN * logN)
class Solution {
    public int countNodes(TreeNode root) {
        TreeNode left = root, right = root;
        int lLayer = 0, rLayer = 0;
        while(left != null) {
            left = left.left;
            lLayer++;
        }
        while(right != null) {
            right = right.right;
            rLayer++;
        }
        if(lLayer == rLayer) {
            // perfect binary tree
            return (int)Math.pow(2, lLayer) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
