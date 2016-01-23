# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param headA: the first list
    # @param headB: the second list
    # @return: a ListNode
    def getIntersectionNode(self, headA, headB):
        # Write your code here
        curA,curB = headA,headB
        doneA,doneB = False,False
        while curA and curB:
            if curA==curB: return curA
            curA=curA.next
            curB=curB.next
            if not curA and not doneA:
                curA = headB
                doneA = True
            if not curB and not doneB:
                curB = headA
                doneB = True
        
        return None
