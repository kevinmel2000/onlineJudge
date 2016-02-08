public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] nums = new int[n];
        for(int i=0;i<n;i++) {
            for(char c : words[i].toCharArray()) {
                nums[i]|=(1<<(c-'a'));
            }
        }
        int maxLen=0;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if((nums[i]&nums[j])==0 && words[i].length()*words[j].length()>maxLen) {
                    maxLen = words[i].length()*words[j].length();
                }
            }
        }
        return maxLen;
    }
}
