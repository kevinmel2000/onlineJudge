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
 */
 
 
class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode *root) {
        // write your code here
        deque<TreeNode*> dq;
        vector<vector<int>> res;
        if(!root) return res;
        int countc=1, countn=0;
        dq.push_back(root);
        res.push_back(vector<int>(1, root->val));
        bool reverse=true;
        while(!dq.empty()) {
            if(countc>0) {
                TreeNode* cur=dq.front();
                dq.pop_front();
                if(cur->left) {
                    dq.push_back(cur->left);
                    countn++;
                }
                if(cur->right) {
                    dq.push_back(cur->right);
                    countn++;    
                }
                countc--;
            } else {
                vector<int> tmp;
                if(reverse) {
                    for(auto itr=dq.rbegin(); itr!=dq.rend(); itr++) {
                        tmp.push_back((*itr)->val);
                    }
                } else {
                    for(auto itr=dq.begin(); itr!=dq.end(); itr++) {
                        tmp.push_back((*itr)->val);
                    }
                }
                res.push_back(tmp);
                countc=countn;
                reverse=!reverse;
                countn=0;
            }
        }
        return res;
    }
};
