/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        
        ListNode cur = head.next;
        ListNode last = head;
        while(cur!=null && cur.next!=null) {
            ListNode tmp = cur.next;
            cur.next=cur.next.next;
            tmp.next = last.next;
            last.next = tmp;
            cur=cur.next;
            last=last.next;
        }
        return head;
    }
}
