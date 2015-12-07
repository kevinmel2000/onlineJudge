/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n==0) return null;
        for(int len=1;len<n;len*=2) 
            for(int j=0;j+len<n;j+=2*len) {
                lists[j]=merge(lists[j], lists[j+len]);
            }
        return lists[0];
    }
    
    ListNode merge(ListNode a, ListNode b) {
        ListNode head=new ListNode(0);
        ListNode p = head;
        while(a!=null && b!=null) {
            if(a.val<b.val) {
                p.next=a;
                a=a.next;
            } else {
                p.next=b;
                b=b.next;
            }
            p=p.next;
        }
        
        if(a!=null) {
            p.next=a;
        } else if(b!=null) {
            p.next=b;
        }
        
        return head.next;
    }
}
