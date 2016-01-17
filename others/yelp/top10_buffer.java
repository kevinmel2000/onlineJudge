/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
        public static void main (String[] args) throws java.lang.Exception
        {
                // your code goes here
                
        }
}

// input logs
// yelp/smith bla 19281323234
// only care last 10min
// refresh 5s

class KeyTime {
        String key;
        long tsMs;
        public KeyTime(String key, long tsMs) {
                this.key = key;
                this.tsMs = tsMs;
        }
}

class KeyCount {
        String key;
        int count;
        public KeyCount(String key, int count) {
                this.key = key;
                this.count = count;
        }
}

class Top10 {
        Map<String, Integer> countMap = new HashMap<>();
        Queue<KeyTime> logs = new LinkedList<>();
        
        // process each line
        public void process(String line) {
                long curMs = System.currentTimeMillis();
                String[] data = line.split(" ");
                long logMs = Long.parseLong(data[2]);
                if(curMs - logMs < 10*60*1000) {
                        logs.offer(new KeyTime(data[0], logMs));
                }
        }
        
        // compute top 10 every 5s
        public void computeTop10() {
                PriorityQueue<KeyCount> pq = new PriorityQueue<>(10, new Comparator<KeyCount>() {
                        public int compare(KeyCount kc1, KeyCount kc2) {
                                return kc1.count-kc2.count;
                        }
                });
                
                long curMs = System.currentTimeMillis();
                for(KeyTime kt : logs) {
                        if(curMs - kt.tsMs < 10*60*1000) {
                                if(!countMap.containsKey(kt.key)) {
                                        countMap.put(kt.key, 0);
                                }
                                countMap.put(kt.key, countMap.get(kt.key)+1);
                        } else {
                                logs.poll();
                        }
                }
                
                for(String k : countMap.keySet()) {
                        if(pq.size()<10) {
                                pq.offer(new KeyCount(k, countMap.get(k)));
                        } else { // ==10
                                KeyCount kc = pq.peek();
                                if(kc.count<countMap.get(k)){
                                        pq.poll();
                                        pq.offer(new KeyCount(k, countMap.get(k)));
                                }
                        }
                }
                
                // print pq
                for(KeyCount kc : pq) {
                        System.out.println(kc.key+" "+kc.count);
                }
        }
}
