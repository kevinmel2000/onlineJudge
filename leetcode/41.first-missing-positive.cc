class Solution {
public:
    int firstMissingPositive(vector<int>& A) {
        int n=A.size();
        for(int i=0;i<n;i++) {
            while((A[i]>0 && A[i]<=n) && A[A[i]-1]!=A[i]) {
                swap(A[A[i]-1], A[i]);
            }
        }
        for(int i=0;i<n;i++) {
            if(i+1!=A[i]) return i+1;
        }
        return n+1;
    }
};
