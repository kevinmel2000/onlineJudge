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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        TreeNode cur=root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<>();
        while(cur!=null || !stk.isEmpty()) {
            if(cur!=null) {
                stk.push(cur);
                cur=cur.left;
            } else {
                cur=stk.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res;
    }
}
