package graph;

import java.util.*;

/**
 * @author chenpengfei
 * @date 2020/6/24 10:39 上午
 *
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 */
public class CloneGraph133 {
    // DFS
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    private Node dfs(Node node, Map<Node,Node> lookup) {
        if (node == null) {
            return null;
        }
        if (lookup.containsKey(node)) {
            return lookup.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, lookup));
        }
        return clone;
    }

    // BFS
    public Node cloneGraph1(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n : tmp.neighbors) {
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                lookup.get(tmp).neighbors.add(lookup.get(n));
            }
        }
        return clone;
    }

    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        // 首先把node加入队列
        queue.addLast(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (!map.containsKey(cur)) {
                map.put(cur, new Node(cur.val, new ArrayList<>()));
            }
            for (Node child: cur.neighbors) {
                if (!map.containsKey(child)) {
                    map.put(child, new Node(child.val, new ArrayList<>()));
                    queue.addLast(child);
                }
                map.get(cur).neighbors.add(map.get(child));
            }
        }
        return map.get(node);
    }
}
