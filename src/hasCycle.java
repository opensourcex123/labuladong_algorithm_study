// 141.环形链表
public class hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.val == slow.val)
                return true;
        }
        return false;
    }
}
