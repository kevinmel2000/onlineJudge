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
public:
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    string serialize(TreeNode *root) {
        // write your code here
        string res;
        serializeRec(root, res);
        return res;
    }

    void serializeRec(TreeNode* root, string& s){
        stringstream res;    
        if(!root) return;
        if(s.empty()){
            res << root->val;
        } else {
            res << "," << root->val;
        }
        s+=res.str();
        if(root->left==NULL){
            s+=",#";
        } else {
            serializeRec(root->left, s);
        }
        if(root->right==NULL){
            s+=",#";
        } else {
            serializeRec(root->right, s);
        }
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    TreeNode *deserialize(string data) {
        // write your code here
        TreeNode* root=NULL;
        int i=0;
        deserializeRec(data, i, root);
        return root;
    }
    
    void deserializeRec(string& a, int& i, TreeNode*& cur){
        //cout << a << endl;
        string token;
        
        if(i<a.size()){
            i=nextToken(a, i, token);
            if(token!="#"){
                cur=new TreeNode(atoi(token.c_str()));
                deserializeRec(a, i, cur->left);
                deserializeRec(a, i, cur->right);
            }
        }
        //cout << ", i=" << i << endl;
    }
    
    int nextToken(string& s, int i, string& token){
        int n=s.size();
        int start=i;
        while(i<n && s[i]!=','){
            i++;
        }
        
        token=s.substr(start, i-start);

        // cout << "token:" << token << ", i=" << i << endl;
        return i+1;
    }
};
