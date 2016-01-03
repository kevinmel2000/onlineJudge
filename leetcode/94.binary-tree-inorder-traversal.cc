/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> res;
        if(!root) return res;
        std::stack<TreeNode*> stk;
        TreeNode* cur=root;
        while(!stk.empty() || cur){
            if(cur){
                stk.push(cur);
                cur=cur->left;
            } else {
                cur=stk.top();
                stk.pop();
                res.push_back(cur->val);
                cur=cur->right;
            }
        }
        return res;
    }
};
