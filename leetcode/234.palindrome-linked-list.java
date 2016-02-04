/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null) {
            fast = fast.next;
            if(fast.next!=null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        
        // reverse
        ListNode pre = slow;
        ListNode cur = slow.next;
        
        while(cur!=null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        ListNode low = head;
        ListNode high = pre;
        while(high.next!=low && low!=high) {
            if(low.val!=high.val) return false;
            low=low.next;
            high=high.next;
        }
        
        if(high.next==low && low.val!=high.val) return false;
        return true;
    }
}
