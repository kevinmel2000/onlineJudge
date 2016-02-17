public class Solution {
    public String alienOrder(String[] words) {
        if(words.length==0) return "";
        Set<Integer>[] g = createGraph(words);
        int[] indegree = createIndegree(g);
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<26;i++) {
            if(indegree[i]==0) {
                q.offer(i);
            }
            if(indegree[i]!=-1) count++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++) {
            if(q.isEmpty()) return "";
            int top = q.poll();
            sb.append((char)('a'+top));
            for(int node : g[top]) {
                indegree[node]--;
                if(indegree[node]==0) {
                    q.offer(node);
                }
            }
        }
        return sb.toString();
    }
    
    Set<Integer>[] createGraph(String[] words) {
        Set<Integer>[] g = new Set[26];
        char[] w = words[0].toCharArray();
        for(int j=0;j<w.length;j++) {
            if(g[w[j]-'a']==null) g[w[j]-'a']=new HashSet<Integer>();
        }

        for(int i=1;i<words.length;i++) {
            char[] w1 = words[i-1].toCharArray();
            char[] w2 = words[i].toCharArray();
            boolean found = false;
            for(int j=0;j<w1.length || j<w2.length;j++) {
                if(j<w2.length && g[w2[j]-'a']==null) {
                    g[w2[j]-'a']=new HashSet<Integer>();
                }
                if(j<w1.length && j<w2.length && w1[j]!=w2[j] && !found) {
                    g[w1[j]-'a'].add(w2[j]-'a');
                    found = true;
                }
            }
        }
        return g;
    }
    
    int[] createIndegree(Set<Integer>[] g) {
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        for(int i=0;i<26;i++) {
            if(g[i]!=null) {
                if(indegree[i]==-1) indegree[i]=0;
                for(int n : g[i]) {
                    if(indegree[n]==-1) indegree[n]=0;
                    indegree[n]++;
                }
            }
        }
        return indegree;
    }
}
