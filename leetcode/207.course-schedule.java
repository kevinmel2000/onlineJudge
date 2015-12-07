public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new List[numCourses];
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++) {
            if(edges[prerequisites[i][1]]==null) edges[prerequisites[i][1]]=new ArrayList<>();
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i]==0) q.offer(i);
        }
        
        List<Integer> res = new ArrayList<>();
        int count=0;
        while(!q.isEmpty()) {
            int e = q.poll();
            count++;
            if(edges[e]!=null) {
                for(int e1 : edges[e]) {
                    if(--indegree[e1]==0) {
                        q.offer(e1);
                    }
                }
            }
        }
        
        return coCourses;
    }
}
