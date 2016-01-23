public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<Character, Integer>(){{put('I',1); put('V',5); put('X',10); put('L',50); put('C', 100); put('D',500); put('M', 1000);}};
        int res = 0;
        for(int i=0;i<s.length();i++) {
            if(i!=0 && romanMap.get(s.charAt(i-1))<romanMap.get(s.charAt(i))) {
                res-=2*romanMap.get(s.charAt(i-1));
            }
            res+=romanMap.get(s.charAt(i));
        }
        
        return res;
    }
}
