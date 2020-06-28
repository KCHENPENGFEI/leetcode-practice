package linkedList;

/**
 * 链表的旋转
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 使用的方法比较简单，但是使用了额外空间
 * 方法二: 不使用额外空间，思路为将原始链表尾部连接至头部，然后找到断开连接的地方即可
 * */
public class RotateRight61 {

    public ListNode rotateRight1(ListNode head, int k) {
        ListNode pointer = head;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int len = 1;
        while (pointer.next != null) {
            pointer = pointer.next;
            len++;
        }
        k = k % len;
        // 形成一个环
        pointer.next = head;
        ListNode newPointer = head;
        while (len - k - 1 > 0) {
            newPointer = newPointer.next;
            k++;
        }
        ListNode result = newPointer.next;
        newPointer.next = null;
        return result;

    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode result = new ListNode(0);
        ListNode pointer = head;
        ListNode pointer1 = result;
        int len = 0;
        while (pointer != null) {
            pointer = pointer.next;
            len++;
        }
        if (len == 0) {
            return null;
        }
        k = k % len;
        int remain = len - k;
        int remainBak = remain;
        pointer = head;
        while (remain > 0 && pointer != null) {
            pointer = pointer.next;
            remain--;
        }
        // 找到第一个元素
        while (pointer != null) {
            pointer1.next = new ListNode(pointer.val);
            pointer1 = pointer1.next;
            pointer = pointer.next;
        }
        pointer = head;
        while (remainBak > 0 && pointer != null) {
            pointer1.next = new ListNode(pointer.val);
            pointer1 = pointer1.next;
            pointer = pointer.next;
            remainBak--;
        }
        return result.next;
    }
}
