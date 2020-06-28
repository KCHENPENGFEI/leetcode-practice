package linkedList;

/**
 * 法一: 特殊解法，将链表转成字符串，然后进行字符串相加，在转换成链表
 * 法二: 常规解法，不进行补零，直接判断链表是否为空即可，要注意空指针情况分开判断
 * */
public class AddTwoNumbers2 {
    public static void main(String[] args) {
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String val1 = transform(l1);
        String val2 = transform(l2);
        String result = add(val1, val2);
        return transformBack(result);
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a, b;
            // 如果l1为空
            if (l1 == null) {
                a = 0;
                b = l2.val;
                l2 = l2.next;
            }
            else if (l2 == null) {
                a = l1.val;
                b = 0;
                l1 = l1.next;
            }
            else {
                a = l1.val;
                b = l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            int sum = a + b + carry;
            int he = sum % 10;
            carry = sum / 10;
            pointer.next = new ListNode(he);
            pointer = pointer.next;

        }
        // 处理结尾
        if (carry == 1) {
            pointer.next = new ListNode(carry);
//            pointer = pointer.next;
        }
        return head.next;
    }

    public String transform(ListNode l) {
        StringBuilder sb = new StringBuilder();
        while (l != null) {
            sb.append(l.val);
            l = l.next;
        }
        return sb.reverse().toString();
    }

    public String add(String s1, String s2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(s1.length(), s2.length()); i++) {
            int a1 = (i < s1.length())? s1.charAt(s1.length() - 1 - i) - '0': 0;
            int a2 = (i < s2.length())? s2.charAt(s2.length() - 1 - i) - '0': 0;
            int sum = a1 + a2 + carry;
            int he = sum % 10;
            carry = sum / 10;
            sb.append(he);
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public ListNode transformBack(String s) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        for (int i = s.length() - 1; i >= 0; i--) {
            head.next = new ListNode(s.charAt(i) - '0');
            head = head.next;
        }
        return result.next;
    }
}
