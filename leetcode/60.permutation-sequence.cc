class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> num(n);
        string res;
        long fact=1;
        for(size_t i=0;i<n;i++) {
            num[i]=i+1;
            fact*=i+1;
        }
        
        int c=n;
        k--;
        for(size_t i=0;i<n;i++) {
            fact/=c;
            c--;
            size_t p=k/fact;
            res+=num[p]+'0';
            num.erase(num.begin()+p);
            k%=fact;
        }
        return res;
    }
};
