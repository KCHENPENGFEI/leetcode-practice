package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * */
public class MergeTwoLists21 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,4));
        ListNode l1 = ListNode.transform(list1);
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,3,4));
        ListNode l2 = ListNode.transform(list2);
        MergeTwoLists21 mergeTwoLists21 = new MergeTwoLists21();
        System.out.println(mergeTwoLists21.mergeTwoLists1(l1, l2).val);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pointer.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else if (l2 == null) {
                pointer.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                int val1 = l1.val;
                int val2 = l2.val;
                pointer.next = new ListNode(Math.min(val1, val2));
                if (val1 > val2) {
                    l2 = l2.next;
                }
                else {
                    l1 = l1.next;
                }
            }
            pointer = pointer.next;
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            }
            else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        if (cur1 == null) {
            pre.next = cur2;
        }
        else {
            pre.next = cur1;
        }
        return dummy.next;
    }
}
