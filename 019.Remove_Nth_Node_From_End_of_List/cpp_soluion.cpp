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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode pre_head(0);
        pre_head.next = head;
        ListNode* slow = &pre_head;
        for(int i = 0; i < n; i++){
            head = head->next;
        }
        while(head){
            head = head->next;
            slow = slow->next;
        }
        ListNode* next = slow->next->next;
        delete slow->next;
        slow->next = next;
        return pre_head.next;
    }
};
