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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null) {
            int kk=k;
            ListNode tail = cur;
            while(tail!=null && kk>0) {
                kk--;
                tail=tail.next;
            }

            if(kk==0) {
                ListNode nh = reverse(cur, tail); 
                pre.next=nh;
            }
            pre=cur;
            cur=tail;
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=tail) {
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        head.next=tail;
        return pre;
    }
}
