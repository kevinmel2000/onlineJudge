class Solution {
public:
    void nextPermutation(vector<int> &num) {
        size_t n=num.size();
        size_t i=n-1;
        while(i>0 && num[i]<=num[i-1]) i--;
        
        if(i==0) {
            reverse(num, 0, n-1);
        } else {
            size_t mid=findGreaterEqual(num, i, n-1, num[i-1]);
            swap(num[i-1], num[mid]);
            reverse(num, i, n-1);
        }
    }
    
    size_t findGreaterEqual(vector<int>& num, size_t low, size_t high, int target) {
        int mid=(low+high+1)/2;
        while(low<high) {
            if(num[mid]>target) {
                low=mid;
            } else {
                high=mid-1;
            }
            mid=(low+high+1)/2;
        }
        return mid;
    }
    
    void reverse(vector<int> &num, size_t i, size_t j) {
        while(i<j) {
            swap(num[i], num[j]);
            i++;j--;
        }
    }
};
