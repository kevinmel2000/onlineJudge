class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int extra=nums[0];
        for(int i=1;i<nums.size();i++) {
            extra^=nums[i];
        }
        return extra;
    }
};
