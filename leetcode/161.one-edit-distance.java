public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int ns = s.length(), nt = t.length();
        if(Math.abs(ns-nt)>1) return false;
        
        int i=0,j=0;
        int err = 0;
        while(i<ns && j<nt) {
            if(s.charAt(i)!=t.charAt(j)) {
                err++;
                if(err>1) return false;
                if(ns>nt) {
                    j--;
                } else if(ns<nt) {
                    i--;
                }
            }
            i++;j++;
        }
        return (err==1 || (err==0 && ns!=nt))? true:false;
    }
}
