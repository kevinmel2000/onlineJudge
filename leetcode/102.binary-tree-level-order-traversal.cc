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
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int>> res;
        if(!root) return res;
    
        std::queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        vector<int> curLevel;
        while(!q.empty()){
            TreeNode* cur=q.front();
            q.pop();
            if(cur==NULL){
                res.push_back(curLevel);
                curLevel.clear();
                if(!q.empty()) q.push(NULL);
                continue;
            }
            curLevel.push_back(cur->val);
            if(cur->left) q.push(cur->left);
            if(cur->right) q.push(cur->right);
        }
        return res;
    }
};
