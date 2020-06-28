package heap;

import java.util.PriorityQueue;

public class MergeKLists23 {
    /*只对比链表节点的值*/
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node: lists) {
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }
        return dummy.next;
    }

    /*直接在原始链表进行对比*/
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val < 0? -1: o1.val - o2.val == 0? 0: 1));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node: lists) {
            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        // 要让最后一个next指针指向null，不然会形成环
        cur.next = null;
        return dummy.next;
    }
}
