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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        TreeNode pre=null;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()) {
            TreeNode cur = stk.peek();
            if(pre==null || cur==pre.left || cur==pre.right) {
                if(cur.left!=null) {
                    stk.push(cur.left);
                } else if(cur.right!=null) {
                    stk.push(cur.right);
                }
            } else if(cur.left
                if(cur.right!=null) {
                    stk.push(cur.right);
                }
            } else {
                res.add(stk.pop().val);
            }
            pre=cur;
        }
        return res;
    }
}
