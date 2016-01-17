class Solution:
    # @param {string} path the original path
    # @return {string} the simplified path
    def simplifyPath(self, path):
        # Write your code here
        stack = []
        cur = []
        for i in xrange(len(path)+1):
            if i==len(path) or path[i]=='/':
                if cur:
                    cur = ''.join(cur)
                    if cur==".." and stack:
                        stack.pop()
                    elif cur!="." and cur!="..":
                        stack.append(cur)
                cur = []
            else:
                cur.append(path[i])
        
        res = []
        while stack:
            res.insert(0, stack.pop())
            res.insert(0, "/")
            
        if not res:
            res=["/"]
            
        return ''.join(res)
