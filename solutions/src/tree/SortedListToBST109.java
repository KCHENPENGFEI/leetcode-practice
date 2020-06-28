package tree;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 做法1: 使用快慢指针去找到链表的中间位置，找到之后断开将链表分成两部分，然后递归求解
 * */
public class SortedListToBST109 {
    public static void main(String[] args) {
        SortedListToBST109 sortedListToBST109 = new SortedListToBST109();
        int[] head = new int[]{-10, -3, 0, 1, 5};
        ListNode headNode = ListNode.transform(Arrays.stream(head).boxed().collect(Collectors.toList()));
        TreeNode root = sortedListToBST109.sortedListToBST(headNode);
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            pre = pre.next;
            fast = fast.next.next;
        }
        // slow构成root
        TreeNode root = new TreeNode(slow.val);
        // 断开链表
        pre.next = null;
        // 递归左子树
        root.left = sortedListToBST(dummy.next);
        // 递归右子树
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
