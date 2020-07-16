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
 * 常规思路：
 * 找到节点后，如果左子树为空，返回右子树
 * 如果右子树为空，返回左子树
 * 如果都不为空，那么就把root的左子树挂在右子树的最左下角，然后返回右子树即可
 */
public class DeleteNode450 {
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode1(root.right, key);
        }
        else if (root.val > key) {
            root.left = deleteNode1(root.left, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            else {
                TreeNode node = root.right;
//                TreeNode newNode = new TreeNode(node.val);
//                newNode.right = node.right;
//                newNode.left = node.left;
//                TreeNode pointer = newNode;
//                while (pointer.left != null) {
//                    pointer = pointer.left;
//                }
//                pointer.left = root.left;
//                return newNode;
                while (node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return deleteRoot(root);
        }
        // 此处可以加一句判断该节点在左子树还是右子树，只需要操作一半就可
        TreeNode left = deleteNode(root.left, key);
        TreeNode right = deleteNode(root.right, key);
        root.left = left;
        root.right = right;
        return root;
    }

    private TreeNode deleteRoot1(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode newRoot = new TreeNode(root.right.val);
        newRoot.left = root.right.left;
        newRoot.right = root.right.right;
        TreeNode pointer = newRoot.left;
        if (pointer == null) {
            newRoot.left = root.left;
            return newRoot;
        }
        while (pointer.left != null) {
            pointer = pointer.left;
        }
        pointer.left = root.left;
        return newRoot;
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
