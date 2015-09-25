class Solution {
public:
    bool isHappy(int n) {
        unordered_set<long long> uset;
        long long res=n;
        // check-insert-change pattern for two occurences
        while(uset.find(res)==uset.end()) {
            uset.insert(res);
            res=square(res);
            if(res==1) return true;
        }
        return false;
    }
    
    long long square(long long n) {
        long long base=1;
        long long res=0;
        while(n/base>0) {
            int digit=n/base%10;
            res+=digit*digit;
            base*=10;
        }
        return res;
    }
};
