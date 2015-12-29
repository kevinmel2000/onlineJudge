/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        int[] parents=new int[m*n];
        Arrays.fill(parents, -1);
        int[] ranks=new int[m*n];
        Arrays.fill(ranks, 0);
        Point[] direction={new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
        List<Integer> res=new ArrayList();
        if(operators==null) return res;
       
        int count=0;
        for(int i=0;i<operators.length;i++) {
            int x=operators[i].x;
            int y=operators[i].y;
            parents[x*m+y]=x*m+y;
            Set<Integer> neighbors=new HashSet<Integer>();
            for(int j=0;j<4;j++) {
                int nx=direction[j].x+x;
                int ny=direction[j].y+y;
                if(nx>=0 && ny>=0 && nx<n && ny<m && parents[nx*m+ny]!=-1) {
                    neighbors.add(find(parents, nx*m+ny));
                }
            }
            count+=1-neighbors.size();
            res.add(count);
 
            // union
            for(int j=0;j<4;j++) {
                int nx=direction[j].x+x;
                int ny=direction[j].y+y;
                if(nx>=0 && ny>=0 && nx<n && ny<m && parents[nx*m+ny]!=-1) {
                    unionSet(parents, ranks, x*m+y, nx*m+ny);
                }
            }
        }
        return res;
    }
   
    private int find(int[] parents, int e) {
        if(e!=parents[e]) {
            parents[e]=find(parents, parents[e]);
        }
        return parents[e];
    }
 
    private void unionSet(int[] parents, int[] ranks, int i, int j) {
        int x=find(parents, i);
        int y=find(parents, j);
        if(x==y) return;
       
        if(ranks[x]>ranks[y]) {
            parents[y]=x;
        } else {
            parents[x]=y;
            if(ranks[x]==ranks[y])
                ranks[x]++;
        }
    }
}
