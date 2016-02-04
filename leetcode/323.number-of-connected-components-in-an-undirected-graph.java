public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<Integer>());
        for(int i=0;i<edges.length;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }
    
    void dfs(int cur, List<List<Integer>> adjList, boolean[] visited) {
        visited[cur]=true;
        for(Integer n : adjList.get(cur)) {
            if(!visited[n]) {
                dfs(n, adjList, visited);
            }
        }
    }
}
