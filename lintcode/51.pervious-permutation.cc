class Solution {
public:
    /**
     * @param nums: An array of integers
     * @return: An array of integers that's previous permuation
     */
    vector<int> previousPermuation(vector<int> &nums) {
        // write your code here
        int n=nums.size();
        int i=n-1;
        while(i>0 && nums[i]>=nums[i-1]) i--;
        
        if(i==0) {
            reverse(nums, 0);
        } else {
            int p=binaryLess(nums, i, n-1, nums[i-1]);
            swap(nums[p], nums[i-1]);
            reverse(nums, i);
        }
        return nums;
    }
    
    int binaryLess(vector<int> &nums, int low, int high, int target) {
        int mid=(low+high+1)/2;
        while(low<high) {
            if(nums[mid]<target) {
                low=mid;
            } else {
                high=mid-1;
            }
            mid=(low+high+1)/2;
        }
        return mid;
    }
    
    void reverse(vector<int> &nums, int i) {
        int n=nums.size();
        while(i<n) {
            swap(nums[i], nums[n-1]);
            i++;n--;
        }
    }
};
