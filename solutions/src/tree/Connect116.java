package tree;

/**
 * 给定一个完美二叉树，填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * */
public class Connect116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            // 子节点
            return root;
        }
        // node左子树的next就是node的右子树
        root.left.next = root.right;
        // node右子树的next就是node.next的左子树
        root.right.next = root.next == null? null: root.next.left;
        // 递归左子树
        connect(root.left);
        // 递归右子树
        connect(root.right);
        return root;
    }
}
