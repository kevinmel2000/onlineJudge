class Solution {
public:
    bool canJump(int A[], int n) {
        int reach=0;
        for(int i=0;i<n;i++){
            if(A[i]+i>reach) reach=A[i]+i;
            if(reach<n-1 && reach<=i) return false;
        }
        
        return true;
    }
};
