package linkedList;

/**
 * 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 解法: 使用头插法，定义两个指针一根指向m位置前面一个元素pre，一根指着m位置end
 * 然后根据n的大小遍历m后面的元素，使用头插法插到pre的后面
 * */
public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = head;
        int cnt = 1;
        // 首先对pre和end进行定位
        while (cnt < m) {
            pre = pre.next;
            end = end.next;
            cnt++;
        }
        while (cnt < n) {
            // 头插法
            // 找到要进行头插的元素removed
            ListNode removed = end.next;
            // 删除该元素
            end.next = removed.next;
            // 插入到pre的后面
            removed.next = pre.next;
            pre.next = removed;
            cnt++;
        }
        return dummy.next;
    }
}
