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
    bool isValidBST(TreeNode* root) {
       int min, max;
       if(!root) return true;
       return isValid(root, min, max);
    }
    
    bool isValid(TreeNode* root, int& min, int& max) {
        int newMin, newMax;
        min=root->val;
        max=root->val;
        if(root->left) {
            bool left=isValid(root->left, newMin, newMax);
            if(!left || root->val<=newMax) return false;
            min=std::min(min, newMin);
            max=std::max(max, newMax);
        }
        if(root->right) {
            bool right=isValid(root->right, newMin, newMax);
            if(!right || root->val>=newMin) return false;
            min=std::min(min, newMin);
            max=std::max(max, newMax);
        }
        return true;
    }
};
