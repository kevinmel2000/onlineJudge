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
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        vector<vector<int>> res;
        if(!root) return res;
        stack<TreeNode*> s[2];
        int current=0, next=1;
        s[current].push(root);
        vector<int> tmp;
        res.push_back(tmp);
        bool leftToRight=true;
        while(!s[current].empty()){
            TreeNode* cur=s[current].top();
            s[current].pop();
            res.back().push_back(cur->val);
            if(leftToRight){
                if(cur->left){
                    s[next].push(cur->left);
                }
                if(cur->right){
                    s[next].push(cur->right);
                }
            } else {
                if(cur->right){
                    s[next].push(cur->right);
                }
                if(cur->left){
                    s[next].push(cur->left);
                }
            }
            if(s[current].empty()){
                next=current;
                current=1-current;
                leftToRight=!leftToRight;
                if(!s[current].empty()) {
                    vector<int> tmp;
                    res.push_back(tmp);
                }
            }
        }
        return res;
    }
};
