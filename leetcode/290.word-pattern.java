public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        char[] p = pattern.toCharArray();
        if(p.length!=words.length) return false;
        Map<Character, String> smap = new HashMap<>();
        Map<String, Character> wmap = new HashMap<>();
        for(int i=0;i<p.length;i++) {
            if(!smap.containsKey(p[i])) {
                smap.put(p[i], words[i]);
            } else if(!smap.get(p[i]).equals(words[i])){
                return false;
            }
            if(!wmap.containsKey(words[i])) {
                wmap.put(words[i], p[i]);
            } else if(wmap.get(words[i])!=p[i]){
                return false;
            }
        }
        return true;
    }
}
