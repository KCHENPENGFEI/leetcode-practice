package linkedList;

/**
 * 相交链表
 * 思路: 假设两条链表相交, lenA = a + l, lenB = b + l,
 * 那么当指针走到A的末尾时, 令其下一个指向headB, 同理B也是
 * 则最终两个指针走掉的距离为a + l + b，必然相等
 * */
public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getIntersectionNode1(headA, headB);
    }
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = pointerA == null? headB: pointerA.next;
            pointerB = pointerB == null? headA: pointerB.next;
        }
        return pointerA;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 暴力法
        while (headA != null) {
            ListNode pointerB = headB;
            while (pointerB != null) {
                if (pointerB == headA) {
                    return headA;
                }
                pointerB = pointerB.next;
            }
        }
        return null;
    }
}
