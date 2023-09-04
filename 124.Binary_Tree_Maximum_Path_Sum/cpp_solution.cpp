/**
 * Solution 1: Binary tree traverse
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxSum;
    int maxPathSum(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        maxSum = root->val;
        maxIncompletePathSum(root);
        return maxSum;
    }

    /**
     * Returns the maxPathSum that passes the node, 
     * and is incomplete.
     */
    int maxIncompletePathSum(TreeNode* root) {
       if (root == nullptr) {
           return 0;
       }
       int left = max(0, maxIncompletePathSum(root->left));
       int right = max(0, maxIncompletePathSum(root->right));
       int current = root->val + left + right;
       maxSum = max(maxSum, current);
       return max(left, right) + root->val;
    }
};
