"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param head: The first node of linked list.
    @param x: an integer
    @return: a ListNode 
    """
    def partition(self, head, x):
        # write your code here
        dummy = ListNode(0)
        dummy.next = head
        if not head or not head.next: return head
        last = dummy
        cur = dummy
        while cur.next:
            if cur.next.val<x:
                if last == cur:
                    cur = cur.next
                else:
                    tmp = cur.next.next
                    cur.next.next = last.next
                    last.next = cur.next;
                    cur.next = tmp
                last = last.next
            else:
                cur=cur.next
        return dummy.next
