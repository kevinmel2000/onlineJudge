class BTPostIterator
{
private:
    BinaryTree* prev;
    std::stack<BinaryTree*> stk;
    insertTemp(BinaryTree* tmp){
        while(tmp!=NULL){
            stk.push(tmp);
            tmp=(tmp.left==NULL)?tmp.right : tmp.left;
        }
    }
   
public:
    BTPostIterator(BinaryTree* root){
        insertTemp(root);
    }
    bool hasNext(){
        return !stk.empty();
    }
   
    BinaryTree* next(){
        if(!hasNext()) {
            return NULL;
        }
       
        BinaryTree* top=stk.top();
        if(top->right!=prev && top->right!=NULL) {
            insertTemp(top->right);
        }
        BinaryTree* ret=stk.top();
        prev=ret;
        return ret;
    }
};
