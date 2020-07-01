package linkedList;

/**
 * @author chenpengfei
 * @date 2020/6/30 12:13 下午
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 做法: 快慢指针
 * 思路: 两根指针同时从head出发，一个每次移动一步，另一个每次移动两步
 * 当两个指针第一次相遇时候，可以证明快指针走了2nb步，其中b是环的长度，慢指针走了nb步
 * 之后两个指针相遇都将会是在同一个点相遇
 * 相遇时候慢指针走了nb步，如果此时在走a步，a是环之外的长度，那么就走了a + nb步，观察a + nb刚好就是环的入口位置
 * 所以可以得出结论: 快慢指针每次相遇的位置固定，并且在相遇位置后慢指针再走a步就可以到达环的入口
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        // 令fast重新回到head出用于计算出a
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
