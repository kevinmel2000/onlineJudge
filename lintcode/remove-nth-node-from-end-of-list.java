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
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode first = dummy;
        ListNode second = dummy;
        while(second.next!=null && n>0) {
            second=second.next;
            n--;
        }
        while(second.next!=null) {
            first=first.next;
            second=second.next;
        }
        if(first.next!=null) {
            first.next=first.next.next;
        }
        
        return dummy.next;
    }
}

