public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
               Set<Integer>[] adjSet = new Set[n];
        int[] indegree = new int[n];
        for(int i=0;i<edges.length;i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            indegree[from]++;
            indegree[to]++;
            if(adjSet[from]==null) {
                adjSet[from]=new HashSet<Integer>();
            }
            if(adjSet[to]==null) {
                adjSet[to]=new HashSet<Integer>();
            }
            adjSet[from].add(to);
            adjSet[to].add(from);
        }
        
        List<Integer> q = new LinkedList<>();
        Set<Integer> nodes = new HashSet<>();
        for(int i=0;i<n;i++) {
            if(indegree[i]<=1) {
                q.add(i);
            } else {
                nodes.add(i);   
            }
        }
        
        while(!nodes.isEmpty()) {
            List<Integer> next = new LinkedList<>();
            for(int leaf : q) {
                for(Integer neighbor : adjSet[leaf]) {
                  indegree[neighbor]--;
                  if(indegree[neighbor]==1) {
                      next.add(neighbor);
                      nodes.remove(neighbor);
                  }
                }
            }
            q=next;
        }
        return q;
    }
}
