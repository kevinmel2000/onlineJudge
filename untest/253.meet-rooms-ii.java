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

class Edge {
        int time;
        boolean isStart;
        public Edge(int t, boolean isStart) {
                this.time=t;
                this.isStart=isStart;
        }
}

class MeetingRoomsII {
        public int minMeetingRooms(Interval[] intervals) {
                List<Edge> endList = new ArrayList<>();
                for(Interval i : intervals) {
                        endList.add(new Edge(i.start), true);
                        endList.add(new Edge(i.end), false);
                }
                
                Collections.sort(endList, new Comparator<Edge>() {
                        public int compare(Edge e1, Edge e2) {
                                if(e1.time!=e2.time) return e1.time<e2.time? -1:1;
                                if(e1.isStart && !e2.isStart) return 1;
                                if(!e1.isStart && e2.isStart) return -1;
                                return 0;
                        } 
                });
                
                int count=0;
                int maxCount=0;
                for(int i=0;i<endList.size();i++) {
                        if(endList.get(i).isStart) {
                                count++;
                                if(count>maxCount) maxCount=count;
                        } else {
                                count--;
                        }
                }
                return maxCount;
        }
}
