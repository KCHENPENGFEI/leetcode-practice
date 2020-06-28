package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 使用回溯法，回溯时候要删除已经选择的元素
 * */
public class PathSum113 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> track = new ArrayList<>();
        trackback(track, root, sum);
        return result;
    }

    public void trackback(List<Integer> track, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        track.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            // 找到一条路径
            result.add(new ArrayList<>(track));
            // 删除最后一个元素
            track.remove(track.size() - 1);
            return;
        }
        trackback(track, root.left, sum - root.val);
        trackback(track, root.right, sum - root.val);
        // 没找到，但是要删除最后一个元素
        track.remove(track.size() - 1);
    }
}
