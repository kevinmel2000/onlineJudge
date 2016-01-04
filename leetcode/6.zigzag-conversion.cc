class Solution {
public:
    string convert(string s, int nRows) {
        if(nRows<=1) return s;
        bool down=true;
        int h=0;
        vector<string> res(nRows);
        for(int i=0;i<s.size();i++) {
            if(down) {
                res[h++].push_back(s[i]);
                if(h>nRows-1) {
                    h-=2;
                    down=false;
                }
            } else {
                res[h--].push_back(s[i]);
                if(h<0) {
                    h+=2;
                    down=true;
                }
            }
        }
        string r;
        for(auto e : res) {
            r+=e;
        }
        return r;
    }
};
