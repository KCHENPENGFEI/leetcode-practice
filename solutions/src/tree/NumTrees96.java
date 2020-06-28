package tree;

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
}


