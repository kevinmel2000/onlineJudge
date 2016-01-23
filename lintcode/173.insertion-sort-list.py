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
    @return: The head of linked list.
    """ 
    def insertionSortList(self, head):
        # write your code here
        dummy = ListNode(0)
        dummy.next = head
        if not head or not head.next: return head
        cur = head
        while cur.next:
            last = dummy
            if cur.next.val<cur.val:
                while last.next.val<cur.next.val:
                    last=last.next
            
                tmp = cur.next.next
                cur.next.next = last.next
                last.next = cur.next
                cur.next = tmp
            else:
                cur=cur.next
        return dummy.next
