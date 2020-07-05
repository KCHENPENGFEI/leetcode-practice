package linkedList;

import java.util.Random;

/**
 * @author chenpengfei
 * @date 2020/7/5 1:45 下午
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 * 常数空间级那就可以记录链表的长度，然后随机一个[0, len]之间的数字，从头部开始找
 *
 */
public class Solution382 {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    private int length = 0;
    private final ListNode listNode;
    public Solution382(ListNode head) {
        this.listNode = head;
        while (head != null) {
            this.length++;
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(length);
        ListNode head = this.listNode;
        while (index > 0) {
            head = head.next;
            index--;
        }
        return head.val;
    }
}
