package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 需要注意的是只需要在添加结果的时候注意方向即可，使用LinkedList来保存这样就可以addFirst和addLast，
 * 在遍历树的时候只管从左到右遍历即可
 * */
public class ZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, root);
        return ans;
    }

    public void helper(List<List<Integer>> result, TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return;
        }
        TreeNode tmp = root;
        // 将root放入队列
        stack.push(root);

        boolean reverse = false;
        while (!stack.isEmpty()) {
            int size = stack.size();
            LinkedList<Integer> layerContent = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.removeFirst();
                if (cur == null) {
                    continue;
                }
                if (reverse) {
                    layerContent.addFirst(cur.val);
                }
                else {
                    layerContent.addLast(cur.val);
                }
                stack.addLast(cur.left);
                stack.addLast(cur.right);
            }
            reverse = !reverse;
            if (layerContent.size() != 0) {
                result.add(layerContent);
            }
        }
    }
}
