package linkedList;

import java.util.LinkedList;

/**
 * @author chenpengfei
 * @date 2020/7/8 7:03 下午
 * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
 *
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 *
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
 *
 * 做法: 构造一个stack来保存每个位的数值
 */
public class PlusOne369 {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        int carry = 1;
        // ListNode dummy = new ListNode(0);
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode tmp = null;
        while (!stack.isEmpty()) {
            int a = stack.poll();
            int sum = a + carry;
            int res = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(res);
            node.next = tmp;
            tmp = node;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = tmp;
            tmp = node;
        }
        return tmp;
    }
}
