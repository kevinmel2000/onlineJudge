public class Solution {
    Map<String, TreeMap<String, Integer>> um = new HashMap<>();
    public List<String> findItinerary(String[][] tickets) {
        
        List<String> res = new ArrayList<>();
        
        for(int i=0;i<tickets.length;i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            if(um.get(from)==null) um.put(from, new TreeMap<String, Integer>());
            if(um.get(from).get(to)==null) um.get(from).put(to, 0);
            um.get(from).put(to, um.get(from).get(to)+1);
        }
        
        res.add("JFK");
        dfs("JFK", res, tickets.length+1);
        return res;
    }
    
    boolean dfs(String cur, List<String> res, int n) {
        if(res.size()==n) return true;
        
        Map<String, Integer> tos = um.get(cur);
        if(tos==null) return false;
        for(String to : tos.keySet()) {
            if(tos.get(to)!=0) {
                res.add(to);
                tos.put(to, tos.get(to)-1);
                if(dfs( n)) return true;
                tos.put(to, tos.get(to)+1);
                res.remove(res.size()-1);
            }
        }
        return false;
    }
}
