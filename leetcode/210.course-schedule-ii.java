public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adjList.add(new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[numCourses];
        Set<Integer> curRec = new HashSet<>();
        Stack<Integer> resStk = new Stack<>();
        int[] res = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            if(!visited[i]) {
                if(!dfs(i, adjList, visited, curRec, resStk)) {
                    return new int[0];
                }
            }
        }

        for(int i=numCourses-1;i>=0;i--) {
            res[i]=resStk.pop();
        }
        return res;
    }
    
    boolean dfs(int cur, List<List<Integer>> adjList, boolean[] visited, Set<Integer> curRec, Stack<Integer> resStk) {
        visited[cur        curRec.add(cur);
        for(Integer n : adjList.get(cur)) {
            if(curRec.contains(n)) {
                return false;
            } else if(!visited[n]) {
                if(!dfs(n, adjList, visited, curRec, resStk)){
                    return false;
                }
            }
        }
        resStk.push(cur);
        curRec.remove(cur);
        return true;
    }
}
