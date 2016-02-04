/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b) {
               return a.start-b.start;
           } 
        });

        for(int i=1;i<intervals.length;i++) {
            Interval pre = intervals[i-1];
            Interval cur = intervals[i];
            if(pre.end>cur.start) return false;
        }
        return true;
    }
}
