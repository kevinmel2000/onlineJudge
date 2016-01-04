# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def doSerialize(root, strList):
            strList.append(str(root.val))
            if root.left:
                strList.append(",")
                doSerialize(root.left, strList)
            else:
                strList.append(",#")
            
            if root.right:
                strList.append(",")
                doSerialize(root.right, strList)
            else:
                strList.append(",#")
        
        strList = []
        if root is None: return ""
        doSerialize(root, strList)
        return ''.join(strList)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def doDeserialize(strList, cur):
            if cur>=len(strList): return None, cur+1
            if strList[cur]=="#": return None, cur+1
            
            root = TreeNode(strList[cur])
            root.left, newCur=doDeserialize(strList, cur+1)
            root.right, newCur=doDeserialize(strList, newCur)
            
            return root, newCur
                
        if len(data)==0: return None
        strList = data.split(",")
        root, cur= doDeserialize(strList, 0)
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
