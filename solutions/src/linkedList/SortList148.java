package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 使用快慢指针将链表从中间截断，递归排序左半部分和右半部分，然后将左右两部分进行排序
 * */
public class SortList148 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,4));
        ListNode head = ListNode.transform(list);
        SortList148 sortList148 = new SortList148();
        sortList148.sortList(head);
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 这样定义的时候能够保证slow指向链表的中点，并且向下取整
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 保存slow指针
        ListNode tmp = slow;
        slow = slow.next;
        tmp.next = null;
        // 现在head和slow已经将链表分为两部分
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        // 使用||判断
//        while (left != null || right != null) {
//            if (left == null) {
//                pointer.next = right;
//                right = right.next;
//            }
//            else if (right == null) {
//                pointer.next = left;
//                left = left.next;
//            }
//            else {
//                if (left.val < right.val) {
//                    pointer.next = left;
//                    left = left.next;
//                }
//                else {
//                    pointer.next = right;
//                    right = right.next;
//                }
//            }
//            pointer = pointer.next;
//        }
        // 使用&&判断
        while (left != null && right != null) {
            if (left.val < right.val) {
                pointer.next = left;
                left = left.next;
            } else {
                pointer.next = right;
                right = right.next;
            }
            pointer = pointer.next;
        }
        pointer.next = left != null ? left : right;

        return dummy.next;
    }
}