package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 删除链表中的重复数字，只要重复的就不保留
 * 方法一: 在原始链表上进行修改
 * 方法二: 使用额外空间，保存当前指针的数值，上一根指针的数值，后一根指针的数值进行对比，
 * 需要注意的是判断边界条件，如果pre和next为空，分别让其等于val - 1和val + 1，这样就能保证肯定不相等
 * */
public class DeleteDuplicates82 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,1,2,3,3,4,4,5));
        ListNode head = ListNode.transform(list);
        DeleteDuplicates82 deleteDuplicates82 = new DeleteDuplicates82();
        ListNode result = deleteDuplicates82.deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    /**
     * 关键难点在于去重复元素的时候我们直接让pointer.next指向下一个元素，然后不能让pointer指向下一个元素，
     * 因为下一个元素可能也是要删除的元素，如果直接指向的话就会出错
     * */
    public ListNode deleteDuplicates(ListNode head) {
        // 原地删除，单指针做法
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer.next != null && pointer.next.next != null) {
            if (pointer.next.val == pointer.next.next.val) {
                ListNode first = pointer.next;
                while (first.next != null && first.val == first.next.val) {
                    first = first.next;
                }
                pointer.next = first.next;
                // 此时不能令pointer = pointer.next，因为pointer也可能要删除
//                pointer = pointer.next;
            }
            else {
                pointer = pointer.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        // 使用辅助空间
        ListNode result = new ListNode(0);
        ListNode pointerRes = result;
        ListNode pointer = head;
        ListNode prePointer = new ListNode(0);
        prePointer.next = head;
        while (pointer != null) {
            int val = pointer.val;
            int preVal = pointer == head? val - 1: prePointer.val;
            int nextVal = pointer.next == null? val + 1: pointer.next.val;
            if (val != preVal && val != nextVal) {
                pointerRes.next = new ListNode(val);
                pointerRes = pointerRes.next;
            }
            pointer = pointer.next;
            prePointer = prePointer.next;
        }
        return result.next;
    }
}
