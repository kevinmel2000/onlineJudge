public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1=-1, idx2=-1;
        int shortest = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++) {
            if(words[i].equals(word1)) {
                if(idx2!=-1 && i-idx2<shortest) {
                    shortest = i-idx2;
                }
                if(idx1!=-1 && word1.equals(word2) && i-idx1<shortest) {
                    shortest = i-idx1;
                }
                idx1=i;
            } else if(words[i].equals(word2)) {
                if(idx1!=-1 && i-idx1<shortest) {
                    shortest = i-idx1;
                }
                idx2=i;
            }
        }
        return shortest;
    }
}
