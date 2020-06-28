package linkedList;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * */
public class SortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = sortList(head.next);
        return sorted(head);
    }

    public ListNode sorted(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 保存第二个元素，因为其可能成为head
        ListNode next = head.next;
        // 特判
        if (head.val <= next.val) {
            // 有序
            return head;
        }
        ListNode pointer = next.next;
        ListNode pre = next;
        while (pointer != null) {
            int val = pointer.val;
            int headVal = head.val;
            if (headVal > val) {
                pre = pointer;
                pointer = pointer.next;
            }
            else {
                pre.next = head;
                head.next = pointer;
                dummy.next = next;
                break;
            }
        }
        if (pointer == null) {
            // head最大
            pre.next = head;
            head.next = null;
            dummy.next = next;
        }
        return dummy.next;
    }

    public ListNode sortList1(ListNode head) {
        // 迭代做法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val >= pre.val) {
                // 已经有序
                pre = cur;
                cur = cur.next;
                continue;
            }
            ListNode p = dummy;
            while (p.next != cur && p.next.val < cur.val) {
                p = p.next;
            }
            pre.next = cur.next;
            cur.next = p.next;
            p.next = cur;
            cur = pre.next;
        }
        return dummy.next;
    }
}
