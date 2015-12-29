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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) return null;
        // write your code here
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(),
                            new Comparator<ListNode>() {
                                @Override
                                public int compare(ListNode a, ListNode b) {
                                    if(a.val > b.val) {
                                        return 1;
                                    } else if(a.val==b.val) {
                                        return 0;
                                    } else {
                                        return -1;
                                    }
                                }
                            });
                            
        for(ListNode n : lists) {
            if (n!=null) {
                pq.offer(n);
            }
        }
        ListNode h = new ListNode(0);
        ListNode p = h;
        
        while(!pq.isEmpty()) {
            p.next = pq.poll();
            if (p.next.next!=null) {
                pq.offer(p.next.next);
            }
            p=p.next;
        }
        return h.next;
    }
}


