package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：使用动态规划，也可以说是使用指针
 * 定义三个指针分别指向当前2、3、5数字需要乘上的对象的位置
 * 起初指针都在0位置，对比p1 * 2, p2 * 3, p3 * 5的大小，将最小的插入数组
 * 然后将对应的指针向后移动一个位置，重复上述过程，注意要删除重复的元素。
 *
 * */
public class NthUglyNumber264 {
    public int nthUglyNumber(int n) {
        int i = 0, j = 0, k = 0;
        List<Integer> res = new ArrayList<>(Arrays.asList(1));

        while (res.size() < n) {
            int min = Math.min(Math.min(res.get(i) * 2, res.get(j) * 3), res.get(k) * 5);
            if (res.get(res.size() - 1) != min) {
                res.add(min);
            }

            if (min == res.get(i) * 2) {
                i++;
            }
            else if (min == res.get(j) * 3) {
                j++;
            }
            else {
                k++;
            }
        }
        return res.get(res.size() - 1);
    }
}
