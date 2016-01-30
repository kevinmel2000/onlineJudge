/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right!=null) {
            p = p.right;
            while(p.left!=null) {
                p=p.left;
            }
            return p;
        } else {
            TreeNode pre = null;
            while(root!=null) {
                if(root.left==p) {
                    return root;
                } else if(root.right==p) {
                    return pre;
                }
                
                if(root.val<=p.val) {
                    // don't update pre on right path
                    root = root.right;
                } else {
                    pre = root;
                    root = root.left;
                }
            }
        }
        return null;
    }
}
