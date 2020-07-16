package unknown;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpengfei
 * @date 2020/7/16 6:59 下午
 *
 * LRU缓存的设计
 *
 * 设计一个双向的哈希链表
 */
class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        lruCache.get(2);
        lruCache.put(3, 2);
        lruCache.get(2);
        lruCache.get(3);
    }


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

    private DoubleList cache;

    private int cap;

    public LRUCache(int capacity) {
        // map用来O(1)时间复杂度的查询
        this.map = new HashMap<>(capacity);
        // cache用来O(1)时间复杂度的删除和排序
        this.cache = new DoubleList();
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        else {
            // 需要删除x在缓存中的位置然后插入到头部
            Node x = map.get(key);
            cache.removeNode(x);
            cache.addFirst(x);
            return x.value;
        }
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            // 同理，删除x然后插入头部
            cache.removeNode(map.get(key));
            cache.addFirst(x);
            map.replace(key, x);
        }
        else {
            int size = cache.size();
            if (size == cap) {
                // 删除缓存最后一个元素不要忘记删除map中的元素
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 将x插入头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}
