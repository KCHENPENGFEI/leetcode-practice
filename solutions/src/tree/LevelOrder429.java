package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉数的层序遍历
 * */
public class LevelOrder429 {
    public List<List<Integer>> levelOrder(NNode root) {
        LinkedList<NNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 将root放入queue
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NNode cur = queue.poll();
                 if (cur == null) {
                     continue;
                 }
                layer.add(cur.val);
                for (NNode child: cur.children) {
                    // if (child == null) {
                    //     continue;
                    // }
                    queue.addLast(child);
                }
            }
            if (!layer.isEmpty()) {
                result.add(layer);
            }
        }
        return result;
    }
}

