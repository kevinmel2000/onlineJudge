BinaryTree* BinaryBottomUp(BinaryTree* root)
{
    doBottomUp(root);
    return root;
}
 
void doBottomUp(BinaryTree*& root)
{
    if(!root || !root->left) return;
    BinaryTree* ret=root->left;
    doBottomUp(ret);
    root->left->left=root->left;
    root->left->right=root->right;
    root->left=root->right=NULL;
    root=ret;
}
