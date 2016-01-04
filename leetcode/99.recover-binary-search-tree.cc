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
    TreeNode* first=NULL;
    TreeNode* second=NULL;
    TreeNode* pre=NULL;
    void recoverTree(TreeNode *root) {
        doRecoverTree(root);
        if(first && second){
            swap(first->val, second->val);    
        }
    }
    void doRecoverTree(TreeNode* root) {
        if(!root) return;
        doRecoverTree(root->left);
        if(pre) {
            if(root->val<pre->val){
                if(!first) first=pre;
                second=root;
            }
        }
        pre=root;
        doRecoverTree(root->right);
    }
};
