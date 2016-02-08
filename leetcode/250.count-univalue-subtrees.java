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
    int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        doCount(root);
        return count;
    }
    
    public boolean doCount(TreeNode root) {
        if(root.left==null && root.right==null) {
            count++;
            return true;
        }
        boolean unique = true;
        if(root.left!=null) {
            unique = doCount(root.left) && root.left.val==root.val;
        }
        
        if(root.right!=null) {
            unique = doCount(root.right) && root.right.val==root.val && unique;
        }
    
        if(unique) count++;
        return unique;
    }
}
