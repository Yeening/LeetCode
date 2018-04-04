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
        ListNode *pre = new ListNode(0);
        ListNode *prehead = pre;
        int digit = 0;
        int next_num = 0;
        while(l1||l2||next_num){
            int val1 = 0,val2 = 0,sum = 0;
            if(l1) {
                val1 = l1->val;
                l1 = l1->next;
            }
            if(l2) {
                val2 = l2->val;
                l2 = l2->next;
            }
            sum = val1 + val2 + next_num;
            pre->next = new ListNode(sum%10);
            pre = pre->next;
            next_num = (sum>=10);
        }
        return prehead->next;
    }
};


/*Solution 2 from StefanPochmann @ Leetcode*/
ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    ListNode preHead(0), *p = &preHead;
    int extra = 0;
    while (l1 || l2 || extra) {
        if (l1) extra += l1->val, l1 = l1->next;
        if (l2) extra += l2->val, l2 = l2->next;
        p->next = new ListNode(extra % 10);
        extra /= 10;
        p = p->next;
    }
    return preHead.next;
}
