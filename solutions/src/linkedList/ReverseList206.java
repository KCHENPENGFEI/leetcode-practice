package linkedList;

/**
 * 翻转链表
 * */
public class ReverseList206 {
    ListNode res = null;
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            res = head;
            return head;
        }
        reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
