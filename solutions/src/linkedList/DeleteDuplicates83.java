package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 删除链表中的重复数字，只保留一个
 * 方法一: 不使用辅助空间，在原始链表进行修改
 * 方法二: 使用额外空间，保存当前指针的数值，上一根指针的数值进行对比
 * 需要注意的是判断边界条件，如果pre为空，让日等于val - 1，这样就能保证肯定不相等
 * */
public class DeleteDuplicates83 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,1,2,3,3));
        ListNode head = ListNode.transform(list);
        DeleteDuplicates83 deleteDuplicates83 = new DeleteDuplicates83();
        ListNode result = deleteDuplicates83.deleteDuplicates1(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pointer = head;
        while (pointer != null && pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                // 跳过
                pointer.next = pointer.next.next;
            }
            else {
                pointer = pointer.next;
            }
        }
        return preHead.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer.next != null && pointer.next.next != null) {
            if (pointer.next.val == pointer.next.next.val) {
                ListNode first = pointer.next;
                while (first.next != null && first.val == first.next.val) {
                    first = first.next;
                }
                // 因为要保留一个重复的元素，所以pointer.next要指向first，此时first已经指向了重复元素的最后一个
                pointer.next = first;
            }
            // 此时无论如何都是对pointer指针指向下一个元素，因为我们要保留重复的一个元素
            pointer = pointer.next;
        }
        return dummy.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        // 使用辅助空间
        ListNode pointer = head;
        ListNode result = new ListNode(0);
        ListNode pointerRes = result;
        ListNode pointerPre = new ListNode(0);
        pointerPre.next = head;
        while (pointer != null) {
            int val = pointer.val;
            int preVal = pointer == head? val - 1: pointerPre.val;
            if (val != preVal) {
                pointerRes.next = new ListNode(val);
                pointerRes = pointerRes.next;
            }
            pointer = pointer.next;
            pointerPre = pointerPre.next;
        }
        return result.next;
    }
}
