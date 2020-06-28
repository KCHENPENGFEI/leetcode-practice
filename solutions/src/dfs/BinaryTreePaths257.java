package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 这里需要注意的是要统计节点的位数，还要注意节点数值的正负，然后回溯的时候才能正确删除掉数据
 * */
public class BinaryTreePaths257 {
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder track = new StringBuilder();
        trackback(track, root);
        return result;
    }

    private void trackback(StringBuilder track, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 子节点直接处理不进入下一层
            track.append(root.val);
            int len = numLen(root.val);
            result.add(track.toString());
            // 删除数值
            track.delete(track.length() - len, track.length());
            return;
        }
        track.append(root.val);
        track.append("->");
        int len = numLen(root.val);
        // 遍历左子树
        trackback(track, root.left);
        // 遍历右子树
        trackback(track, root.right);
        // 删除
        track.delete(track.length() - len - 2, track.length());
    }

    private int numLen(int num) {
        if (num == 0) {
            return 1;
        }
        int len = 0;
        int numAbs = Math.abs(num);
        while (numAbs > 0) {
            numAbs = numAbs / 10;
            len++;
        }
        return num > 0? len: len + 1;
    }
}
