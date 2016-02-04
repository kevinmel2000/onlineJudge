public class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        int count = n;
        for(int i=0;i<edges.length;i++) {
            int c0 = edges[i][0], c1 = edges[i][1];
            int p0 = uf.find(c0);
            int p1 = uf.find(c1);
            if(p0==p1) return false;
            uf.union(c0, c1);
            count--;
        }
        return count==1;
    }
    
    class UnionFind {
        int[] parents;
        int[] ranks;
        UnionFind(int n) {
            parents=new int[n];
            ranks=new int[n];
            for(int i=0;i<n;i++) {
                parents[i]=i;
            }
        }
        
        int find(int a) {
            if(parents[a]!=a) {
                return find(parents[a]);
            }
            return a;
        }
    
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            
            if(ranks[pa]<ranks[pb]) {
                parents[pa]=pb;
            } else {
                parents[pb]=pa;
                if(ranks[pa]==ranks[pb]) {
                    ranks[pa]++;
                }
            }
        }
    }
}
