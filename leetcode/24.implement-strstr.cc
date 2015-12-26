class Solution {
public:
    int strStr(string haystack, string needle) {
        size_t nh=haystack.size();
        size_t nn=needle.size();
        if(nh<nn) return -1;

        for(size_t i=0;i<nh-nn+1;i++) {
            size_t j;
            for(j=i;j<i+nn;j++){
                if(needle[j-i]!=haystack[j]) {
                    break;
                }
            }
            if(j==i+nn) {
                return i;
            }
        }
        return -1;
    }
};
