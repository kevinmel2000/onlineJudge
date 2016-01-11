// Write a method to count the number of 2s between 0 and n - martin_liang的专栏 - 博客频道 - CSDN.NET
// http://blog.csdn.net/martin_liang/article/details/18628061
class Solution {
public:
    int countDigitOne(int n) {
        unsigned count=0;
        long long base=1;
        while(n/base>0) {
            int lowbits=n%base;
            int highbits=n/(base*10);
            int curbits=n/base%10;
            if(curbits<1) {
                count+=highbits*base;
            } else if(curbits==1) {
                count+=highbits*base+lowbits+1;
            } else {
                count+=(highbits+1)*base;
            }
            base*=10;
        }
        return count;
    }
};
