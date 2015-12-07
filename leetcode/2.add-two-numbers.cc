/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry=0;
        ListNode* head;
        ListNode** h=&head;
        while(l1 || l2) {
            int sum=carry;
            if(l1) {
                sum+=l1->val;
                l1=l1->next;
            }
            if(l2) {
                sum+=l2->val;
                l2=l2->next;
            }
            *h=new ListNode(sum%10);
            h=&((*h)->next);
            carry=sum/10;
        }
        if(carry) {
            *h=new ListNode(carry);
        }
        return head;
    }
};
