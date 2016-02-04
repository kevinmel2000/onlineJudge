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
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> solution = new ArrayList<>();
        if(root==null) return solution;
        
        dfs(root, sb, solution);
        return solution;
    }
    
    void dfs(TreeNode root, StringBuilder sb, List<String> solution) {
        sb.append(root.val);
        if(root.left==null && root.right==null) {
            solution.add(sb.toString());
            return;
        }
        
        int size = sb.length();
        if(root.left!=null) {
            sb.append("->");
            dfs(root.left, sb, solution);
        }
        sb.setLength(size);
        if(root.right!=null) {
            sb.append("->");
            dfs(root.right, sb, solution);
        }
        sb.setLength(size);
    }
}
