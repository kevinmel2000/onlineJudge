public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!count.containsKey(c)) {
                count.put(c, 0);
            }
            count.put(c, count.get(c)+1);
        }
        
        boolean flag = false;
        for(Character c : count.keySet()) {
            if((count.get(c) & 1)!=0) {
                if(flag) return false;
                flag = true;
            }
        }
        return true;
    }
}
