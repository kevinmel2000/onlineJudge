class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int n=nums.size();
        int start=0;
        int min=INT_MAX;
        int sum=0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
            while(sum>=s) {
                if(i-start+1<min) {
                    min=i-start+1;
                }
                sum-=nums[start++];
            }
        }
        return min==INT_MAX? 0: min;
    }
};
