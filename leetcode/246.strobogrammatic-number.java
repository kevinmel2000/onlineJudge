public class Solution {
    public boolean isStrobogrammatic(String num) {
        int i=0,j=num.length()-1;
        char[] a = num.toCharArray();
        while(i<j) {
            if(a[i]=='6' && a[j]=='9' || (a[i]=='9' && a[j]=='6')) {
                i++;j--;
                continue;
            }

            if((a[i]=='8' || a[i]=='1' || a[i]=='0') && a[i]==a[j]) {
                i++;j--;
                continue;
            }
            return false;
        }
        
        if(i==j) return a[i]=='8' || a[i]=='1' || a[i]=='0'; 
        
        return true;
    }
}
