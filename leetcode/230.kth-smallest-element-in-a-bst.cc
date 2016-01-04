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
    int count;
    int kthSmallest(TreeNode* root, int k) {
        if(!root) return 0;
        int left=kthSmallest(root->left, k);
        if(count==k) return left;
        count++;
        if(count==k) return root->val;
        return kthSmallest(root->right, k);
    }
};
