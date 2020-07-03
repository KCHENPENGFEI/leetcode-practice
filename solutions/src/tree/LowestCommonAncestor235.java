package tree;

import java.util.LinkedList;

public class LowestCommonAncestor235 {
    boolean found = false;
    LinkedList<TreeNode> result = new LinkedList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pPath = findPath(root, p);
        found = false;
        LinkedList<TreeNode> qPath = findPath(root, q);
        TreeNode pre = null;
        int pSize = pPath.size();
        int qSize = qPath.size();
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
        return result;
    }

    private void trackback(LinkedList<TreeNode> track, TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        if (root == node) {
            track.addLast(root);
            result = new LinkedList<>(track);
            found = true;
            return;
        }
        if (found) {
            return;
        }
        track.addLast(root);
        if (node.val < root.val) {
            // 搜索左子树
            trackback(track, root.left, node);
            // System.out.println("left");
        }
        else if (node.val > root.val) {
            // 搜索右子树
            trackback(track, root.right, node);
            // System.out.println("right");
        }
        else {
            trackback(track, root.left, node);
            trackback(track, root.right, node);
        }
        track.removeLast();
    }
}
