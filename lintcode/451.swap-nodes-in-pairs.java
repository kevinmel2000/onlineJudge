/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null && cur.next!=null) {
            // link outside first: pre, cur.next
            pre.next=cur.next;
            ListNode next=cur.next;
            cur.next=next.next;
            // internal swap
            next.next=cur;
            // move to next pair
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}
