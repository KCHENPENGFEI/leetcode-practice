package linkedList;

/**
 * 删除倒数第n个节点
 * 先正序遍历统计链表的长度
 * 然后根据n和长度的关系删除指定节点
 * 使用了两次遍历
 *
 * 做法2: 只使用一趟遍历
 * 使用两根指针指向dummy，其中一根指针先向前移动n步，然后两根指针同时向后移动
 * */
public class RemoveNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer = head;
        int cnt = 0;
        while (pointer != null) {
            cnt++;
            pointer = pointer.next;
        }
        pointer = head;
        if (cnt == n) {
            return head.next;
        }
        while (cnt > n) {
            if (cnt == n + 1) {
                // 执行删除
                pointer.next = pointer.next.next;
                pointer = pointer.next;
            }
            else {
                pointer = pointer.next;
            }
            cnt--;
        }
        return head;
    }
}
