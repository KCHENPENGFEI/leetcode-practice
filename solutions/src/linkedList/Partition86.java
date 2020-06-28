package linkedList;

/**
 * 分隔链表: 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 做法: 一次遍历链表，将小于x的数字保存到一个链表，大于等于x的保存至另一个链表，最后进行一次拼接
 * */
public class Partition86 {
    public ListNode partition(ListNode head, int x) {
        // 非原地改变做法, 利用了额外空间, 原始head不变
        ListNode left = new ListNode(0);
        ListNode leftPointer = left;
        ListNode right = new ListNode(0);
        ListNode rightPointer = right;
        ListNode cur = head;
        while (cur != null) {
            int val = cur.val;
            if (val < x) {
                // 放入left中
                leftPointer.next = new ListNode(val);
                leftPointer = leftPointer.next;
            }
            else {
                // 放入right中
                rightPointer.next = new ListNode(val);
                rightPointer = rightPointer.next;
            }
            cur = cur.next;
        }
        // 拼接
        leftPointer.next = right.next;
        return left.next;
    }
}
