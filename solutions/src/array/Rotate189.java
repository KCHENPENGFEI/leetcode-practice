package array;

/**
 * @author chenpengfei
 * @date 2020/7/4 10:41 上午
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 做法: a[0] -> a[k], a[k] -> a[2k], ...如果出现循环的情况则继续进行a[1] -> a[1 + k], ...
 */
public class Rotate189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        int kMin = k % len;
        int cnt = 0;
        // 这里需要注意的是判断条件为cnt < len，因为cnt = len就说明已经完全旋转好了
        for (int start = 0; cnt < len; start++) {
            int cur = start;
            int pre = nums[cur];
            do {
                int nextId = (cur + kMin) % len;
                int tmp = nums[nextId];
                nums[nextId] = pre;
                pre = tmp;
                cur = nextId;
                cnt++;
            } while (cur != start);
        }
    }
}
