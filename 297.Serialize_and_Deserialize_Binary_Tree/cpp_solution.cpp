/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        stringstream out;
        m_serialize(root,out);
        return out.str();
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stringstream in(data);
        return m_deserialize(in);
    }
private:
    void m_serialize(TreeNode* root, stringstream& out){
        if(!root){
            out<<"# ";
        }
        else{
            out<<root->val<<" ";
            m_serialize(root->left,out);
            m_serialize(root->right,out);
        }
    }
    TreeNode* m_deserialize(stringstream& in){
        TreeNode* res;
        string val;
        in>>val;
        if(val=="#"){
            return NULL;
        }
        res = new TreeNode(stoi(val));
        res->left = m_deserialize(in);
        res->right = m_deserialize(in);
        return res;
        
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));
