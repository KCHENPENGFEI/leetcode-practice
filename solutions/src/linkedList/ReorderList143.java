package linkedList;

import java.util.*;

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

    // 方法二: 使用递归
    public void reorderList2(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        //求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;//中间链表的头结点
        head.next = tail;
        ListNode outTail = tail.next;  //上一层 head 对应的 tail
        tail.next = subHead;
        return outTail;
    }


    // 1.找中点
    // 2.翻转中点之后的链表(好多方法, Python和 Java 各用一种)
    // 3.依次拼接
    public void reorderList3(ListNode head) {
        if (head == null || head.next == null) return;
        Deque<ListNode> stack = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        int n = stack.size();
        int count = (n - 1) / 2;
        p = head;
        while (count != 0) {
            ListNode tmp = stack.pop();
            tmp.next = p.next;
            p.next = tmp;
            p = tmp.next;
            --count;
        }
        stack.pop().next = null;
    }

    public void reorderList4(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        // 找中点 1 2 3 4 5 6
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 翻转中点, 才用插入法 1 2 3 6 5 4
        ListNode pre = slow;
        ListNode cur = slow.next;
        while (cur.next != null){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }

        // 拼接 1 6 2 5 3 4
        ListNode p1 = head;
        ListNode p2 = slow.next;
        while (p1 != slow){
            // 建议大家这部分画图, 很容易理解的
            slow.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = slow.next;
        }
    }
}
