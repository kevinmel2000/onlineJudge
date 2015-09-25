/// I didn't understand your solution. Here is explanation of my solution.
/// I counted bit in every position (0...31).
/// Let assume that every number will occur exactly three times.
/// In this case number of bits in every position will be divided by 3. How?
/// If i'th bit is "0", we can ignore it.
/// If i'th bit is "1", then in this position "1" occur exactly 3 times as the number is present in the array 3 times.
/// This will happen for every number. So number of bits of every position will be divided by 3.
/// Now add another number twice which is not in the list.
/// The new added number will increase bit count in some position.
/// In these position number of bits will not divided by 3.
/// From this observation we can identify which bit is "1" for the newly added number.
/// And we can grab the desired number
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n=nums.size();
        int single=0;
        for(int i=0;i<32;i++) {
            int count=0;
            for(int j=0;j<n;j++) {
                if(nums[j] & (1<<i)) count++;
            }
            if(count%3) single |= 1<<i;
        }
        return single;
    }
};
