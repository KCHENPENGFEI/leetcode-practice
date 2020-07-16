package unknown;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpengfei
 * @date 2020/7/16 8:11 下午
 */
public class LFUCache {
    /**
     * 用保存每一个节点的node，由于是双向链表所以设置pre和next
     *
     **/
    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    /**
     * 双向链表结构
     *
     **/
    class DoubleList {
        private Node head;
        private Node tail;
        private int cap;

        public DoubleList() {
            // 设置了头尾哨兵方便数据的插入和移除
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            // 此时链表为空
            head.next = tail;
            tail.pre = head;
            cap = 0;
        }

        public void addFirst(Node x) {
            // 在head和first之间插入一个数据
            x.next = head.next;
            x.pre = head;
            head.next.pre = x;
            head.next = x;
            cap++;
        }

        public void removeNode(Node x) {
            // 删除节点x，由于哨兵的存在，直接删除即可，不用考虑null的情况
            x.pre.next = x.next;
            x.next.pre = x.pre;
            cap--;
        }

        public Node removeLast() {
            // 这里需要考虑cap为0的情况，不然会返回哨兵
            if (cap == 0) {
                return null;
            }
            Node res = tail.pre;
            removeNode(res);
            return res;
        }

        public int size() {
            return cap;
        }
    }

    private Map<Integer, Node> map;


    public LFUCache(int capacity) {
    }

    public int get(int key) {
        return 1;
    }

    public void put(int key, int value) {
    }
}
