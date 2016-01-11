class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        unordered_set<string> strset;
        multimap<string, string> strmmap;
        vector<string> res;
        
        for(int i=0;i<strs.size();i++){
            string s=strs[i];
            sort(s.begin(), s.end());
            if(strset.find(s)==strset.end()){
                strset.insert(s);
            }
            strmmap.insert(make_pair(s, strs[i]));
        }
        
        for(auto e : strset){
            if(strmmap.count(e)>1){
                auto itr_pair=strmmap.equal_range(e);
                for(auto itr=itr_pair.first; itr!=itr_pair.second; itr++){
                    res.push_back(itr->second);
                }
            }
        }
        return res;
    }
};
