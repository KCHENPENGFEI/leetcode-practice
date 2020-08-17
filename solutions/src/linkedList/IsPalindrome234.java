package linkedList;


/**
 * @author chenpengfei
 * @date 2020/8/2 3:14 下午
 */
public class IsPalindrome234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 使用快慢指针定位到中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 分成两个链表
        ListNode next = slow.next;
        slow.next = null;
        ListNode newList = reverse(next);
        // 对比
        while (newList != null) {
            if (head.val != newList.val) {
                return false;
            }
            head = head.next;
            newList = newList.next;
        }
        return true;
    }

    public ListNode reverse(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode next = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return next;
    }
}
