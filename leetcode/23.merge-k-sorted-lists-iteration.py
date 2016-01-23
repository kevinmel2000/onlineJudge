# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        def merge(a, b):
            dummy = ListNode(0)
            last = dummy
            while a and b:
                if a.val<b.val:
                    last.next=a
                    a=a.next
                else:
                    last.next=b
                    b=b.next
                last=last.next
            if a:
                last.next=a
            elif b:
                last.next=b
            return dummy.next
        if not lists: return None
        l = 1
        while l<len(lists):
            j = 0
            while j+l<len(lists):
                lists[j]=merge(lists[j],lists[j+l])
                j+=2*l
            l+=l
        return lists[0]
