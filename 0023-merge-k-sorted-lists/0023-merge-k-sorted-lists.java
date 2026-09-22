class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode ans = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ans = merge(ans, lists[i]);
        }
        return ans;
    }
    ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        curr.next = (a != null) ? a : b;
        return dummy.next;
    }
}