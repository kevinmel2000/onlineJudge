BinaryTree* successor(BinaryTree* root, BinaryTree* node)
{
    if(!root || !node) return NULL;
   
    if(node->right){
        BinaryTree* left=node->right;
        while(left->left){
            left=left->left;
        }
        return left;
    }
   
    BinaryTree* succ=NULL;
    while(root){
        if(root==node){
            return succ;
        } else if(root->val>node->val) {
            succ=root;
            root=root->left;
        } else {
            root=root->right;
        }
    }
    return NULL;  
};
