public class Solution {
    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        Queue<Node> q = new LinkedList<>();
        int m = rooms.length;
        if(m==0) return;
        int n = rooms[0].length;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(rooms[i][j]==0) {
                    q.offer(new Node(i,j));
                }
            }
        
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        while(!q.isEmpty()) {
            Node nb = q.poll();
            for(int i=0;i<4;i++) {
                int x = nb.x+dir[i][0], y = nb.y+dir[i][1];
                if(x<m && x>=0 && y<n && y>=0 && rooms[x][y]==2147483647) {
                    rooms[x][y]=rooms[nb.x][nb.y]+1;
                    q.offer(new Node(x,y));
                }
            }
        }
    }
}
