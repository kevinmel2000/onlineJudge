# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param l1: the first list
    # @param l2: the second list
    # @return: the sum list of l1 and l2 
    def addLists(self, l1, l2):
        # write your code here
        head = ListNode(0);
        p = head
        carry = 0
        while l1 is not None or l2 is not None:
            total = carry
            if l1 is not None:
                total+=l1.val
                l1=l1.next
                
            if l2 is not None:
                total+=l2.val
                l2=l2.next
            
            digit = total%10
            carry = total/10
            p.next = ListNode(digit)
            p=p.next
        
        if carry!=0:
            p.next = ListNode(carry)
            
        return head.next
