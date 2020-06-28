package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重排链表
 * */
public class ReorderList143 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4));
        ListNode head = ListNode.transform(arr);
        ReorderList143 reorderList143 = new ReorderList143();
        reorderList143.reorderList(head);
    }
    /**
     * 方法一: 将链表每个数字保存到list中，然后利用双指针重新构造链表
     * */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            list.add(pointer);
            pointer = pointer.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            else {
                list.get(j).next = list.get(i);
                j--;
            }
        }
        list.get(i).next = null;
    }
}
