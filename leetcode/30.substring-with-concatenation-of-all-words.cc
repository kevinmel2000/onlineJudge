class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        unordered_map<string, size_t> pattern;
        unordered_map<string, size_t> found;
        
        size_t ns=s.size();
        size_t nw=words.size();
        
        size_t L=words[0].size();
        
        for(auto e : words) {
            pattern[e]++;
        }

        vector<int> res;
        for(size_t i=0;i<L;i++) {
            found.clear();
            size_t start=i;
            size_t len=0;
            for(size_t j=i;j<ns;j+=L) {
                string sub=s.substr(j, L);
                if(pattern.find(sub)==pattern.end()) {
                    found.clear();
                    len=0;
                    start=j+L;
                    continue;
                }

                if(found[sub]<pattern[sub]) {
                    found[sub]++;
                    len++;
                    if(len==words.size()) {
                        res.push_back(start);
                        string last=s.substr(start,L);
                        found[last]--;
                        len--;
                        start+=L;
                    }
                } else {
                    while(start<j) {
                        string last=s.substr(start, L);
                        start+=L;
                        if(last==sub) break;
                        found[last]--;
                        len--;
                    }
                }
            }
        }
        return res;
    }
};
