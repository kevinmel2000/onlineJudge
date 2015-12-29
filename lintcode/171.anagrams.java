public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        Map<String, List<String>> keyMap = new HashMap<>();
        for(String s : strs) {
            String key = getKey(s);
            if(!keyMap.containsKey(key)) {
                keyMap.put(key, new ArrayList<String>());
            }
            keyMap.get(key).add(s);
        }
        
        List<String> res = new ArrayList<>();
        for(String s : keyMap.keySet()) {
            if(keyMap.get(s).size()>1) {
                res.addAll(keyMap.get(s));
            }
        }
        return res;
    }
    
    private String getKey(String s) {
        int[] count = new int[256];
        Arrays.fill(count, 0);
        
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)]++;
        }
        StringBuilder keysb=new StringBuilder();

        for(int i=0;i<256;i++) {
            if(count[i]!=0) {
                keysb.append((char)i).append(count[i]);
            }
        }
        return keysb.toString();
    }
}

