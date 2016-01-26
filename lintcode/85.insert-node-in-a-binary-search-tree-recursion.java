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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root==null) return node;
        insertNodeRec(root, node);
        return root;
    }
    
    void insertNodeRec(TreeNode root, TreeNode node) {
        if(root.val>=node.val) {
            if(root.left==null) {
                root.left=node;
            } else {
                insertNodeRec(root.left, node);
            }
        } else {
            if(root.right==null) {
                root.right=node;
            } else {
                insertNodeRec(root.right, node);
            }
        }
    }
}
