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
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> res;
        if(!root) return res;
        
        TreeNode* pre=NULL;
        std::stack<TreeNode*> stk;
        stk.push(root);
        while(!stk.empty()) 
        {
            TreeNode* cur=stk.top();
            if(pre==NULL || pre->left==cur || pre->right==cur){
                if(cur->left) stk.push(cur->left);
                else if(cur->right) stk.push(cur->right);
            } else if(cur->left==pre){
                if(cur->right) stk.push(cur->right);
            } else {
                res.push_back(cur->val);
                stk.pop();
            }
            pre=cur;
        }
        return res;
    }
};
