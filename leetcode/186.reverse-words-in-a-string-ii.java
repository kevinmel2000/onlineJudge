class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
                int start = 0;
                for(int i=0;i<=s.length;i++) {
                        if(i==s.length || s[i]==' ') {
                                reverseWord(s, start, i-1);
                                start=i+1;
                        }
                }
                reverseWord(s, 0, s.length);
    }
    
    void reverseWord(char[] s, int start, int end) {
        while(start<end) {
                char tmp = s[start];
                s[start]=s[end];
                s[end]=tmp;
                start++;
                end--;
        }
    }
}
