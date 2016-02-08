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
    class End {
        int time;
        boolean isStart;
        End(int time, boolean isStart) {
            this.time=time;
            this.isStart=isStart;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        List<End> endList = new ArrayList<>();
        for(Interval itv : intervals) {
            endList.add(new End(itv.start, true));
            endList.add(new End(itv.end, false));
        }
        
        Collections.sort(endList, new Comparator<End>() {
           public int compare(End e1, End e2) {
               if(e1.time!=e2.time) {
                   return e1.time-e2.time;
               }
               if(!e1.isStart) return -1;
               else return 1;
           }
        });
        
        int count = 0;
        int maxCou        for(End e : endList) {
            if(e.isStart) {
                count++;
            } else {
                count--;
            }
            if(count>maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}
