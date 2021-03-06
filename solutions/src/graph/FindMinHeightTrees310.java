package graph;

import java.util.*;

/**
 * @author chenpengfei
 * @date 2020/6/24 2:46 下午
 *
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。
 * 给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 *
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 *
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 *
 */
public class FindMinHeightTrees310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }
        int len = edges.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        boolean[] flags = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();
        // 初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            // 初始化每个节点的度数
            degree[edge[0]]++;
            degree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.addLast(i);
            }
        }
        while (!queue.isEmpty()) {
            // 每次都要初始化result，第一次result保存的是最外层叶子
            // 最后一次循环就是最内层的节点就是最终答案
            result = new ArrayList<>();
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int node = queue.poll();
                result.add(node);
                flags[node] = true;
                for (int adjNode: adj.get(node)) {
                    if (!flags[adjNode]) {
                        degree[adjNode]--;
                        if (degree[adjNode] == 1) {
                            queue.addLast(adjNode);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
//      1.条件判断（边界判断，其他要求的判断）
        if (n == 1){
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];//每个节点的度数
        List<List<Integer>> map = new ArrayList<>();//每个节点
        for (int i=0;i<n;i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge:edges){
            degree[edge[0]]++;//计算edge[0]节点的度数
            degree[edge[1]]++;//计算edge[1]节点的度数
            map.get(edge[0]).add(edge[1]);//跟edge[0]相邻的节点
            map.get(edge[1]).add(edge[0]);//跟edge[1]相邻的节点
        }
//      2.创建队列
        Queue<Integer> queue = new LinkedList<>();

//      3.在队列中加入第一个满足条件的元素
        for (int i = 0;i < n;i++){
            if (degree[i] == 1){//度数为1，说明是叶子结点,入队列
                queue.offer(i);
            }
        }
//      4.while(队列不为空) {
//            取出队列头部元素
//            操作
//            根据头部元素，往队列中再次加入满足条件的元素
//        }
        while (!queue.isEmpty()){
            ans=new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                int cur = queue.poll();
                ans.add(cur);
                List<Integer> nexts = map.get(cur);
                for (Integer next:nexts){
                    degree[next]--;//删除叶子节点后，跟其相邻的节点的度数要减少
                    if (degree[next] == 1){
                        queue.offer(next);
                    }
                }
            }
        }

        return  ans;
    }
}
