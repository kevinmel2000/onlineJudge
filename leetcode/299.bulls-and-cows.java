public class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bulls=0, cows=0;
        int[] has = new int[10];
        for(int i=0;i<n;i++) {
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if(g==s) {
                bulls++;
                continue;
            }

            if(has[s-'0']<0) {
                cows++;
            }
            has[s-'0']++;
            
            if(has[g-'0']>0) {
                cows++;
            }
            has[g-'0']--;
        }
        
        return bulls+"A"+cows+"B";
    }
}
