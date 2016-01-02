/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start-i2.start;
            }
        });

        for(int i=1;i<intervals.size();i++) {
            Interval pre = intervals.get(i-1);
            Interval cur = intervals.get(i);
            
            if(pre.end>=cur.start) {
                intervals.remove(i);
                intervals.remove(i-1);
                intervals.add(i-1, new Interval(pre.start, Math.max(pre.end, cur.end)));
                i--;
            }
        }
        return intervals;
    }
}
