class Solution {
public:
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    vector<string> convertToRPN(vector<string> &expression) {
        // write your code here
        for(int i=0;i<expression.size();i++) {
            if(!isOp(expression[i])) {
                res.push_back(expression[i]);
            } else {
                if(expression[i]==")") {
                    while(ops.top()!="(") {
                        res.push_back(ops.top()); ops.pop();
                    }
                    ops.pop();
                } else {
                    while(!ops.empty() && hasPrecedence(ops.top(), expression[i])) {
                        res.push_back(ops.top()); ops.pop();
                    }
                    ops.push(expression[i]);
                }
            }
        }
        while(!ops.empty()) {
            res.push_back(ops.top()); ops.pop();
        }
        return res;
    }

    bool isOp(const string& op) {
        return op=="+" || op=="-" || op=="*" || op=="/" || op=="(" || op==")";
    }
    bool hasPrecedence(const string& op1, const string& op2) {
        if(op2=="(" || op1=="(") return false;
        if((op2=="*" || op2=="/") && (op1=="+" || op1=="-")) return false;
        return true;
    }
private:
    vector<string> res;
    stack<string> ops; 
};
