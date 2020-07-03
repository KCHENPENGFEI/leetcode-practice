package tree;

import java.util.LinkedList;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * */
public class LowestCommonAncestor236 {
    boolean found = false;
    LinkedList<TreeNode> path;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        LinkedList<TreeNode> pPath = findPath(root, p);
        found = false;
        LinkedList<TreeNode> qPath = findPath(root, q);
        int pSize = pPath.size();
        int qSize = qPath.size();
        TreeNode pre = null;
        for (int i = 0; i < Math.min(pSize, qSize); i++) {
            TreeNode pPop = pPath.pop();
            TreeNode qPop = qPath.pop();
            if (pPop == qPop) {
                pre = pPop;
                continue;
            }
            break;
        }
        return pre;
    }

    // 递归做法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }

    private LinkedList<TreeNode> findPath(TreeNode root, TreeNode node) {
        LinkedList<TreeNode> track = new LinkedList<>();
        trackback(track, root, node);
        return path;
    }

    private void trackback(LinkedList<TreeNode> track, TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        if (root == node) {
            // 找到
            track.addLast(root);
            found = true;
            path = new LinkedList<>(track);
        }
        if (found) {
            return;
        }
        track.addLast(root);
        // 遍历左树
        trackback(track, root.left, node);
        // 遍历右树
        trackback(track, root.right, node);
        // 删除选择
        track.removeLast();
    }
}
