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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        Deque<TreeNode> dq = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        res.add(new ArrayList<Integer>(Arrays.asList(root.val)));
        dq.offer(root);
        int countc=1, countn=0;
        boolean reverse = true;
        while(!dq.isEmpty()) {
            if(countc>0) {
                TreeNode cur = dq.pop();
                countc--;
                if(cur.left!=null) {
                    dq.offer(cur.left);
                    countn++;
                }
                if(cur.right!=null) {
                    dq.offer(cur.right);
                    countn++;
                }
            } else {
                // print next level first
                res.add(new ArrayList<Integer>());
                ArrayList<Integer> curList = res.get(res.size()-1);
                Iterator<TreeNode> iter;
                if(reverse) {
                    iter = dq.descendingIterator();
                } else {
                    iter = dq.iterator();
                }
                while(iter.hasNext()){
                    curList.add(iter.next().val);
                }
                countc=countn;
                countn=0;
                reverse=!reverse;
            }
        }
        return res;
    }
}
