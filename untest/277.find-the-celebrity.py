# your code goes here
class Solution(object):
    def findCelebrity(self, n):
        cand = 0
        for i in range(1, n):
                if knows(cand, i) or not knows(i,cand):
                        cand = i
        
        for i in range(n):
                if i==cand: continue
                if knows(cand, i) or not knows(i, cand):
                        return -1
        return cand
