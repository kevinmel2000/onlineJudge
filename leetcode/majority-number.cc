class Solution {
public:
    int majorityElement(vector<int> &num) {
        int count=1;
        int cand=num[0];
        size_t n=num.size();
        for(size_t i=1;i<n;i++) {
            if(num[i]==cand) {
                count++;
            } else {
                count--;
                if(count<0) {
                    cand=num[i];
                    count=1;
                }
            }
        }
        return cand;
    }
};
