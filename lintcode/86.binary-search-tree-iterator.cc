/**
 * Definition of TreeNode:
 * class TreeNode {
 * public:
 *     int val;
 *     TreeNode *left, *right;
 *     TreeNode(int val) {
 *         this->val = val;
 *         this->left = this->right = NULL;
 *     }
 * }
 * Example of iterate a tree:
 * Solution iterator = Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode * node = iterator.next();
 *    do something for node
 */
class Solution {
public:
    //@param root: The root of binary tree.
    Solution(TreeNode *root) {
        // write your code here
        insertTemp(root);
    }

    //@return: True if there has next node, or false
    bool hasNext() {
        // write your code here
        return !stk.empty();
    }
    
    //@return: return next node
    TreeNode* next() {
        // write your code here
        if(!hasNext()) return NULL;
        
        TreeNode* ret=stk.top();
        stk.pop();
        insertTemp(ret->right);
        return ret;
    }
private:
    stack<TreeNode*> stk;
    void insertTemp(TreeNode* root){
        while(root) {
            stk.push(root);
            root=root->left;
        }
    }
};
