package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/25 4:12 下午
 */
public class SumOfDistancesInTree836 {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 1 && edges.length == 0) {
            return new int[]{0};
        }
        int[] layer = new int[N];
        int[] degrees = new int[N];
        int[] ans = new int[N];
        boolean[] flags = new boolean[N];
        LinkedList<Integer> queue = new LinkedList<>();
        // 构造临接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(flags, false);
            boolean found = false;
            for (int k = 0; k < i; k++) {
                if (layer[k] == layer[i] && layer[i] != 0 && degrees[k] == degrees[i]) {
                    ans[i] = ans[k];
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }
            queue.addLast(i);
            int depth = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int node = queue.poll();
                    layer[i] = depth;
                    flags[node] = true;
                    for (int adjNode: adj.get(node)) {
                        if (!flags[adjNode]) {
                            ans[i] += depth + 1;
                            queue.addLast(adjNode);
                        }
                    }
                }
                depth++;
            }
        }
        return ans;
    }
}
