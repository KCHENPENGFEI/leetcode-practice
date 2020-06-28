package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/24 1:44 下午
 * 以图判树
 * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），
 * 请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
 */
public class ValidTree261 {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || n == 1) {
            return true;
        }
        int len = edges.length;
        if (len == 0) {
            return false;
        }
        boolean[] flags = new boolean[len];
        return isConnected(n, edges, flags);
    }

    /**
     * 构建一个邻接矩阵，速度更快一些
     * */
    public boolean validTree1(int n, int[][] edges) {
        if (n == 0 || n == 1) {
            return true;
        }
        int len = edges.length;
        if (len == 0) {
            return false;
        }
        // 构建邻接矩阵
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] flags = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int[] edge : edges) {
            // 生成每个节点的邻接矩阵，注意这里包含了重复的边
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        queue.addLast(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            n--;
            flags[node] = true;
            for (int adjNode: adj.get(node)) {
                // 如果没有遍历过
                if (!flags[adjNode]) {
                    // 如果形成了环
                    if (queue.contains(adjNode)) {
                        return false;
                    }
                    queue.addLast(adjNode);
                }
            }
        }
        return n == 0;
    }

    private boolean isConnected(int n, int[][] edges, boolean[] flags) {
        if (n == 0 || n == 1) {
            return true;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(edges[0][0]);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < edges.length; i++) {
                if (!flags[i]) {
                    if (edges[i][0] == node) {
                        if (queue.contains(edges[i][1])) {
                            return false;
                        }
                        queue.addLast(edges[i][1]);
                        flags[i] = true;
                    }
                    else if (edges[i][1] == node) {
                        if (queue.contains(edges[i][0])) {
                            return false;
                        }
                        queue.addLast(edges[i][0]);
                        flags[i] = true;
                    }
                }
            }
            n--;
        }
        return n == 0;
    }
}
