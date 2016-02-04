"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""


class Solution:
    # @param airplanes, a list of Interval
    # @return an integer
    def countOfAirplanes(self, airplanes):
        # write your code here
        class Edge:
            def __init__(self, time, isEnd):
                self.time = time
                self.isEnd = isEnd
                
        def compare(x, y):
            if x.time==y.time:
                if x.isEnd: return -1
                else:
                    return 1
            return x.time-y.time
            
        
        edgeList = []
        for airplan in airplanes:
            edgeList.append(Edge(airplan.start, False))
            edgeList.append(Edge(airplan.end, True))
            
        edgeList = sorted(edgeList, cmp=compare)
        count = 0
        maxCount = 0
        for l in edgeList:
            if l.isEnd:
                count-=1
            else:
                count+=1
            if count>maxCount: maxCount = count
        
        return maxCount
