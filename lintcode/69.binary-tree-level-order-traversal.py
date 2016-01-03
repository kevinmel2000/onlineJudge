"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""


class Solution:
    """
    @param root: The root of binary tree.
    @return: Level order in a list of lists of integers
    """
    def levelOrder(self, root):
        from collections import deque
        # write your code here
        q = deque([])
        res = []
        if not root: return res
        q.append(root)
        curr,next = 1,0
        curLevel = []
        while q:
            cur = q.popleft()
            curLevel.append(cur.val)
            
            if cur.left:
                q.append(cur.left)
                next+=1
            if cur.right:
                q.append(cur.right)
                next+=1

            curr-=1
            if curr==0:
                res.append(curLevel)
                curLevel=[]
                curr,next=next,0
        return res
