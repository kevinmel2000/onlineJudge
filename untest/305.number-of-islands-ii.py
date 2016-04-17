class Solution(object):
    def numIslands2(self, m, n, positions):
        
        parents = [-1 for i in range(m*n)]
        ranks = [0 for i in range(m*n)]
        res = []
        
        for i in range(len(positions)):
            dir = [[0,1],[1,0],[-1,0],[0,-1]]
            x = positions[i].x
            y = positions[i].y
            count = 0
            cset = set()
            for j in dir:
                x1=x+dir[j][0]
                y1=y+dir[j][1]
                if x1<m and x1>=0 and y1<n and y1>=0 and parents[x1*n+y1]!=-1:
                    cset.add(parents[x1*n+y1])
                    
            count+=1-len(cset)
            res.append(count)
            for j in dir:
                x1=x+dir[j][0]
                y1=y+dir[j][1]
                if x1<m and x1>=0 and y1<n and y1>=0 and parents[x1*n+y1]!=-1:
                    union(parents, ranks, x*n+y, x1*n+y1)
        return res
        
        def find(parents, e):
            if e!=parents[e]:
                parents[e] = find(parents, parents[e])
            
            return parents[e]
        
        def union(parents, ranks, x, y):
            px = find(parents, x)
            py = find(parents, y)
            
            if px==py: return
            if ranks(px)<ranks(py):
                parents[px]=py
            else:
                parents[py]=px
                if ranks[px]==ranks[py]:
                    ranks[px]+=1
