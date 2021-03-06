package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 * */
public class CopyRandomList138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node pointer = head;
        // 存储哈希表，将原始Node和新建的Node对应保存
        Map<Node, Node> map = new HashMap<>();
        while (pointer != null) {
            map.put(pointer, new Node(pointer.val));
            pointer = pointer.next;
        }
        pointer = head;
        while (pointer != null) {
            // 前半句是新建的node(当前pointer)的next指针，后半句是新建的node(下一个pointer)的next指针
            map.get(pointer).next = map.get(pointer.next);
            map.get(pointer).random = map.get(pointer.random);
            pointer = pointer.next;
        }
        pointer = head;
        return map.get(pointer);
    }
}
