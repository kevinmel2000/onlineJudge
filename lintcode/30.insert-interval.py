"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""


class Solution:
    """
    Insert a new interval into a sorted non-overlapping interval list.
    @param intevals: Sorted non-overlapping interval list
    @param newInterval: The new interval.
    @return: A new sorted non-overlapping interval list with the new interval.
    """
    def insert(self, intervals, newInterval):
        # write your code here
        results = []
        
        for i in range(len(intervals)):
            if newInterval.end < intervals[i].start:
                results.append(newInterval)
                results+=intervals[i:]
                return results
            elif start > intervals[i].end:
                results.append(intervals[i])
            else:
                newInterval.start=min(intervals[i].start, newInterval.start)
                newInterval.end=max(intervals[i].end, newInterval.end)
        
        resuld(newInterval)
        return results
