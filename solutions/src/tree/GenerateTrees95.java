package tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees95 {
    public static void main(String[] args) {
        int n = 3;
        GenerateTrees95 generateTrees95 = new GenerateTrees95();
        generateTrees95.generateTrees(n);
    }
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> generateTrees(int n) {
//        List<Integer> choose = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            choose.add(i);
//        }
//        trackback(null, null, choose, n);
//        return result;
        if (n <= 0) {
            return new ArrayList<>();
        }
        return genAns(1, n);
    }

    // 递归做法
    // 思路如下: 利用二叉搜索树的特点，左子节点小于root，右子节点大于root
    // 将[start,end]区间做以下划分[start, i - 1]和[i + 1, end]，那么前个区间只能挂在左边，后一个区间只能挂在右边
    // 要注意的前区间和后区间形成的解的个数可能会有多个，需要用两层for循环将全部解表示出来
    public List<TreeNode> genAns(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        // 如果start == end，直接返回节点，这样可以少一层递归循环
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = genAns(start, i - 1);
            List<TreeNode> right = genAns(i + 1, end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    // 依次将l和r连接到root
                    TreeNode parent = new TreeNode(i, l, r);
                    result.add(parent);
                }
            }
        }
        return result;
    }

    public void trackback(TreeNode root, TreeNode cur, List<Integer> choose, int n) {
        if (choose.size() == 0) {
            // 出口
            // 拷贝
            result.add(copyTree(root));
            return;
        }
        for (int i = 0; i < choose.size(); i++) {
            int num = choose.get(i);
            TreeNode node = new TreeNode(num);
            TreeNode parent = null;
            if (choose.size() == n) {
                root = node;
                cur = node;
            }
            else {
                if (node.val < cur.val) {
                    // 挂在左边
                    cur.left = node;
                    parent = cur;
                    cur = node;
                }
                else {
                    // 挂在右边
                    cur.right = node;
                    parent = cur;
                    cur = node;
                }
            }
            // 更改choose
            choose.remove(Integer.valueOf(num));
            trackback(root, cur, choose, n);
            if (parent != null) {
                parent.left = null;
                parent.right = null;
                cur = parent;
            }
            // 归位
            choose.add(i, node.val);
        }
    }

    public TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = copyTree(root.left);
        TreeNode right = copyTree(root.right);
        return new TreeNode(root.val, left, right);
    }
}
