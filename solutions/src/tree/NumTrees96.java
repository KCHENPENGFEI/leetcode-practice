package tree;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 假设f(i)为以i为根节点能够产生二叉树的数量，那么
 * G(n) = f(0) + f(1) + f(2) + .. + f(n)
 * 又因为f(i) = G(i-1)*G(n-i)，因为左子树有i-1个节点，右子树有n-i个节点
 * 所以G(n) = G(0)G(n-1) + G(1)G(n-2) + ... + G(n-1)G(0)
 * */
public class NumTrees96 {

    // 使用递归计算，但是结果超过了时间限制
    public int genAns(int start, int end) {
        int result = 0;
        if (start > end) {
            return 1;
        }
        // 如果start == end，直接返回节点，这样可以少一层递归循环
        if (start == end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {
            int leftNum = genAns(start, i - 1);
            int rightNum = genAns(i + 1, end);
            result += leftNum * rightNum;
        }
        return result;
    }

    public int numTrees(int n) {
        // 动态规划
        // G(n) = G(0)G(n-1) + G(1)G(n-2) + ... + G(n-1)G(0)
        // 因为n从1开始
        n = n + 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n - 1];
    }
}


