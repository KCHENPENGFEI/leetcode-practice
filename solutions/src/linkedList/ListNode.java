package linkedList;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode transform(List<Integer> list) {
        ListNode pointer = new ListNode(0);
        ListNode pre = pointer;
        for (int i: list) {
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }
        return pre.next;
    }
}

