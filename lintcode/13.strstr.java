class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source==null || target==null) return -1;
        int ns = source.length();
        int nt = target.length();
        if(ns<nt) return -1;
        
        long hash=0;
        for(int i=0;i<nt;i++) {
            hash=256*hash+target.charAt(i);
        }
        
        long cur=0;
        long base=1;
        int start=0;
        for(int i=0;i<nt;i++) {
            cur=256*cur+source.charAt(i);
            base*=256;
        }
        if(cur==hash) return start; 
        
        base/=256;
        for(int i=nt;i<ns;i++) {
            start++;
            if(base!=0) // deal with long overflow  
                cur%=base;
            cur=cur*25.charAt(i);
            if(cur==hash) return start;
        }
        
        return -1;
    }
}
