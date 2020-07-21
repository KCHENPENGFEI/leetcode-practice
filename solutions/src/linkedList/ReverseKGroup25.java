package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/26 10:17 上午
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 做法: 首先计算链表的长度，统计出需要进行几次翻转，使用while循环对每一个loop操作
 * 对于翻转k长度的链表，使用reverse函数递归进行翻转，翻转完成之后将翻转完成的链表和后面的部分连接起来再重新进入while循环
 *
 * 主要看做法2
 */
public class ReverseKGroup25 {
    int cnt = 1;
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ListNode head = ListNode.transform(arr);
        int k = 2;
        ReverseKGroup25 reverseKGroup25 = new ReverseKGroup25();
        reverseKGroup25.reverseKGroup(head, k);
    }
    public ListNode reverseKGroup1(ListNode head, int k) {
        // 统计链表的长度
        int len = 0;
        ListNode pointer = head;
        while (pointer != null) {
            len++;
            pointer = pointer.next;
        }
        // 确定循环次数
        int loop = len / k;
        int loopCnt = 0;
        // 下一次循环开始的指针
        ListNode nextPointer = head;
        // 当前循环开始的指针
        ListNode curPointer = head;
        // 上一次循环结束的指针
        ListNode lastEndPointer = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (loopCnt < loop) {
            // 首先保存下一个loop的头指针
            int perLoop = 0;
            while (perLoop < k) {
                nextPointer = nextPointer.next;
                perLoop++;
            }
            // 开始分批翻转
            ListNode perLoopStart = reverse(curPointer, k);
            // 进行首尾相接
            if (lastEndPointer != null) {
                lastEndPointer.next = perLoopStart;
            }
            // 重置cnt
            cnt = 1;
            // 保存结果头指针
            if (loopCnt == 0) {
                dummy.next = perLoopStart;
            }
            // 为下一次循环做准备
            lastEndPointer = curPointer;
            curPointer.next = nextPointer;
            curPointer = nextPointer;
            loopCnt++;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head, int k) {
        if (k == cnt) {
            return head;
        }
        cnt++;
        ListNode cur = reverse(head.next, k);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            // tail等于空说明长度不足，不用翻转
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // 获得新的头结点
        ListNode newHead = reverse(head, tail);
        // 将前一部分和后一部分进行连接
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    /**
    * 左闭右开区间
     * 翻转head tail前一个节点之间的链表
    **/
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
