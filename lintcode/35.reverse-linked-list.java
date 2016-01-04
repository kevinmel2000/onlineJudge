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
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head==null) return null;
        return doReverse(head);
    }
    
    private ListNode doReverse(ListNode head) {
        if(head.next==null) {
            return head;
        }
        
        ListNode newHead = doReverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
