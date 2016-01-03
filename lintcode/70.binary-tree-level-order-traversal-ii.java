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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        Collections.reverse(res);
        return res;
    }
    
    public void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> levels) {
        if(root==null) return;
        
        if(level==levels.size()) {
            levels.add(new ArrayList<Integer>());
        }
        
        levels.get(level).add(root.val);
        dfs(root.left, level+1, levels);
        dfs(root.right, level+1, levels);
    }
}
