public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> um = new HashMap<>();
      
      for(int i=0;i<words.length;i++) {
          String reverse = reverse(words[i]);
          um.put(reverse, i);
      }

      List<List<Integer>> res = new ArrayList<>();
      for(int i=0;i<words.length;i++) {
          String s = words[i];
          
          if(!s.equals("") && um.get("")!=null && isPalin(s)) {
              res.add(Arrays.asList(new Integer[]{i,um.get("")}));
              res.add(Arrays.asList(new Integer[]{um.get(""),i}));
          }
          
          if(um.get(words[i])!=null && um.get(words[i])!=i) {
              res.add(Arrays.asList(new Integer[]{i, um.get(words[i])}));
          }
          
          int n = s.length();
          for(int j=1;j<n;j++) {
              String prefix = s.substring(0, j);
              String suffix = s.substring(j);
              
              //System.out.println(prefix);
              if(isPalin(suffix) && um.get(prefix)!=null) {
                  // System.out.println("in suffix, "+s);
                  res.add(Arrays.asList(new Integer[]{i,um.get(prefix)}));
              }
              
              if(isPalin(prefix) && um.get(suffix)!=null) {
                  // System.out.println("in prefix, "+s);
                  res.add(Arrays.asList(new Integer[]{um.get(suffix),i}));
              }
          }
      }
      return res;
  }
  
  boolean isPalin(String s) {
      int i=0, j=s.length()-1;
      while(i<j) {
          if(s.charAt(i)!=s.charAt(j)) return false;
          i++;
          j--;
      }
      return true;
  }
  
  String reverse(String s) {
      StringBuilder sb = new StringBuilder();
      for(int i=s.length()-1;i>=0;i--) {
          sb.append(s.charAt(i));
      }
      return sb.toString();
  }
}
