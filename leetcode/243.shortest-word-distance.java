public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        String cur=null;
        int curPos=-1;
        int min = words.length;
        for(int i=0;i<words.length;i++) {
            if(words[i].equals(word1) || words[i].equals(word2)) {
                if(cur!=null && !words[i].equals(cur)) {
                    if(min>i-curPos) {
                        min = i-curPos;
                    }
                }
                curPos = i;
                cur=words[i];
            }
        }
        return min;
    }
}
