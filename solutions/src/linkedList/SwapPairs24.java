package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 24. 两两交换链表中的节点
 * 思路: 用List保存链表，然后两两交换节点
 * */
public class SwapPairs24 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ListNode head = ListNode.transform(arr);
        SwapPairs24 swapPairs24 = new SwapPairs24();
        ListNode res = swapPairs24.swapPairs(head);
    }
    public ListNode swapPairs(ListNode head) {
        // 存储法，将链表保存到Arrays中
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = head;
        List<ListNode> list = new ArrayList<>();
        while (pointer != null) {
            list.add(pointer);
            pointer = pointer.next;
        }
        int i = 0;
        int j = 1;
        while (i < list.size() - 1) {
            // dummy指向第一个节点
            if (j == 1) {
                dummy.next = list.get(j);
            }
            // j 指向 i
            list.get(j).next = list.get(i);
            j += 2;
            // i 指向 j，注意判断边界条件
            list.get(i).next = j < list.size()? list.get(j): j == list.size()? list.get(j - 1): null;
            i += 2;
        }
        return dummy.next;
    }

    public ListNode swapPairs1(ListNode head) {
        // 递归解法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        // 非递归且不使用Arrays做辅助
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
