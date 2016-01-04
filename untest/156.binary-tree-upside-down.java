public TreeNode upsideDownBinaryTree(TreeNode root) {
    if(root==null) return null;
    return doUpsideDown(root);
}
 
private TreeNode doUpsideDown(TreeNode root) {
    if(root.left==null) {
        return root;
    }
    TreeNode newRoot = doUpsideDown(root.left);
    root.left.right=root;
    root.left.left=root.right;
    root.left=root.right=null;
    return newRoot;
}
