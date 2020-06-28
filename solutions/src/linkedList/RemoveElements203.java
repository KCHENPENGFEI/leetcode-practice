package linkedList;

/**
 * 移除链表中指定元素
 * */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
