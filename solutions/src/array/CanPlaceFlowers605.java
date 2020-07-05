package array;

/**
 * @author chenpengfei
 * @date 2020/7/5 3:31 下午
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * 做法: 使用贪心算法，能种植的位置直接种植花，遍历结束后如果还有花剩余那么久返回false
 */
public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int len = flowerbed.length;
        if (len == 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (n == 0) {
                return true;
            }
            if (canPlace(flowerbed, i, len)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }

    public boolean canPlace(int[] nums, int index, int len) {
        if (nums[index] == 1) {
            return false;
        }
        if (len == 1 && nums[index] == 0) {
            return true;
        }
        if (index == 0) {
            return nums[index + 1] == 0;
        }
        if (index == len - 1) {
            return nums[index - 1] == 0;
        }
        return nums[index - 1] == 0 && nums[index + 1] == 0;
    }
}
