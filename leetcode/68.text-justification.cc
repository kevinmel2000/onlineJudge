class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
        vector<string> res;
        // if(L==0) return words;
        size_t n=words.size();
        size_t start=0;
        while(start<n) {
            size_t ls=0;
            size_t i=start;
            for(; i<n && ls+i-start+words[i].size()<=L; i++) {
                ls+=words[i].size();
            }
            
            if(i==start+1) { // only one word
                string line = words[start];
                int endspace=L- (int) line.size(); // line needs to fill in space at the end
                line.append(endspace, ' ');
                res.push_back(line);
                start++;
            } else { // i will be index of the next word
                size_t space=(L-ls)/(i-start-1);
                size_t bonus=(L-ls)-space*(i-start-1);
                if(i>=n) { // last line
                    bonus=0;
                    space=1;
                }
                string line=words[start++];
                while(start<i) {
                    if(bonus>0){
                        line.append(space+1, ' ');
                        bonus--;
                    } else {
                        line.append(space, ' ');
                    }
                    line+=words[start++];
                }
                int endspace=L-line.size();// corner case: last line needs to fill in space at the end
                line.append(endspace, ' ');
                res.push_back(line);
                start=i;
            }
        }
        return res;
    }
};
