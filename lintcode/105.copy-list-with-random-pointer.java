/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head==null) return null;
        
        RandomListNode cur = head;
        while(cur!=null) {
            RandomListNode n = new RandomListNode(cur.label);
            n.next=cur.next;
            cur.next=n;
            cur=n.next;
        }
        
        cur = head;
        while(cur!=null) {
            if(cur.random!=null) {
                cur.next.random = cur.random.next;    
            }
            cur=cur.next.next;
        }

        cur = head;
        RandomListNode newHead = cur.next;
        while(cur!=null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            if(next.next!=null) {
                next.next = next.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }
}
