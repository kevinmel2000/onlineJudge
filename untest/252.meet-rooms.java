/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
        public static void main (String[] args) throws java.lang.Exception
        {
                // your code goes here
        }
}

class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
                Arrays.sort(intervals, new Comparator<Interval>() {
                        public int compare(Interval i1, Interval i2) {
                                if(i1.start!=i2.start) return i1.start<i2.start;
                                else if(i2.end!=i1.end) return i1.end<i2.end;
                                return 0;
                        }
                });
                
                // if(intervals.length<=1) return true;
                
                for(int i=1;i<intervals.length;i++) {
                        if(intervals[i-1].end>intervals[i].start) {
                                return false;
                        }
                }
                return true;
    }
}
