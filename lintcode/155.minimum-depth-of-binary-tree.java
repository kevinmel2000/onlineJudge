/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;
        dfs(root, 1);
        return min;
    }
    
    int min = Integer.MAX_VALUE;
    void dfs(TreeNode root, int h) {
        if(root.left==null && root.right==null) {
            if(min>h) {
                min = h;
            }
            return;
        }
        
        if(root.left!=null) {
            dfs(root.left, h+1);
        }
        
        if(root.right!=null) {
            dfs(root.right, h+1);
        }
    }
}
