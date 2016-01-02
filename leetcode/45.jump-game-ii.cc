class Solution {
public:
    int jump(int A[], int n) {
        int end=0, start=0;
        int step=0;
        while(end<n-1){
            step++;
            int reach=end;
            while(start<=end){
                if(A[start]+start>reach) reach=A[start]+start;
                start++;
            }
            end=reach;
        }
        return step;
    }
};
