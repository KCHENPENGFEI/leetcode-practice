package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/25 12:07 上午
 *
 * 323. 无向图中连通分量的数目
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
 */
public class CountComponents323 {
    public int countComponents(int n, int[][] edges) {
        return countComponents1(n, edges);
    }

    // BFS
    public int countComponents1(int n, int[][] edges) {
        if (n == 0 || n == 1) {
            return n;
        }
        int len = edges.length;
        if (len == 0) {
            return n;
        }
        int ans = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] flags = new boolean[n];
        for (int[] edge : edges) {
            // 生成每个节点的邻接矩阵，注意这里包含了重复的边
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (flags[i]) {
                continue;
            }
            queue.addLast(i);
            ans++;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                flags[node] = true;
                for (int adjNode: adj.get(node)) {
                    if (!flags[adjNode]) {
                        queue.addLast(adjNode);
                    }
                }
            }
        }
        return ans;
    }

    // DFS
    public int countComponents2(int n, int[][] edges) {
        int count = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, adjList);
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int index, List<List<Integer>> adjList) {
        visited[index] = true;
        for (int i : adjList.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, adjList);
            }
        }
    }
}
