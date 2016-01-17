public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        int n = buildings.length;
        
        // create edges
        List<Edge> edgeList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            Edge es = new Edge(buildings[i][0], buildings[i][2], true);
            Edge ee = new Edge(buildings[i][1], buildings[i][2], false);
            edgeList.add(es);
            edgeList.add(ee);
        }
        
        edgeList.sort(new Comparator<Edge>(){
            public int compare(Edge e1, Edge e2) {
                if(e1.time!=e2.time) {
                    return Integer.compare(e1.time, e2.time);
                }
                if(e1.isStart && e2.isStart) {
                    return Integer.compare(e2.height, e1.height);
                }
                if(!e1.isStart && !e2.isStart) {
                    return Integer.compare(e1.height, e2.height);
                }
                return e1.isStart? -1:1;
          }
        });
        
        // create skyline
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
        for(Edge e : edgeList) {
            if(e.isStart) {
                if(pq.isEmpty() || pq.peek()<e.height) {
                    res.add(new int[]{e.time, e.height});
                }
                pq.offer(e.height);
            } else { // e is end
                pq.remove(e.height);
                if(pq.isEmpty() || pq.peek()<res.get(res.size()-1)[1]){
                    res.add(new int[]{e.time, pq.isEmpty()? 0 : pq.peek()});
                }
            }
        }
        return res;
    }
    
    private class Edge {
        public Edge(int time, int height, boolean isStart) {
            this.time = time;
            this.height = height;
            this.isStart = isStart;
        }
        
        public int time;
        public boolean isStart;
        public int height;
    }
}
