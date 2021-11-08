import java.util.PriorityQueue;

// 23.合并K个升序链表
public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));

        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            p.next = cur;
            p = p.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }

        return dummy.next;
    }
}
