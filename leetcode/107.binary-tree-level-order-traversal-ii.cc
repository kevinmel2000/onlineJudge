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
    vector<vector<int> > levelOrderBottom(TreeNode *root) {
        deque<vector<int>> solutions;
        dfs(root, 0, solutions);
        vector<vector<int>> res;
        for(auto e : solutions) {
            res.push_back(e);
        }
        return res;
    }
    
    void dfs(TreeNode *root, int level, deque<vector<int>>& res) {
        if(!root) return;
        if(level>=res.size()) {
            res.push_front({root->val});
        } else {
            res[res.size()-1-level].push_back(root->val);
        }
        dfs(root->left, level+1, res);
        dfs(root->right, level+1, res);
    }
};
