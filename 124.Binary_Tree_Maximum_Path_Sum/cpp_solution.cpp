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


/**
 * Solution 2: Dynamic Programming, using the TreeNode.val to store the dp value
 */
class Solution {
public:
    int maxPathSum(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int maxSum = root->val;
        // Stores the max incomplete PathSum 
        // that passes the node, or 0, whichever is bigger,
        // in the TreeNode.val
        visit(root, maxSum);
        return maxSum;
    }

    /**
     * Returns the maxPathSum that passes the node, 
     * and is incomplete.
     */
    void visit(TreeNode* root, int& maxSum) {
        if (root == nullptr) {
            return;
        }
        if (root->left) {
            visit(root->left, maxSum);
        }
        if (root->right) {
            visit(root->right, maxSum);
        }
        int left = root->left? root->left->val: 0;
        int right = root->right? root->right->val: 0;
        int curSum = root->val + left + right;
        maxSum = max(maxSum, curSum);
        root->val = max(0, root->val + max(left, right));
    }
};
