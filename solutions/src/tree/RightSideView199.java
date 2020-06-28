package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 做法1: 层序遍历二叉树,然后返回每一层最右边的节点（也就是数组最后一个元素）
 * */
public class RightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<List<Integer>> allNodes = travel(root);
        for (List<Integer> node: allNodes) {
            if (node.size() == 0) {
                continue;
            }
            result.add(node.get(node.size() - 1));
        }
        return result;
    }

    private List<List<Integer>> travel(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 压入root
        stack.addLast(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                if (cur == null) {
                    continue;
                }
                nodes.add(cur.val);
                stack.addLast(cur.left);
                stack.addLast(cur.right);
            }
            if (nodes.size() != 0) {
                result.add(nodes);
            }
        }
        return result;
    }
}
