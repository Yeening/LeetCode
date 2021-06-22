// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye/k-ge-yi-zu-fan-zhuan-lian-biao
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = reverseFirstN(head, k);
        if (newHead == null) return head;
        head.next = reverseKGroup(head.next, k);
        return newHead;
    }

    public ListNode reverseFirstN(ListNode head, int n) {
        if (n == 0 || head == null) return null;
        if (n == 1) return head;
        ListNode last = reverseFirstN(head.next, n-1);
        if (last != null) {
            // insert head between head.next and head.next.next
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            return last;
        }
        return null;
    }
}

// Iteractive solution
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = head, r = head;
        for (int i = 0; i < k; i++) {
            if (r == null) return head;
            r = r.next;
        }

        // reverse between l and r [l, r)
        ListNode pre = l, cur = pre.next;
        while (cur != r) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        l.next = reverseKGroup(r, k);
        return pre;
    }
}
