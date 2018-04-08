/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        if(!root) return res;
        vector<int> left = inorderTraversal(root->left);
        vector<int> right = inorderTraversal(root->right);
        left.push_back(root->val);
        right.insert(right.begin(),left.begin(),left.end());
        return right;
    }
};
