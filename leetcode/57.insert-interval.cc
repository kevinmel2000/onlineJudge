class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
       vector<Interval> res;
       auto itr=intervals.begin();
       while(itr!=intervals.end()){
           if(newInterval.end < itr->start){
               res.push_back(newInterval);
               res.insert(res.end(), itr, intervals.end());
               return res;
           } else if(newInterval.start > itr->end) {
               res.push_back(*itr);
               itr++;
           } else {
               newInterval.start=min(itr->start, newInterval.start);
               newInterval.end=max(itr->end, newInterval.end);
               itr++;
           }
       }
       res.push_back(newInterval);
       return res;
    }
};
