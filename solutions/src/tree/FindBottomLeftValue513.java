package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 做法: 二叉树的层序遍历
 * */
public class FindBottomLeftValue513 {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> mostLeft = new ArrayList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean insert = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                 if (cur == null) {
                     continue;
                 }
                if (!insert) {
                    mostLeft.add(cur.val);
                    insert = true;
                }
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
        }
        return mostLeft.get(mostLeft.size() - 1);
    }
}
