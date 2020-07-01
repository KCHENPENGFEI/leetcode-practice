package linkedList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * */
public class HasCycle141 {
    // 一种不太优雅的解法
    public boolean hasCycle(ListNode head) {
        // 快慢指针
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        do {
            pointer1 = pointer1 == null? null: pointer1.next;
            pointer2 = pointer2 == null? null: (pointer2.next == null)? null: pointer2.next.next;
        } while (pointer2 != pointer1 && pointer1 != null && pointer2 != null);
        if (pointer1 == null) {
            return false;
        }
        if (pointer1.next == null) {
            return false;
        }
        if (pointer2 == null) {
            return false;
        }
        if (pointer2.next == null) {
            return false;
        }
        if (pointer2.next.next == null) {
            return false;
        }
        if (pointer2 == pointer1) {
            if (pointer1 == null) {
                return false;
            }
        }
        return true;
    }

    // 优雅的快慢指针
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        return true;
    }
    // 哈希表，保存已经遍历过的Node
    public boolean hasCycle1(ListNode head) {
        // 哈希表
        ListNode pointer = head;
        Set<ListNode> set = new HashSet<>();
        while (pointer != null) {
            if (!set.contains(pointer)) {
                set.add(pointer);
            }
            else {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }
}
