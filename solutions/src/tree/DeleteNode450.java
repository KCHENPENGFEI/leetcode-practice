package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/23 11:16 下午
 *
 * 450. 删除二叉搜索树中的节点，给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 做法: 找到key对应的树的树根，然后转换成list，删除对应的元素，然后重新构建树，然后在deleteNode中将树拼接好
 */
public class DeleteNode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return deleteRoot(root);
        }
        TreeNode left = deleteNode(root.left, key);
        TreeNode right = deleteNode(root.right, key);
        root.left = left;
        root.right = right;
        return root;
    }

    private TreeNode deleteRoot(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        return builder(list);
    }

    private void helper(TreeNode root, List<Integer> list, int cnt) {
        if (root == null) {
            return;
        }
        helper(root.left, list, cnt + 1);
        if (cnt != 0) {
            list.add(root.val);
        }
        helper(root.right, list, cnt + 1);
    }

    private TreeNode builder(List<Integer> list) {
        TreeNode pre = new TreeNode(0);
        TreeNode cur = pre;
        for (int i: list) {
            cur.right = new TreeNode(i);
            cur = cur.right;
        }
        return pre.right;
    }
}
