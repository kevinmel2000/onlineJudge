/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        int high = getSize(head);
        h=head;
        TreeNode root = doSorted(0, high-1);
        return root;
    }
    
    private int getSize(ListNode head) {
        int s = 0;
        while(head!=null) {
            s++;
            head=head.next;
        }
        return s;
    }
    
    private static ListNode h;
    
    private TreeNode doSorted(int low, int high) {
        if(high<low) return null;
        int mid = low + (high-low)/2;
        TreeNode left = doSorted(low, mid-1);
        TreeNode root = new TreeNode(h.val);
        h=h.next;
        TreeNode right = doSorted(mid+1, high);
        root.left=left;
        root.right=right;
        return root;
    }
}
