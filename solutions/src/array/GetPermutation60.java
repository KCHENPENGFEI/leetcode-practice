package array;

import java.util.Arrays;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 做法: 使用getNext获取下一个数值，找到第一个降序的位置，使用next函数获取下一个数值，做法同31题
 * */
public class GetPermutation60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        String res = sb.toString();
        for (int i = 1; i < k; i++) {
            res = getNext(res);
        }
        return res;
    }

    private String getNext(String s) {
        // 从尾部开始遍历搜索
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            // 找到第一个降序的index
            if (s.charAt(i) < s.charAt(i + 1)) {
                return next(s.toCharArray(), i);
            }
        }
        return s;
    }

    private String next(char[] arr, int index) {
        int len = arr.length;
        // 找到比arr[index]大的数字中的最小值，交换位置
        int id = index + 1;
        char min = arr[id];
        for (int i = id; i < len; i++) {
            if (arr[i] > arr[index] && arr[i] < min) {
                // 更新id和min
                id = i;
                min = arr[i];
            }
        }
        // 交换arr[index]和arr[id]
        char tmp = arr[index];
        arr[index] = arr[id];
        arr[id] = tmp;
        // 排序index + 1之后的队列
        Arrays.sort(arr, index + 1, len);
        return charArr2String(arr);
    }

    private String charArr2String(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
