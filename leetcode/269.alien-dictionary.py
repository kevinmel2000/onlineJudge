class Solution(object):
    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        def createGraph(words):
            g = {}
            for c in words[0]:
                if c not in g:
                    g[c]=[]
            for i in range(1, len(words)):
                w1 = words[i-1]
                w2 = words[i]
                found = False
                j=0
                while j<len(w2) or j<len(w1):
                    if j<len(w2) and w2[j] not in g:
                        g[w2[j]]=[]
                    if j<len(w2) and j<len(w1) and w1[j]!=w2[j] and not found:
                        g[w1[j]].append(w2[j])
                        found = True
                    j+=1
            return g
        def createIndegree(g):
            indegree = {}
            for i in g:
                if i not in indegree:
                    indegree[i]=0
                for n in g[i]:
                    if n not in indegree:
                        indegree[n]=0
                    indegree[n]+=1
            return indegree
            
        g = createGraph(words)
        indegree = createIndegree(g)
        from collections import deque
        q = deque([])
        for i in indegree:
            if indegree[i]==0:
                q.append(i)
        
        res = []
        for i in range(len(indegree)):
            if not q: return ""
            top = q.popleft()
            res.append(top)
            for c in g[top]:
                indegree[c]-=1
                if indegree[c]==0:
                    q.append(c)
        return ''.join(res)
