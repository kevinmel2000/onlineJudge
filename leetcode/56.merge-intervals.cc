/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    static bool cmp(const Interval& a, const Interval& b){
        if(a.start<b.start){
            return true;
        } else if(a.start==b.start && a.end<b.end){
            return true;
        }
        return false;
    };
    vector<Interval> merge(vector<Interval> &intervals) {
        std::sort(intervals.begin(), intervals.end(), cmp);
        vector<Interval> res;
        if(intervals.empty()) return res;
        res.push_back(intervals[0]);
        for(int i=1;i<intervals.size();i++){
            auto& back=res.back();
            if(intervals[i].start>back.end){
                res.push_back(intervals[i]);
            } else {
                back.end=max(intervals[i].end, back.end);
            }
        }
        return res;
    }
};
