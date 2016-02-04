public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int start = 0;
        List<String> res = new ArrayList<>();
        while(start<n) {
            int end=start;
            int ls=0;
            for(;end<n && ls+end-start+words[end].length()<=maxWidth;end++) {
                ls+=words[end].length();
            }
            
            StringBuilder sb = new StringBuilder();
            if(start+1==end) {
                sb.append(words[start]);
                if(maxWidth-words[start].length()>0) {
                    appendSpace(maxWidth-words[start].length(), sb);
                }
            } else {
                int space, bonus;
                if(end>=n) {
                    space = 1;
                    bonus = 0;
                } else {
                    space = (maxWidth-ls)/(end-start-1);
                    bonus = (maxWidth-ls)-space*(end-start-1);
                }
                sb.append(words[start]);
                while(start+1<end) {
                    if(bonus>0) {
                        appendSpace(space+1, sb);
                        bonus--;
                    } else {
                        appendSpace(space, sb);
                    }
                    sb.append(words[++start]);
                }
                if(maxWidth-sb.length()>0) {
                    appendSpace(maxWidth-sb.length(), sb);
                }
             }
             res.add(sb.toString());
             start=end;
        }
        return res;
    }
    
    void appendSpace(int n, StringBuilder sb) {
        char[] ca = new char[n];
        Arrays.fill(ca, ' ');
        sb.append(ca);
    }
}
