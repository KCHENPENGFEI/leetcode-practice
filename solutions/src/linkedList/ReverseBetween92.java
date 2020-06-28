package linkedList;

import java.util.LinkedList;

/**
 * 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 解法一: 使用一个LinkedList保存需要翻转的节点，然后依次pop出来，
 * 注意的是需要保存第m-1个节点的位置和n+1节点的位置，用于生成指针
 * */
public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        ListNode stop = null;
        dummy.next = head;
        ListNode pointer = dummy;
        // 两趟扫描尝试
        LinkedList<ListNode> tmp = new LinkedList<>();
        int cnt = 0;
        while (pointer != null) {
            if (cnt == m - 1) {
                // 保存指针
                start = pointer;
            }
            else if (cnt >= m && cnt <= n) {
                tmp.add(pointer);
            }
            else if (cnt == n + 1) {
                stop = pointer;
                break;
            }
            pointer = pointer.next;
            cnt++;
        }
        while (!tmp.isEmpty()) {
            start.next = tmp.removeLast();
            start = start.next;
        }
        start.next = stop;
        return dummy.next;
    }
}
