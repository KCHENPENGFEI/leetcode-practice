package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从底部层序遍历二叉树
 * */
public class LevelOrderBottom107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        levelOrder(ans, root);
        return ans;
    }

    public void levelOrder(LinkedList<List<Integer>> result, TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return;
        }
        // 添加第一个节点
        stack.addLast(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> node = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                node.add(cur.val);
                // 添加后续节点
                if (cur.left != null) {
                    stack.addLast(cur.left);
                }
                if (cur.right != null) {
                    stack.addLast(cur.right);
                }
            }
            if (node.size() > 0) {
                result.addFirst(new ArrayList<>(node));
            }
        }
    }
}
