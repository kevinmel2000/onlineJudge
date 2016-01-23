public class Solution {
    public List<List<String>> groupStrings(String[] strs) {
        Map<String, List<String>> umap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(strs);
        for(int i=0;i<strs.length;i++) {
            StringBuilder sb = new StringBuilder();
            String cur = strs[i];
            for(int j=1;j<strs[i].length();j++) {
                sb.append(String.format("%2d", (cur.charAt(j)-cur.charAt(j-1)+26)%26));
            }
            
            String key = sb.toString();
            if(!umap.containsKey(key)) {
                umap.put(key, new ArrayList<String>());
            }
            
            umap.get(key).add(cur);
        }
        for(String key : umap.keySet()) {
            res.add(umap.get(key));
        }
        return res;
    }
}
