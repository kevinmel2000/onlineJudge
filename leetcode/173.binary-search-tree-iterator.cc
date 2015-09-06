/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
public:
    BSTIterator(TreeNode *root) {
        leftMost(root);
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !stk_.empty();
    }

    /** @return the next smallest number */
    int next() {
        if(!hasNext()){
            return INT_MIN;
        }
        
        TreeNode* cur=stk_.top();
        stk_.pop();
        int ret=cur->val;
        if(cur->right){
            leftMost(cur->right);
        }
        return ret;
    }
    
    void leftMost(TreeNode *root){
        while(root){
            stk_.push(root);
            root=root->left;
        }
    }
    
private:
    stack<TreeNode*> stk_;
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
