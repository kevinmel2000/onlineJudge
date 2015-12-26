class Solution {
public:
    int divide(int dividend, int divisor) {
        if(divisor==0 || (divisor==-1 && dividend==INT_MIN)) return INT_MAX;
        bool negative = (dividend ^ divisor) >> 31;
        long long tmpDividend=dividend;
        long long tmpDivisor=divisor;
        tmpDividend = tmpDividend<0? -tmpDividend : tmpDividend;
        tmpDivisor = tmpDivisor<0? -tmpDivisor : tmpDivisor;
        
        int quotient=0;
        while(tmpDividend>=tmpDivisor){
            long long cur_quotient=1;
            long long addition=tmpDivisor;
            while(addition<<1 <= tmpDividend){
                addition<<=1ll;
                cur_quotient<<=1ll;
            }
            quotient+=cur_quotient;
            tmpDividend-=addition;
        }
        return negative? -quotient : quotient;
    }
};
