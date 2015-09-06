class PreorderTreeIter
{
public:
    PreorderTreeIter(BinaryTree* root): cur(root)
    {
        if(root && root->right){
            stk.push(root->right);
        }
        if(root && root->left){
            stk.push(root->left);
        }
        if(root){
            stk.push(root);
        }
    }
   
    bool hasNext(){
        return !stk.empty();
    }
   
    BinaryTree* next(){
        if(!hasNext()){
            return NULL;
        }
       
        BinaryTree* cur=stk.top();
        stk.pop();
       
        if(cur && cur->right){
            stk.push(cur->right);
        }
        if(cur && cur->left){
            stk.push(cur->left);
        }
       
        return cur;
    }
   
private:
    std::stack<BinaryTree*> stk;
};
