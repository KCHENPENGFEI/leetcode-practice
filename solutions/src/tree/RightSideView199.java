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
        List<LinkedList<Integer>> allNodes = travel(root);
        for (LinkedList<Integer> node: allNodes) {
            result.add(node.pop());
        }
        return result;
    }

    private List<LinkedList<Integer>> travel(TreeNode root) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 压入root
        stack.addLast(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            LinkedList<Integer> nodes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                nodes.push(cur.val);
                if (cur.left != null) {
                    stack.addLast(cur.left);
                }
                if (cur.right != null) {
                    stack.addLast(cur.right);
                }
            }
            if (nodes.size() != 0) {
                result.add(nodes);
            }
        }
        return result;
    }
}
