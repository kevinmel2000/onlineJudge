class Solution {
public:
    int compareVersion(string version1, string version2) {
        istringstream is1(version1);
        istringstream is2(version2);
        
        while(!is1.eof() || !is2.eof()) {
            string s1, s2;
            if(!is1.eof()) {
                getline(is1, s1, '.');
            }
            if(!is2.eof()) {
                getline(is2, s2, '.');
            }
            if(s1.empty()) {
                for(auto e : s2) {
                    if(e!='0') return -1;
                }
                continue;
            }
            if(s2.empty()) {
                for(auto e : s1) {
                    if(e!='0') return 1;
                }
                continue;
            }
            
            size_t i1=atoi(s1.c_str());
            size_t i2=atoi(s2.c_str());
            if(i1==i2) {
                continue;
            }
            return (i1<i2)? -1:1;
        }
        return 0;
    }
};
