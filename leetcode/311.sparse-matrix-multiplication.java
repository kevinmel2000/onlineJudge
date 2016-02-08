public class Solution {
    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] multiply(int[][] A, int[][] B) {
        List<Node> alist = new ArrayList<>();
        List<Node> blist = new ArrayList<>();
        
        for(int i=0;i<A.length;i++)
            for(int j=0;j<A[0].length;j++) {
                if(A[i][j]!=0) {
                    alist.add(new Node(i,j));
                }
            }
        
        for(int i=0;i<B.length;i++)
            for(int j=0;j<B[0].length;j++) {
                if(B[i][j]!=0) {
                    blist.add(new Node(i,j));
                }
            }
            
        int[][] res = new int[A.length][B[0].length];
        for(Node na : alist) {
            for(Node nb : blist) {
                if(na.y==nb.x) {
                    res[na.x][nb.y] += A[na.x][na.y]*B[nb.x][nb.y];
                }
            }
        }
        return res;
    }
}
