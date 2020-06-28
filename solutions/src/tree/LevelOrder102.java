package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 树的层序遍历
 * 做法: 使用队列进行辅助，每遍历一层就加入队列，需要注意的是要同时统计树的深度
 * */
public class LevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(tmp, root);
        List<Integer> dRes = tmp.get(0);
        List<Integer> aRes = tmp.get(1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < dRes.size(); i++) {
            if (i == 0) {
                list.add(aRes.get(i));
            }
            else {
                if (dRes.get(i) > dRes.get(i - 1)) {
                    result.add(list);
                    list = new ArrayList<>();
                    list.add(aRes.get(i));
                }
                else {
                    list.add(aRes.get(i));
                }
            }
        }
        result.add(list);
        return result;
    }

    public void helper(List<List<Integer>> result, TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        List<Integer> dRes = new ArrayList<>();
        List<Integer> aRes = new ArrayList<>();
        int depth = 1;
        if (root != null) {
            stack.addLast(root);
            depths.addLast(depth);
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            aRes.add(cur.val);
            depth = depths.pop();
            dRes.add(depth);
            if (cur.left != null || cur.right != null) {
                ++depth;
            }
            if (cur.left != null) {
                stack.addLast(cur.left);
                depths.addLast(depth);
            }
            if (cur.right != null) {
                stack.addLast(cur.right);
                depths.addLast(depth);
            }

        }
        result.add(dRes);
        result.add(aRes);
    }
}
