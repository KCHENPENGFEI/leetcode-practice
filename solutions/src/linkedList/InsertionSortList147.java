package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用递归解法的妙处在于: 先处理链表后面的序列，每次排序之后再加上前一个node，再进行排序，
 * sort函数可以保证将一个head插入后面的列表中
 * */
public class InsertionSortList147 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(6,7,1,3,2,4));
        ListNode head = ListNode.transform(arr);
        InsertionSortList147 insertionSortList147 = new InsertionSortList147();
        ListNode res = insertionSortList147.insertionSortList1(head);
    }
    public ListNode insertionSortList(ListNode head) {
        // 递归做法，从后往前进行排序
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = insertionSortList(next);
        return sort(head);
    }

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pointer = head.next;
        ListNode pre = head;
        // 保存第二个指针的位置
        ListNode next = head.next;
        int val = head.val;
        // 如果head小于next，直接返回（因为此时已经有序）
        if (val < next.val) {
            return dummy.next;
        }
        while (pointer != null) {
            int cunVal = pointer.val;
            if (cunVal > val) {
                // 插入
                pre.next = head;
                head.next = pointer;
                // 最小的元素为next
                dummy.next = next;
                break;
            }
            pre = pointer;
            pointer = pointer.next;
        }
        // head是最大的元素，插入到最后
        if (pointer == null) {
            pre.next = head;
            head.next = null;
            dummy.next = next;
        }
        return dummy.next;
    }

    public ListNode insertionSortList1(ListNode head) {
        // 非递归解法，从前往后进行排序
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = head.next;
        ListNode pre = head;
        while (pointer != null) {
            if (pre.val <= pointer.val) {
                // 已经有序
                pointer = pointer.next;
                pre = pre.next;
            }
            else {
                // 将pointer插入指定位置
                ListNode p = dummy;
                while (p.next != pointer && p.next.val < pointer.val) {
                    p = p.next;
                }
                pre.next = pointer.next;
                pointer.next = p.next;
                p.next = pointer;
                pointer = pre.next;
            }
        }
        return dummy.next;
    }
}
